package com.green.smartGrade.professor.professorgradeMngmn;

import com.green.smartGrade.professor.professorgradeMngmn.model.*;
import com.green.smartGrade.utils.GradeUtils;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class ProfessorGradeMngmnService {
    private final ProfessorGradeMngmnMapper mapper;


    public ProfessorGradeMngmnUpRes upMngnm(ProfessorGradeMngmnUpParam param, Long iprofessor, Long ilecture,Long ilectureStudent ) {

        ProfessorGradeMngmnUpDto dto = new ProfessorGradeMngmnUpDto();
        String msg="";
        ProfessorGradeMngmnUpRes res = new ProfessorGradeMngmnUpRes();


        dto.setIlectureStudent(ilectureStudent);
        dto.setIlecture(ilecture);
        dto.setIpofessor(iprofessor);
        dto.setFinishedYn(1);



        int attendance = param.getAttendance();
        int midtermExamination = param.getMidtermExamination();
        int finalExamination = param.getFinalExamination();


        // 각 점수들의 최대 값을 가져오기
        int maxAttendance = mapper.getMaxAttendance(ilecture);
        int maxMidtermExamination = mapper.getMaxMidtermExamination(ilecture);
        int maxFinalExamination = mapper.getMaxFinalExamination(ilecture);


            // 점수가 최대 값을 넘지 않도록 예외처리
            if (attendance > maxAttendance) {
                msg += "출석 점수가 최대값을 넘을 수 없습니다.";
                res.setMsg(msg);
                return res;
            }
            if (midtermExamination > maxMidtermExamination) {
                msg +="중간고사 점수가 최대값을 넘을 수 없습니다.";
                res.setMsg(msg);
                return res;
            }
            if (finalExamination > maxFinalExamination) {
                msg += "기말고사 점수가 최대값을 넘을 수 없습니다.";
                res.setMsg(msg);
                return res;
            }

            dto.setAttendance(attendance);
            dto.setMidtermExamination(midtermExamination);
            dto.setFinalExamination(finalExamination);

        int point = dto.getAttendance() + dto.getMidtermExamination() + dto.getFinalExamination();
        GradeUtils gradeUtils = new GradeUtils(point);
        double score = gradeUtils.totalScore();
        String rating = gradeUtils.totalRating(score);
        dto.setTotalScore(point);
        dto.setPoint(point);
        dto.setRating(rating);

        try {
        int result = mapper.upMngnm(dto);
        if (result == 1) {
            res = new ProfessorGradeMngmnUpRes(dto);
            res.setIpofessor(iprofessor);
            res.setIlecture(ilecture);
            return res;
        }
        } catch (IllegalArgumentException ex) {
           ex.printStackTrace();
        }
        return  null;
    }

    public ProfessorGradeUpdRes updAvgScore(ProfessorGradeUpdParam p) {
        ProfessorGradeUpdDto dto = new ProfessorGradeUpdDto();
        dto.setSemester(p.getSemester());
        dto.setIstudent(p.getIstudent());
        GradeUtils utils = new GradeUtils(p.getTotalScore());
        double score = utils.totalScore();

        mapper.updAvgScore(dto);

        return ProfessorGradeUpdRes.builder()
                .rating(score)
                .build();
    }



    public  ProfessorGradeMngmnSelRES selStudentScore (ProfessorGradeMngmnSelDto dto) {
        int maxPage = mapper.selStudentScoreCount(dto);
        PagingUtils utils = new PagingUtils(dto.getPage(), maxPage);
        dto.setStaIdx(utils.getStaIdx());

        List<ProfessorGradeMngmnSelVo> list = mapper.selStudentScore(dto);
        int point;
        double score;
        String rating;
        for (ProfessorGradeMngmnSelVo vo : list) {
            point = vo.getAttendance() + vo.getMidtermExamination() + vo.getFinalExamination();
            GradeUtils gradeUtils = new GradeUtils(point);
            score =  gradeUtils.totalScore();
            rating = gradeUtils.totalRating(score);
            vo.setGrade(rating);
            vo.setPoint(score);
        }
        return ProfessorGradeMngmnSelRES .builder()
                .list(list)
                .page(utils)
                .build();
    }


}
