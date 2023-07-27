package com.green.smart_grade.professor.professorgradeMngmn.model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class professorGradeMngmnUpParam {

    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private int totalScore;
    private int finishedYn;

}
