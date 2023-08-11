package com.green.smartGrade.student.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentDatilProFileVo {
    List<StudentMajor> lectureList;
    StudentSelProfile profile;
}
