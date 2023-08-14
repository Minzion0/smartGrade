package com.green.smartGrade.admin.board;

import com.green.smartGrade.admin.board.model.*;
import com.green.smartGrade.utils.FileUtils;
import com.green.smartGrade.utils.PagingUtils;
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

    public BoardInsRes insBoard(BoardInsDto dto, List<MultipartFile> pics) {
        int result = 0;

        result = MAPPER.insBoard(dto);

        if (result == 1) {
            if (pics != null) {

                String centerPath = String.format("boardPic/%d", dto.getIboard());
                String targetPath = String.format("%s/%s", FileUtils.getAbsoluteDownloadPath(fileDir), centerPath);

                File file = new File(targetPath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                List<BoardPicEntity> list = new ArrayList<>();

                for (int i = 0; i < pics.size(); i++) {
                    String originFile = pics.get(i).getOriginalFilename();
                    String saveName = FileUtils.makeRandomFileNm(originFile);

                    File fileTarget = new File(targetPath + "/" + saveName);

                    try {
                        pics.get(i).transferTo(fileTarget);
                    } catch (IOException e) {
                        throw new RuntimeException("파일저장을 실패했습니다.");
                    }
                    BoardPicEntity picEntity = new BoardPicEntity();
                    picEntity.setIboard(dto.getIboard());
                    picEntity.setPic(saveName);
                    list.add(picEntity);
                }
                MAPPER.insBoardPic(list);
            }
            return  new BoardInsRes(dto);
        }
        return null;
    }

    public BoardUpdRes updBoard (BoardUpdDto dto) {

        int result = MAPPER.updBoard(dto);
        if (result == 1) {
            return new BoardUpdRes(dto);
        }
        return null;
    }

    public BoardRes selBoard (int page, BoardSelSearchDto dto) {
//        int maxPage = MAPPER.countBoard();
        int searchCount = MAPPER.countSearchBoard(dto);
        int row = 10;
        final int MAX_ROW = 3;

        List<BoardSelVo> list = new ArrayList<>();
        PagingUtils utils = new PagingUtils();

        if (dto.getTitle() == null) {
            if (selBoardImportance().size() < MAX_ROW ) {
                utils = new PagingUtils(page, searchCount, row);
                list = MAPPER.selBoard(utils.getStaIdx(), row - selBoardImportance().size());
            } else {
                utils = new PagingUtils(page, searchCount, row);
                list = MAPPER.selBoard(utils.getStaIdx(), utils.getROW() - MAX_ROW);
            }
        } else {
            utils = new PagingUtils(page,searchCount);
            dto.setStaIdx(utils.getStaIdx());
            dto.setRow(row);
            list = MAPPER.selSearchBoard(dto);
        }
        return BoardRes.builder()
                .page(utils)
                .list(list)
                .build();
    }
    public BoardSelDetailVo selBoardDetail (BoardSelDetailDto dto) {
        MAPPER.updViewBoard(dto);
        return MAPPER.selByIdBoard(dto);
    }

    public int updDelYnBoard (BoardUpdYnDto dto) {
        return MAPPER.updDelYnBoard(dto);
    }

    public List <BoardSelImportanceVo> selBoardImportance () {
        return MAPPER.selBoardImportance();
    }

    //    public BoardRes selSearchBoard (BoardSelSearchDto dto) {
//
//        int maxPage = MAPPER.countSearchBoard(dto);
//
//        PagingUtils utils = new PagingUtils(dto.getPage(), maxPage);
//        dto.setRow(utils.getROW());
//        List<BoardSelVo> list = MAPPER.selSearchBoard(dto);
//        log.info("list : {}", list);
//        return BoardRes.builder()
//                .list(list)
//                .page(utils)
//                .build();
//
//    }
}
