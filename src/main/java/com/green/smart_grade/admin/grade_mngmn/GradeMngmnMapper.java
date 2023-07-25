package com.green.smart_grade.admin.grade_mngmn;

import com.green.smart_grade.admin.grade_mngmn.model.GradeMngmnDetailSelDto;
import com.green.smart_grade.admin.grade_mngmn.model.GradeMngmnDetailVo;
import com.green.smart_grade.admin.grade_mngmn.model.GradeMngmnSelDto;
import com.green.smart_grade.admin.grade_mngmn.model.GradeMngmnVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMngmnMapper {
    List<GradeMngmnVo> selGradeFindStudent(GradeMngmnSelDto dto, int staIdx);

    GradeMngmnDetailVo selGradeFindStudentDetail(GradeMngmnDetailSelDto dto);

    int countGradeFindStudent();
}
