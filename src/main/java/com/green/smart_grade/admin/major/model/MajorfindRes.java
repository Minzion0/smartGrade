package com.green.smart_grade.admin.major.model;

import com.green.smart_grade.admin.professor.model.AdminFindProfessorRes;
import com.green.smart_grade.utils.PagingUtils;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class MajorfindRes {
    private PagingUtils page;
    private List<MajorVo> major;
}
