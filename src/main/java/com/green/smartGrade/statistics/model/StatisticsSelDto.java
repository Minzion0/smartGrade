package com.green.smartGrade.statistics.model;

import lombok.Data;

@Data
public class StatisticsSelDto {
    private Long ilecture;
    private int startIdx;
    private int page;
    private int row;
}
