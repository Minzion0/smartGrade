package com.green.smart_grade.professor.professorgradeMngmn;

import com.green.smart_grade.professor.professorgradeMngmn.model.professorgradeMngmnUpDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface professorGradeMngmnMapper {

    int upMngnm(professorgradeMngmnUpDto dto);


}
