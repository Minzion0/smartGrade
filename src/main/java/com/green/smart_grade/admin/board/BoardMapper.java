package com.green.smart_grade.admin.board;

import com.green.smart_grade.admin.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시판 등록 및 수정
    int insBoard (BoardInsDto dto);
    int insBoardPic (List<BoardPicEntity> entity);
    int updBoard (BoardUpdDto dto);

    // 게시판 리스트 뽑기
    List<BoardSelVo> selBoard (int staIdx, int row);
    List <BoardSelImportanceVo> selBoardImportance ();
    int countBoard();
    BoardSelDetailVo selByIdBoard(BoardSelDetailDto dto);

    // 게시판 삭제
    int updDelYnBoard (BoardUpdYnDto dto);

    // 조회수 증가
    int updViewBoard (BoardSelDetailDto dto);

}
