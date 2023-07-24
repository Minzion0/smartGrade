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


    public GradeMngmnRes selGradeFindStudent(GradeMngmnSelDto dto, int page) {
        int maxPage = MAPPER.countGradeFindStudent();
        PagingUtils utils = new PagingUtils(page,maxPage);

        List<GradeMngmnVo> GradeMngmn = MAPPER.selGradeFindStudent(dto, utils.getStaIdx());
        return GradeMngmnRes.builder()
                .GradeMngmn(GradeMngmn)
                .page(utils)
                .build();
    }

    public GradeMngmnDetailVo selGradeFindStudentDetail(GradeMngmnDetailSelDto dto) {
        GradeUtils utils = new GradeUtils(dto.getTotalScore());
        dto.setRating(utils.TotalScore());
        return MAPPER.selGradeFindStudentDetail(dto);
    }
}
