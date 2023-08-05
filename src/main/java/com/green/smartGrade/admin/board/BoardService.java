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

    public BoardInsRes insBoard(BoardInsParam param, List<MultipartFile> pics) {
        int result = 0;

        BoardInsDto dto = new BoardInsDto();
        dto.setImportance(param.getImportance());
        dto.setCtnt(param.getCtnt());
        dto.setIadmin(param.getIadmin());
        dto.setTitle(param.getTitle());

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
        int row = 10;
        final int MAX_ROW = 3;

        List<BoardSelVo> list = new ArrayList<>();
        PagingUtils utils = new PagingUtils();

        if (selBoardImportance().size() < MAX_ROW ) {
            utils = new PagingUtils(page, maxPage, row);
            list = MAPPER.selBoard(utils.getStaIdx(), row - selBoardImportance().size());
        } else {
            utils = new PagingUtils(page, maxPage, row);
            list = MAPPER.selBoard(utils.getStaIdx(), utils.getROW() - MAX_ROW);
        }
        return BoardRes.builder()
                .page(utils)
                .list(list)
                .build();
    }
    public List<BoardSelVo> selSearchBoard (BoardSelSearchDto dto) {
        return  null;
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
