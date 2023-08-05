package com.green.smartGrade.professor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfessorSelMngnmVo {
    private Long istudent;
    private Long imajor;
    private String majorName;
    private Long iprofessor;
    private String studentNum;
    private String name;
    private String lectureName;
    private String gender;
    private int phone;
    private String ceatedAt;
    private int finishedYn;
    private double rating;
}
