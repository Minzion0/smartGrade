package com.green.smart_grade.admin.board;

import com.green.smart_grade.admin.board.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "게시판 컨트롤러")
public class BoardController {
    private final BoardService SERVICE;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(summary = "게시판 등록")
    public BoardInsRes insBoard (@RequestPart BoardInsParam param,
                                 @RequestPart(required = false) List<MultipartFile> pics) {
        return SERVICE.insBoard(param,pics);
    }

    @PutMapping
    @Operation(summary = "게시판 수정")
    public BoardUpdRes UpdBoard(@RequestBody BoardUpdParam param) {
        return SERVICE.updBoard(param);
    }

    @GetMapping
    @Operation(summary = "게시판 목록")
    public BoardRes selBoard (@RequestParam (defaultValue = "1") int page) {
        return SERVICE.selBoard(page);
    }

    @GetMapping("/importanceList")
    @Operation(summary = "주요 공지사항")
    public List<BoardSelImportanceVo> selImportanceList () {
        return SERVICE.selBoardImportance();
    }

    @GetMapping("{iboard}")
    @Operation(summary = "게시판 디테일 및 조회수 증가")
    public BoardSelDetailVo selByIdBoard(@PathVariable Long iboard) {
        BoardSelDetailDto dto = new BoardSelDetailDto();
        dto.setIboard(iboard);
        return SERVICE.selBoardDetail(dto);
    }

    @DeleteMapping ("/{iboard}")
    @Operation(summary = "게시판 삭제")
    public int updDelYnBoard (@PathVariable Long iboard) {
        BoardUpdYnDto dto = new BoardUpdYnDto();
        dto.setIboard(iboard);
        return SERVICE.updDelYnBoard(dto);
    }
}
