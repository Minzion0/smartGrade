package com.green.smartGrade.statistics;

import com.green.smartGrade.statistics.model.StatisticsSelDto;
import com.green.smartGrade.statistics.model.StatisticsSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {
    List<StatisticsSelVo> selStatistics(StatisticsSelDto dto);
    int statisticsCount(Long ilecture);
}
