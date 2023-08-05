package com.green.smartGrade.lecture_applly.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class LectureApllySelRes {
    private PagingUtils page;
    private List<LectureAppllySelOneRes> list;
}
