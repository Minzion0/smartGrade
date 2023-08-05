package com.green.smartGrade.admin.student.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AdminStudentRes {
    private PagingUtils page;
    private List<AdminFindStudentRes> students;
}
