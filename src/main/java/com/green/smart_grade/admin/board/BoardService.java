package com.green.smart_grade.admin.board;

import com.green.smart_grade.admin.board.model.*;
import com.green.smart_grade.utils.FileUtils;
import com.green.smart_grade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper MAPPER;

    @Value("${file.dir}")
    private String fileDir;

    public BoardInsRes insBoard(BoardInsParam param, List<MultipartFile> pics) {
        int result = 0;

        BoardInsDto dto = new BoardInsDto();
        dto.setImportance(param.getImportance());
        dto.setCtnt(param.getCtnt());
        dto.setIadmin(param.getIadmin());
        dto.setTitle(param.getTitle());

        result = MAPPER.insBoard(dto);

        if (result == 1) {
           return new BoardInsRes(dto);
        }
        if (param.getPics() != null) {

        } return null;
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

    public BoardRes selBoard (int page) {
        int maxPage = MAPPER.countBoard();
        final int MAX_ROW = 3;
        int row = 10;

        List<BoardSelVo> list = new ArrayList<>();
        PagingUtils utils = new PagingUtils();

        if (selBoardImportance().size() < MAX_ROW ) {
            list = MAPPER.selBoard(utils.getStaIdx(), row - selBoardImportance().size());
            utils = new PagingUtils(page, maxPage, row);
        } else {
            list = MAPPER.selBoard(utils.getStaIdx(), utils.getROW() - MAX_ROW);
            utils = new PagingUtils(page, maxPage, row);
        }
        return BoardRes.builder()
                .page(utils)
                .list(list)
                .build();

    }
    public List <BoardSelImportanceVo> selBoardImportance () {
       return MAPPER.selBoardImportance();
    }

    public BoardSelDetailVo selBoardDetail (BoardSelDetailDto dto) {
        MAPPER.updViewBoard(dto);
        return MAPPER.selByIdBoard(dto);
    }

    public int updDelYnBoard (BoardUpdYnDto dto) {
        return MAPPER.updDelYnBoard(dto);
    }
}
