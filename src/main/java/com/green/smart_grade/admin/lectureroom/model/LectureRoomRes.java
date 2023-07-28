package com.green.smart_grade.admin.lectureroom.model;

import lombok.Data;

@Data
public class LectureRoomRes {
    private Long ilectureRoom;
    private String lectureRoomName;
    private String buildingName;
    private int maxCapacity;

    public LectureRoomRes(LectureRoomInsDto dto) {
        this.ilectureRoom = dto.getIlectureRoom();
        this.lectureRoomName = dto.getLectureRoomName();
        this.buildingName = dto.getBuildingName();
        this.maxCapacity = dto.getMaxCapacity();
    }

    public LectureRoomRes(LectureRoomDelDto dto) {
        this.ilectureRoom = dto.getIlectureRoom();
        this.lectureRoomName = dto.getLectureRoomName();
        this.buildingName = dto.getBuildingName();
    }
}
