package com.green.smart_grade.professor.professorgradeMngmn.model;

import com.green.smart_grade.utils.PagingUtils;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class ProfessorGradeMngmnSelRES {
    private PagingUtils page;
    private List<ProfessorGradeMngmnSelVo> list;
}
