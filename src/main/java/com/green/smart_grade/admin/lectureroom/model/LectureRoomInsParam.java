package com.green.smart_grade.admin.lectureroom.model;

import lombok.Data;

@Data
public class LectureRoomInsParam {
    private String lectureRoomName;
    private String buildingName;
    private int maxCapacity;
}