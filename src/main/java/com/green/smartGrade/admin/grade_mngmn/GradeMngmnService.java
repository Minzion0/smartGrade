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

        GradeMngmnAvgVo avgVo = MAPPER.GradeMngmnAvg(dto);
        List<GradeMngmnVo> student = MAPPER.selGradeFindStudent(dto);


        return GradeMngmnDetailAvgVo.builder()
                .voList(student)
                .avgVo(avgVo)
                .page(utils)
                .build();

    }

    public GradeMngmnDetailVo selGradeFindStudentDetail(GradeMngmnDetailSelDto dto) {
        return MAPPER.selGradeFindStudentDetail(dto);
    }
}
