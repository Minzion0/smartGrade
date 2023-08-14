package com.green.smartGrade.admin.board;

import com.green.smartGrade.admin.board.model.*;
import com.green.smartGrade.security.config.security.model.MyUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "게시판 컨트롤러")
public class BoardController {
    private final BoardService SERVICE;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(summary = "게시판 등록",
            description =
                    "      \"iadmin\": \"작성자 pk<br>\",\n" +
                            "      \"title\": 제목,<br>\n" +
                            "      \"ctnt\": 내용,<br>\n" +
                            "      \"importance\": 중요도<br>")
    public BoardInsRes insBoard (@RequestPart BoardInsParam param, @AuthenticationPrincipal MyUserDetails details,
                                 @RequestPart(required = false) List<MultipartFile> pics) {
        BoardInsDto dto = new BoardInsDto();
        dto.setIadmin(details.getIuser());
        dto.setTitle(param.getTitle());
        dto.setCtnt(param.getCtnt());
        dto.setImportance(param.getImportance());
        return SERVICE.insBoard(dto,pics);
    }

    @PutMapping
    @Operation(summary = "게시판 수정",
            description =
                    "      \"iadmin\": \"작성자 pk<br>\",\n" +
                    "      \"title\": 제목,<br>\n" +
                    "      \"ctnt\": 내용,<br>\n" +
                    "      \"importance\": 중요도<br>")
    public BoardUpdRes UpdBoard(@AuthenticationPrincipal MyUserDetails details,@RequestBody BoardUpdParam param) {
        BoardUpdDto dto = new BoardUpdDto();
        dto.setTitle(param.getTitle());
        dto.setIadmin(details.getIuser());
        dto.setImportance(param.getImportance());
        dto.setCtnt(param.getCtnt());
        dto.setIboard(param.getIboard());
        return SERVICE.updBoard(dto);
    }

    @GetMapping
    @Operation(summary = "게시판 목록",
            description =
            "      \"iboard\": \"board pk<br>\",\n" +
            "      \"iadmin\": \"작성자 pk<br>\",\n" +
            "      \"title\": 제목,<br>\n" +
            "      \"ctnt\": 내용,<br>\n" +
            "      \"importance\": 중요도<br>\n" +
            "      \"createdAt\": 작성날짜<br>\n" +
            "      \"delYn\": 삭제여부<br>\n" +
            "      \"boardView\": 조회수<br>")
    public BoardRes selBoard (@RequestParam (defaultValue = "1") int page, @RequestParam(required = false)String keyword) {
        BoardSelSearchDto dto = new BoardSelSearchDto();
        dto.setTitle(keyword);
        return SERVICE.selBoard(page, dto);
    }

    @GetMapping("/importanceList")
    @Operation(summary = "주요 공지사항",
            description =
            "      \"iboard\": \"board pk<br>\",\n" +
            "      \"iadmin\": \"작성자 pk<br>\",\n" +
            "      \"title\": 제목,<br>\n" +
            "      \"ctnt\": 내용,<br>\n" +
            "      \"importance\": 중요도<br>\n" +
            "      \"createdAt\": 작성날짜<br>\n" +
            "      \"delYn\": 삭제여부<br>\n" +
            "      \"boardView\": 조회수<br>")
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

//    @GetMapping("/search")
//    @Operation(summary = "게시글 검색",
//            description =
//            "      \"iboard\": \"board pk<br>\",\n" +
//            "      \"iadmin\": \"작성자 pk<br>\",\n" +
//            "      \"title\": 제목,<br>\n" +
//            "      \"ctnt\": 내용,<br>\n" +
//            "      \"importance\": 중요도<br>\n" +
//            "      \"createdAt\": 작성날짜<br>\n" +
//            "      \"delYn\": 삭제여부<br>\n" +
//            "      \"boardView\": 조회수<br>")
//
//    public  BoardRes getSearchBoard (@RequestParam (defaultValue = "1") int page,
//                                             String keyword) {
//        BoardSelSearchDto dto = new BoardSelSearchDto();
//        dto.setTitle(keyword);
//        dto.setPage(page);
//        return SERVICE.selSearchBoard(dto);
//    }
}
