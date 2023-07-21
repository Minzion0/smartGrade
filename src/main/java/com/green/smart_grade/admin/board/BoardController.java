package com.green.smart_grade.admin.board;

import com.green.smart_grade.admin.board.model.BoardInsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "게시판 컨트롤러")
public class BoardController {
    private final BoardService SERVICE;

    @PostMapping
    @Operation(summary = "게시판 등록")
    public int insBoard (@RequestBody BoardInsDto dto) {
        log.info("등록이 완료되었습니다.");
        return SERVICE.insBoard(dto);
    }
}
