package com.green.smartGrade.student.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StudentSelProfileRes {
    private List<StudentSelProfileVo> list;
}
