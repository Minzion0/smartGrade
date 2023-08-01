package com.green.smartGrade.admin.major.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class MajorfindRes {
    private PagingUtils page;
    private List<MajorVo> major;
}
