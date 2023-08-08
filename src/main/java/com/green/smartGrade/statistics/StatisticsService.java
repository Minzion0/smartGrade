package com.green.smartGrade.statistics;

import com.green.smartGrade.statistics.model.StatisticsSelDto;
import com.green.smartGrade.statistics.model.StatisticsSelRes;
import com.green.smartGrade.statistics.model.StatisticsSelVo;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StatisticsService {
    private final  StatisticsMapper mapper;

    public StatisticsSelRes selStatistics() {
        StatisticsSelDto dto = new StatisticsSelDto();
        List<StatisticsSelVo> list = mapper.selStatistics(dto);

        return StatisticsSelRes.builder()
                .list(list)
                .build();
    }

}
