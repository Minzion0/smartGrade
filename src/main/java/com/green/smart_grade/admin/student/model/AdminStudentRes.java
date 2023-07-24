package com.green.smart_grade.admin.student.model;

import com.green.smart_grade.utils.PagingUtils;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AdminStudentRes {
    private PagingUtils page;
    private List<AdminFindStudentRes> studnets;
}
