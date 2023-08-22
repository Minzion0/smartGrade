package com.green.smartGrade.admin.grade_mngmn;

import com.green.smartGrade.admin.grade_mngmn.model.*;
import com.green.smartGrade.professor.professorgradeMngmn.model.ProfessorGradeUpdDto;
import com.green.smartGrade.professor.professorgradeMngmn.model.ProfessorGradeUpdParam;
import com.green.smartGrade.professor.professorgradeMngmn.model.ProfessorGradeUpdRes;
import com.green.smartGrade.utils.GradeUtils;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GradeMngmnService {

    @Autowired
    private final GradeMngmnMapper MAPPER;

    public GradeMngmnRes insGradeMngmn(GradeMngmnInsParam p) {
        GradeMngmnInsDto dto = new GradeMngmnInsDto();
        dto.setIsemester(p.getIsemester());
        dto.setIstudent(p.getIstudent());
        dto.setSemester(p.getSemester());
        dto.setIlectureName(p.getIlectureName());
        int result = MAPPER.insGradeMngmn(dto);
        if (result == 1) {
            GradeMngmnRes.builder()
                    .istudent(dto.getIstudent())
                    .isemester(dto.getIsemester())
                    .ilectureName(dto.getIlectureName())
                    .semester(dto.getSemester())
                    .build();
        }
        return null;
    }

    public GradeUpdRes updAvgScore(GradeUpdParam p) {
        GradeUpdDto dto = new GradeUpdDto();
        dto.setSemester(p.getSemester());
        dto.setIstudent(p.getIstudent());


        GradeAvgVo vo = MAPPER.selAvgScore(dto);
        dto.setAvgScore(vo.getAvgScore());



        GradeUtils utils = new GradeUtils();
        int score = vo.getAvgScore();
        double v = utils.totalScore2(score);
        p.setAvgScore(score);



        dto.setAvgRating(v);
        int result = MAPPER.updAvgScore(dto);


        return GradeUpdRes.builder()
                .istudent(p.getIstudent())
                .semester(p.getSemester())
                .avgScore(p.getAvgScore())
                .avgRating(p.getAvgRating())
                .build();


    }


    public GradeMngmnDetailAvgVo selGradeFindStudentVo(GradeMngmnAvgDto dto) {
        int maxPage = MAPPER.countGradeFindStudent();

        PagingUtils utils = new PagingUtils(dto.getPage(), maxPage);
        dto.setStaIdx(utils.getStaIdx());

        if (dto.getStudentNum() != null) {
            dto.setStudentNum(dto.getStudentNum().replaceAll(" ", ""));
        }

        GradeMngmnStudentVo student = MAPPER.selGradeMngmnStudent(dto);
        List<GradeMngmnAvgVo> mngmnAvg = MAPPER.GradeMngmnAvg(dto);
        List<GradeMngmnVo> voList = MAPPER.selGradeFindStudent(dto);

        int point;
        double score;
        String rating;
        for (GradeMngmnVo a : voList) {
            point = a.getTotalScore();
            GradeUtils utils2 = new GradeUtils(point);
            score = utils2.totalScore();
            rating = utils2.totalRating(score);
            a.setRating(rating);
        }

        return GradeMngmnDetailAvgVo.builder()
                .voList(voList)
                .student(student)
                .avgVo(mngmnAvg)
                .page(utils)
                .build();

    }

    public GradeMngmnDetailVo selGradeFindStudentDetail(GradeMngmnDetailSelDto dto) {
        return MAPPER.selGradeFindStudentDetail(dto);
    }
}
