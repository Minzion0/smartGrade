package com.green.smart_grade.lectureroom.model;

import lombok.Data;

@Data
public class LectureRoomInsDto {
    private Long ilectureRoom;
    private String lectureRoomName;
    private String buildingName;
    private int maxCapacity;
}
