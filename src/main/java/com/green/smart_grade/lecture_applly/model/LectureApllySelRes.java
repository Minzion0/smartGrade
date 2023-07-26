package com.green.smart_grade.lecture_applly.model;

import com.green.smart_grade.utils.PagingUtils;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class LectureApllySelRes {
    private PagingUtils page;
    private List<LectureAppllySelOneRes> list;
}
