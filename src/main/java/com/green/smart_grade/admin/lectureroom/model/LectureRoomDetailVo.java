package com.green.smart_grade.admin.lectureroom.model;

import lombok.Data;

@Data
public class LectureRoomDetailVo {
    private Long ilectureRoom;
    private String lectureRoomName;
    private String buildingName;
    private int maxCapacity;
    private int delYn;

}
