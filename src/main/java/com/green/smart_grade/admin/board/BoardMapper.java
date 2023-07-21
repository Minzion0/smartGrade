package com.green.smart_grade.admin.board;

import com.green.smart_grade.admin.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard (BoardInsDto dto);
    int updBoard (BoardUpdDto dto);

    List<BoardSelVo> selBoard ();
    List<BoardSelImportanceVo> selBoardImportance ();
}
