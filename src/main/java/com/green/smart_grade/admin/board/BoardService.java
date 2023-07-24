package com.green.smart_grade.admin.board;

import com.green.smart_grade.admin.board.model.*;
import com.green.smart_grade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public BoardRes selBoard (int page) {
            int maxPage = MAPPER.countBoard();
            PagingUtils utils = new PagingUtils(page, maxPage);

            List<BoardSelVo> list = MAPPER.selBoard(utils.getStaIdx(), utils.getROW() - 3);
            return BoardRes.builder()
                    .page(utils)
                    .list(list)
                    .build();
    }
    public List<BoardSelImportanceVo>  selBoardImportance () {
        return MAPPER.selBoardImportance();
    }
    public BoardSelDetailVo selBoardDetail (BoardSelDetailDto dto) {
        return MAPPER.selByIdBoard(dto);
    }

    public int updDelYnBoard (BoardUpdYnDto dto) {
        return MAPPER.updDelYnBoard(dto);
    }
}
