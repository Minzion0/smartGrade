package com.green.smart_grade.admin.board;

import com.green.smart_grade.admin.board.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "게시판 컨트롤러")
public class BoardController {
    private final BoardService SERVICE;

    @PostMapping
    @Operation(summary = "게시판 등록")
    public BoardInsRes insBoard (@RequestBody BoardInsParam param) {
        return SERVICE.insBoard(param);
    }

    @PutMapping
    @Operation(summary = "게시판 수정")
    public BoardUpdRes UpdBoard(@RequestBody BoardUpdParam param) {
        return SERVICE.updBoard(param);
    }
}
