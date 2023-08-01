package com.green.smartGrade.professor.professorgradeMngmn.model;

import lombok.Data;

@Data
public class ProfessorGradeMngmnSelVo {
    private String studentNum;
    private String nm;
    private String majorName;
    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private double point; // 4.5
    private String grade = "A"; // A
}
