package com.green.smartGrade.admin.major.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Data;

@Data
public class MajorSelDto {
    private String majorName;
    private int page;
    private int staIdx;
}
