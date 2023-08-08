package com.green.smartGrade.admin.professor.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AdminProfessorDetailVo {
    List<AdminProfessorMajor> lectureList;
    AdminProfessorDetailProfile profile;

}
