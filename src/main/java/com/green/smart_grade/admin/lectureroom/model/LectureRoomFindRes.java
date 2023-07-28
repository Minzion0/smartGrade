package com.green.smart_grade.admin.lectureroom.model;

import com.green.smart_grade.utils.PagingUtils;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LectureRoomFindRes {
    private PagingUtils page;
    private List<LectureRoomVo> lectureRoom;
}
