package com.green.smart_grade.professor.model;

import com.green.smart_grade.utils.PagingUtils;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SelProfessorRes {
    private PagingUtils page;
    private List<ProfessorSelLectureVo> list;
}
