package com.green.smartGrade.admin.board;

import com.green.smartGrade.admin.board.model.BoardInsDto;
import com.green.smartGrade.admin.board.model.BoardInsParam;
import com.green.smartGrade.admin.board.model.BoardInsRes;
import com.green.smartGrade.security.config.security.model.MyUserDetails;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(BoardController.class)
class BoardControllerTest {
    @Autowired
    private MockMvc mvc;

    private MyUserDetails details;

    @MockBean
    private BoardService service;

    @Test
    void insBoard() throws Exception{

        BoardInsParam param = new BoardInsParam();
        param.setTitle("New Board Title");
        param.setCtnt("This is a new board content.");
        param.setImportance(1);
        details.setIuser(1L);

        BoardInsDto dto = new BoardInsDto();
        dto.setTitle(param.getTitle());
        dto.setIadmin(details.getIuser());
        dto.setImportance(param.getImportance());
        dto.setCtnt(param.getCtnt());

        List<MultipartFile> pics = new ArrayList<>();
        pics.add(new MockMultipartFile("test.jpg", "test.jpg", "image/jpeg", new byte[]{}));
        pics.add(new MockMultipartFile("test2.png", "test2.png", "image/png", new byte[]{}));

        BoardInsRes res = service.insBoard(dto, pics);

        given(service.insBoard(dto, pics)).willReturn(res);

        

    }

    @Test
    void updBoard() {
    }

    @Test
    void selBoard() {
    }

    @Test
    void selImportanceList() {
    }

    @Test
    void selByIdBoard() {
    }

    @Test
    void updDelYnBoard() {
    }
}