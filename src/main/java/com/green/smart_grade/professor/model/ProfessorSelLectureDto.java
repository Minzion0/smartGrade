package com.green.smart_grade.professor.model;

import com.green.smart_grade.utils.PagingUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class ProfessorSelLectureDto {
    private int iprofessor;
    private int startIdx;
    private int page;
}
