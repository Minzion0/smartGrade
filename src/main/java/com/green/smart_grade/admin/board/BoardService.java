package com.green.smart_grade.admin.board;

import com.green.smart_grade.admin.board.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper MAPPER;

    public BoardInsRes insBoard(BoardInsParam param) {
        BoardInsDto dto = new BoardInsDto();
        dto.setImportance(param.getImportance());
        dto.setCtnt(param.getCtnt());
        dto.setIadmin(param.getIadmin());
        dto.setTitle(param.getTitle());
        int result = MAPPER.insBoard(dto);
        if (result == 1) {
           return new BoardInsRes(dto);
        }
        return null;
    }

    public BoardUpdRes updBoard (BoardUpdParam param) {
        BoardUpdDto dto = new BoardUpdDto();
        dto.setCtnt(param.getCtnt());
        dto.setTitle(param.getTitle());
        dto.setImportance(param.getImportance());
        dto.setIboard(param.getIboard());
        int result = MAPPER.updBoard(dto);
        if (result == 1) {
            return new BoardUpdRes(dto);
        }
        return null;
    }
}
