package com.green.smartGrade.admin.lectureroom.model;

import lombok.Data;

@Data
public class LectureRoomDelDto {
    private Long ilectureRoom;
    private String lectureRoomName;
    private String buildingName;
    private int delYn;
}
