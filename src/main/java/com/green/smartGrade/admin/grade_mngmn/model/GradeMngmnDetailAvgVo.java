package com.green.smartGrade.admin.grade_mngmn.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GradeMngmnDetailAvgVo {
    private PagingUtils page;
    private GradeMngmnStudentVo student;
    private List<GradeMngmnVo> voList;
    private List<GradeMngmnAvgVo> avgVo;

}
