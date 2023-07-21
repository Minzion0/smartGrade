package com.green.smart_grade.admin.board;

import com.green.smart_grade.admin.board.model.BoardInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    int insBoard (BoardInsDto dto);
}
