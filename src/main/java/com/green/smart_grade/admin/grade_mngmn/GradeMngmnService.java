package com.green.smart_grade.admin.grade_mngmn;

import com.green.smart_grade.admin.grade_mngmn.model.*;
import com.green.smart_grade.utils.GradeUtils;
import com.green.smart_grade.utils.PagingUtils;
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


    public GradeMngmnFindRes selGradeFindStudent(GradeMngmnInsParam p, int page) {
        int maxPage = MAPPER.countGradeFindStudent();
        GradeMngmnUpdDto updDto = new GradeMngmnUpdDto();
        GradeMngmnSelDto dto = new GradeMngmnSelDto();
        PagingUtils utils = new PagingUtils(page,maxPage);
        GradeUtils gradeUtils = new GradeUtils(updDto.getTotalScore());

        updDto.setRating(gradeUtils.totalScore);
        dto.setStudentNum(p.getStudentNum());
        dto.setName(p.getName());
        dto.setIstudent(p.getIstudent());
        dto.setStrIdx(utils.getStaIdx());

        List<GradeMngmnVo> gradeMngmn = MAPPER.selGradeFindStudent(dto);
        return GradeMngmnFindRes.builder()
                .gradeMngmn(gradeMngmn)
                .page(utils)
                .build();
    }

    public GradeMngmnDetailVo selGradeFindStudentDetail(GradeMngmnDetailSelDto dto) {
        return MAPPER.selGradeFindStudentDetail(dto);
    }
}
