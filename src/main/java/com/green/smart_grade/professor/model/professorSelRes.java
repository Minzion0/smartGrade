package com.green.smart_grade.professor.model;

import com.green.smart_grade.utils.PagingUtils;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class professorSelRes {
    private PagingUtils page;
    private List<ProfessorVo> list;
}
