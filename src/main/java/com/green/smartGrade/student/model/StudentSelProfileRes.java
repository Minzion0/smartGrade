package com.green.smartGrade.student.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StudentSelProfileRes {
    private List<StudentSelProfile> list;
}
