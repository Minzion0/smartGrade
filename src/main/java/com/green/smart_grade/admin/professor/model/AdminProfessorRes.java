package com.green.smart_grade.admin.professor.model;

import com.green.smart_grade.utils.PagingUtils;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AdminProfessorRes {
    private PagingUtils page;
    private List<AdminFindProfessorRes> professors;
}
