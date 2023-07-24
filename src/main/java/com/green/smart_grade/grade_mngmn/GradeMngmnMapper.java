package com.green.smart_grade.grade_mngmn;

import com.green.smart_grade.grade_mngmn.model.GradeMngmnDetailSelDto;
import com.green.smart_grade.grade_mngmn.model.GradeMngmnDetailVo;
import com.green.smart_grade.grade_mngmn.model.GradeMngmnSelDto;
import com.green.smart_grade.grade_mngmn.model.GradeMngmnVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GradeMngmnMapper {
    GradeMngmnVo selGradeFindStudent(GradeMngmnSelDto dto);
    GradeMngmnDetailVo selGradeFindStudentDetail(GradeMngmnDetailSelDto dto);

}
