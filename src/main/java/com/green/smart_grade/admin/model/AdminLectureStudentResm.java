package com.green.smart_grade.admin.model;

import com.green.smart_grade.utils.PagingUtils;
import lombok.Data;

import java.util.List;

@Data
public class AdminLectureStudentResm {
    private PagingUtils page;
    private List<AdminLectureInStudentRes> list;
}
