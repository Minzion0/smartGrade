package com.green.smart_grade.professor.professorgradeMngmn;

import com.green.smart_grade.professor.professorgradeMngmn.model.*;
import com.green.smart_grade.utils.GradeUtils;
import com.green.smart_grade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class ProfessorGradeMngmnService {
    private final ProfessorGradeMngmnMapper mapper;


    public ProfessorGradeMngmnUpRes upMngnm(ProfessorGradeMngmnUpParam param, Long iprofessor, Long ilectureStudent ) {

        ProfessorGradeMngmnUpDto dto = new ProfessorGradeMngmnUpDto();
        dto.setIlectureStudent(ilectureStudent);
        dto.setIpofessor(iprofessor);
        dto.setFinishedYn(param.getFinishedYn());


        int attendance = param.getAttendance();
        int midtermExamination = param.getMidtermExamination();
        int finalExamination = param.getFinalExamination();

        // 각 점수들의 최대 값을 가져오기
        int maxAttendance = mapper.getMaxAttendance(iprofessor);
        int maxMidtermExamination = mapper.getMaxMidtermExamination(iprofessor);
        int maxFinalExamination = mapper.getMaxFinalExamination(iprofessor);

        try {
            // 점수가 최대 값을 넘지 않도록 예외처리
            if (attendance > maxAttendance) {
                throw new IllegalArgumentException("출석 점수가 최대값을 넘을 수 없습니다.");
            }
            if (midtermExamination > maxMidtermExamination) {
                throw new IllegalArgumentException("중간고사 점수가 최대값을 넘을 수 없습니다.");
            }
            if (finalExamination > maxFinalExamination) {
                throw new IllegalArgumentException("기말고사 점수가 최대값을 넘을 수 없습니다.");
            }

            dto.setAttendance(attendance);
            dto.setMidtermExamination(midtermExamination);
            dto.setFinalExamination(finalExamination);

       int point = dto.getAttendance()+dto.getMidtermExamination()+dto.getFinalExamination();
        GradeUtils gradeUtils = new GradeUtils(point);
        double score =  gradeUtils.totalScore();
        String rating = gradeUtils.totalRating(score);
        dto.setTotalScore(point);
        dto.setPoint(point);
        dto.setRating(rating);

        int result = mapper.upMngnm(dto);
        if (result == 1) {
            ProfessorGradeMngmnUpRes res = new ProfessorGradeMngmnUpRes(dto);
            res.setIpofessor(iprofessor);
            res.setIlectureStudent(ilectureStudent);
            return res;
        }
        } catch (IllegalArgumentException ex) {
           ex.printStackTrace();
        }
        return  null;
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
