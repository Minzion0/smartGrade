package com.green.smart_grade.professor.professorgradeMngmn.model;

import lombok.Data;

@Data
public class ProfessorGradeMngmnUpParam {

    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private int totalScore;
    private int finishedYn;

}
