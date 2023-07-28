package com.green.smart_grade.admin.professor.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AdminProfessorDetailVo {
    List<AdminProfessorMajor> majorList;
    AdminProfessorDetailProfile profile;

}
