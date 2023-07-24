package com.green.smart_grade.admin.grade_mngmn.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GradeMngmnDetailVo {
    private String pic;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private String phone;
    private String student_num;
    private String majorName;
    private LocalDate createdAt;
    private String email;
    private int scoreStudent;
    private String rating;
}
