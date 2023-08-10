package com.green.smartGrade.professor.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class professorSelRes {
    ProfessorVo list;

}
