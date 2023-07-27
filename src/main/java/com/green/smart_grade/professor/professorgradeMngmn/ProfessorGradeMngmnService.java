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
        dto.setAttendance(param.getAttendance());
        dto.setFinishedYn(param.getFinishedYn());
        dto.setMidtermExamination(param.getMidtermExamination());
        dto.setFinalExamination(param.getFinalExamination());
        dto.setTotalScore(param.getTotalScore());



        int result = mapper.upMngnm(dto);
        if (result == 1) {
            ProfessorGradeMngmnUpRes res = new ProfessorGradeMngmnUpRes(dto);
            res.setIpofessor(iprofessor);
            res.setIlectureStudent(ilectureStudent);
            return res;
        }
        return null;

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
