package com.green.smartGrade.statistics.model;

import lombok.Data;

@Data
public class StatisticsSelVo {
    private Long imajor;
    private Long ilecture;
    private int lectureCount;
    private double percentage;
}
