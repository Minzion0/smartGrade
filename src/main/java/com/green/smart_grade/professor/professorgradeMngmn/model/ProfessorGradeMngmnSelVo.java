package com.green.smart_grade.professor.professorgradeMngmn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

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
