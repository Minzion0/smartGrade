package com.green.smartGrade.admin.board.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BoardRes {
    private PagingUtils page;
    private List<BoardSelVo> list;
}
