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
