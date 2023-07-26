package com.green.smart_grade.professor.model;

import com.green.smart_grade.utils.PagingUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class ProfessorSelLectureDto {
    private int iprofessor;
    private int staIdx;
    private int page;
    private String openingProcedures;
}
