package com.green.smartGrade.admin.lectureroom.model;

import lombok.Data;

@Data
public class LectureRoomDelRes {
    private Long ilectureRoom;
    private String lectureRoomName;
    private String buildingName;
    private int maxCapacity;
    private int delYn;

    public LectureRoomDelRes(LectureRoomDelDto dto) {
        this.ilectureRoom = dto.getIlectureRoom();
        this.lectureRoomName = dto.getLectureRoomName();
        this.buildingName = dto.getBuildingName();
        this.delYn = dto.getDelYn();
    }
}
