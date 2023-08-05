package com.green.smartGrade.professor.professorgradeMngmn.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class ProfessorGradeMngmnSelRES {
    private PagingUtils page;
    private List<ProfessorGradeMngmnSelVo> list;
}
