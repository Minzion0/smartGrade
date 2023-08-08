package com.green.smartGrade.statistics.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StatisticsSelRes {
    private List<StatisticsSelVo> list;
}
