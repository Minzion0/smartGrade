package com.green.smart_grade.admin.grade_mngmn.model;

import com.green.smart_grade.utils.PagingUtils;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GradeMngmnDetailAvgVo {
    private PagingUtils page;
    private List<GradeMngmnVo> voList;
    private GradeMngmnAvgVo avgVo;
}
