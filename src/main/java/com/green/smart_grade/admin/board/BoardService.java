package com.green.smart_grade.admin.board;

import com.green.smart_grade.admin.board.model.BoardInsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper MAPPER;

    public int insBoard(BoardInsDto dto) {
        return MAPPER.insBoard(dto);
    }
}
