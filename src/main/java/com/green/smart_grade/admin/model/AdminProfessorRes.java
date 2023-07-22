package com.green.smart_grade.admin.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AdminProfessorRes {
    private int page;
    private int maxPage;
    private int isMore;
    private List<AdminFindProfessorRes> professors;
}
