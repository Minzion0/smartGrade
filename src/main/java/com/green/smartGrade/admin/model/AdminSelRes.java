package com.green.smartGrade.admin.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Getter
@Builder
public class AdminSelRes {
    private PagingUtils page;
    private List<AdminSelLectureRes> lectures;
}
