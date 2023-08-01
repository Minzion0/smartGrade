package com.green.smartGrade.admin.lectureroom.model;

import lombok.Data;

@Data
public class LectureRoomInsDto {
    private Long ilectureRoom;
    private String lectureRoomName;
    private String buildingName;
    private int maxCapacity;
}
