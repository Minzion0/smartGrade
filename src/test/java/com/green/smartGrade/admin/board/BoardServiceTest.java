package com.green.smartGrade.admin.board;

import com.green.smartGrade.admin.board.model.BoardInsDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static reactor.core.publisher.Mono.when;

@ExtendWith(SpringExtension.class)
@Import( { BoardService.class })
@TestPropertySource(properties = {
        "file.dir=/home/smart_grade"
})
class BoardServiceTest {

    @MockBean
    private BoardMapper mapper;

    @Autowired
    private BoardService service;

    @Test
    void insBoard() throws Exception{
        String originalFileNm = "3e94edd8-cc0e-4b21-9c8b-576eeb6cbd27.jpg";
        String contentType = "jpg";
        String filePath = "D:/home/download/todo/12/" + originalFileNm;
        FileInputStream fileInputStream = new FileInputStream(filePath);
        MultipartFile pic = new MockMultipartFile("pic", originalFileNm, contentType, fileInputStream);

        BoardInsDto dto = new BoardInsDto();
        dto.setIadmin(1L);
        dto.setTitle("test title");
        dto.setCtnt("test story");

//        when(mapper.insBoard(any())).thenReturn(1);

    }

    @Test
    void updBoard() {
    }

    @Test
    void selBoard() {
    }

    @Test
    void selSearchBoard() {
    }

    @Test
    void selBoardImportance() {
    }

    @Test
    void selBoardDetail() {
    }

    @Test
    void updDelYnBoard() {
    }
}