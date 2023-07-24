package com.green.smart_grade.admin.grade_mngmn;

import com.green.smart_grade.admin.grade_mngmn.model.GradeMngmnDetailSelDto;
import com.green.smart_grade.admin.grade_mngmn.model.GradeMngmnDetailVo;
import com.green.smart_grade.admin.grade_mngmn.model.GradeMngmnSelDto;
import com.green.smart_grade.admin.grade_mngmn.model.GradeMngmnVo;
import com.green.smart_grade.utils.GradeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GradeMngmnService {

    @Autowired
    private final GradeMngmnMapper MAPPER;


    public GradeMngmnVo selGradeFindStudent(GradeMngmnSelDto dto) {
        return MAPPER.selGradeFindStudent(dto);
    }

    public GradeMngmnDetailVo selGradeFindStudentDetail(GradeMngmnDetailSelDto dto) {
        GradeUtils utils = new GradeUtils(dto.getTotalScore());
        dto.setRating(utils.TotalScore());
        return MAPPER.selGradeFindStudentDetail(dto);
    }
}
