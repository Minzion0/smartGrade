package com.green.smartGrade.admin.lectureroom.model;

import lombok.Data;

@Data
public class LectureRoomDetailDto {
    private Long ilectureRoom;
    private String buildingName;
    private String lectureRoomName;
    private int page;
    private int staIdx;

}
