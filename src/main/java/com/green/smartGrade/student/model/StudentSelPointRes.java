package com.green.smartGrade.student.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StudentSelPointRes {
    private List<StudentSelPointVo> list;
}
