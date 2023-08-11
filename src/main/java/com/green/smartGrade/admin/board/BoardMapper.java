package com.green.smartGrade.admin.board;

import com.green.smartGrade.admin.board.model.*;
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
    // 검색기능
    List<BoardSelVo> selSearchBoard (BoardSelSearchDto dto);
    int countSearchBoard(BoardSelSearchDto dto);
    List <BoardSelImportanceVo> selBoardImportance ();
    BoardSelDetailVo selByIdBoard(BoardSelDetailDto dto);

    // 게시판 삭제
    int updDelYnBoard (BoardUpdYnDto dto);

    // 조회수 증가
    int updViewBoard (BoardSelDetailDto dto);

}
