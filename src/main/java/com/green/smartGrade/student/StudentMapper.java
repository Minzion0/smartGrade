package com.green.smartGrade.student;

import com.green.smartGrade.student.model.StudentInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    int insSdy(StudentInsDto dto);
}
