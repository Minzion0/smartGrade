package com.green.smart_grade.professor.professorgradeMngmn.model;

import com.green.smart_grade.utils.PagingUtils;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class professorGradeMngmnUpRes {

    private int attendance;
    private int midtermExamination;
    private int finalExamination;
    private int totalScore;
    private int finishedYn;

    private Long ilectureStudent;
    private Long ipofessor;

    public professorGradeMngmnUpRes(professorgradeMngmnUpDto dto) {

        this.attendance = dto.getAttendance();
        this.midtermExamination = dto.getMidtermExamination();
        this.finalExamination = dto.getFinalExamination();
        this.totalScore = dto.getTotalScore();
        this.finishedYn = dto.getFinishedYn();

    }
}
