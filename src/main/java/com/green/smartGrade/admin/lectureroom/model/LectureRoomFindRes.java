package com.green.smartGrade.admin.lectureroom.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LectureRoomFindRes {
    private PagingUtils page;
    private List<LectureRoomListVo> lectureRoomList;
    private List<LectureRoomVo> lectureRoom;
}
