package com.green.smartGrade.admin.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Data;

import java.util.List;

@Data
public class AdminLectureStudentResm {
    private PagingUtils page;
    private List<AdminLectureInStudentRes> list;
}
