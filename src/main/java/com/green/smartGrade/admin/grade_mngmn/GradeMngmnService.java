package com.green.smartGrade.admin.grade_mngmn;

import com.green.smartGrade.admin.grade_mngmn.model.*;
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


    public GradeMngmnDetailAvgVo selGradeFindStudentVo(GradeMngmnAvgDto dto, int page) {
        int maxPage = MAPPER.countGradeFindStudent();

        PagingUtils utils = new PagingUtils(page, maxPage);

        if (dto.getStudentNum() != null) {
            dto.setStudentNum(dto.getStudentNum().replaceAll(" ", ""));
        }
        GradeMngmnAvgVo avgVo1 = MAPPER.GradeMngmnAvg1(dto);
        GradeMngmnAvgVo avgVo2 = MAPPER.GradeMngmnAvg2(dto);
        List<GradeMngmnVo> student = MAPPER.selGradeFindStudent(dto);

        int point;
        double score;
        String rating;
        for (GradeMngmnVo a : student) {
            point = a.getTotalScore();
            GradeUtils utils2 = new GradeUtils(point);
            score = utils2.totalScore();
            rating = utils2.totalRating(score);
            a.setRating(rating);
        }

        return GradeMngmnDetailAvgVo.builder()
                .voList(student)
                .avgVo1(avgVo1)
                .avgVo2(avgVo2)
                .page(utils)
                .build();

    }

    public GradeMngmnDetailVo selGradeFindStudentDetail(GradeMngmnDetailSelDto dto) {
        return MAPPER.selGradeFindStudentDetail(dto);
    }
}
