//package com.green.smartGrade.admin.board;
//
//import com.green.smartGrade.admin.board.model.*;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.FileInputStream;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//
//@ExtendWith(SpringExtension.class)
//@Import( { BoardService.class })
//@TestPropertySource(properties = {
//        "file.dir=/home/smart_grade"
//})
//class BoardServiceTest {
//
//    @MockBean
//    private BoardMapper mapper;
//
//    @Autowired
//    private BoardService service;
//
//    @Test
//    void insBoard() throws Exception{
//        String originalFileNm = "3e94edd8-cc0e-4b21-9c8b-576eeb6cbd27.jpg";
//        String contentType = "jpg";
//        String filePath = "D:/home/download/todo/12/" + originalFileNm;
//        FileInputStream fileInputStream = new FileInputStream(filePath);
//
//        BoardInsDto dto = new BoardInsDto();
//        dto.setIadmin(1L);
//        dto.setTitle("test title");
//        dto.setCtnt("test story");
//        List<MultipartFile> list = new ArrayList<>();
//        list.add(new MockMultipartFile("pics",originalFileNm, contentType, fileInputStream));
//
//        when(mapper.insBoard(any())).thenReturn(1);
//        when(mapper.insBoardPic(any())).thenReturn(1);
//
//
//        BoardInsRes res = service.insBoard(dto, list);
//
//        assertEquals(dto.getTitle(), res.getTitle());
//        assertEquals(dto.getCtnt(), res.getCtnt());
//        assertEquals(dto.getImportance(), res.getImportance());
//        assertEquals(dto.getIadmin(), res.getIadmin());
//        assertEquals(list.get(0).getSize(), list.get(0).getSize());
//
//
//        verify(mapper).insBoard(any());
//    }
//
//    @Test
//    void updBoard() {
//        BoardUpdDto dto = new BoardUpdDto();
//        dto.setIboard(1L);
//        dto.setImportance(1);
//        dto.setTitle("changTitle");
//        dto.setCtnt("changStory");
//
//        when(mapper.updBoard(any())).thenReturn(1);
//
//        BoardUpdRes res = service.updBoard(dto);
//        assertEquals(dto.getTitle(), res.getTitle());
//        assertEquals(dto.getCtnt(), res.getCtnt());
//    }
//
//    @Test
//    void selBoard() {
//        // Given
//        int page = 1;
//        List<BoardSelVo> list = new ArrayList<>();
//        BoardSelVo vo = new BoardSelVo(1L, 1L, "title",1, LocalDateTime.now(),0,1);
//        list.add(vo);
//
//        BoardSelSearchDto dto = new BoardSelSearchDto();
//        dto.setTitle("같은");
//        when(mapper.selSearchBoard(dto)).thenReturn(list);
//        BoardRes res = service.selBoard(page, dto);
//
//        // Then
//        assertEquals(1, res.getPage().getPage());
//    }
//
//    @Test
//    void selBoardImportance() {
//        BoardSelImportanceVo vo = new BoardSelImportanceVo(1L, 1L, "title",1, LocalDateTime.now(),0,1);
//        BoardSelImportanceVo vo2 = new BoardSelImportanceVo(1L, 1L, "title",1, LocalDateTime.now(),0,1);
//        List <BoardSelImportanceVo> list = new ArrayList<>();
//        list.add(vo);
//        list.add(vo2);
//
//        when(mapper.selBoardImportance()).thenReturn(list);
//
//        List <BoardSelImportanceVo> voList = service.selBoardImportance();
//        assertEquals(list.size(), voList.size());
//        assertEquals(list.get(0).getTitle(), voList.get(0).getTitle());
//        assertEquals(list.get(0).getIboard(), voList.get(0).getIboard());
//        assertEquals(list.get(0).getImportance(), voList.get(0).getImportance());
//        assertEquals(list.get(0).getBoardView(), voList.get(0).getBoardView());
//        assertEquals(list.get(0).getDelYn(), voList.get(0).getDelYn());
//
//    }
//
//    @Test
//    void selBoardDetail() {
//        BoardSelDetailVo vo = new BoardSelDetailVo(1L, 1L, "title","ctnt", 0, LocalDateTime.now(),0);
//        BoardSelDetailDto dto = new BoardSelDetailDto();
//        dto.setIboard(1L);
//
//        when(mapper.selByIdBoard(any())).thenReturn(vo);
//
//        BoardSelDetailVo vo1 = service.selBoardDetail(dto);
//        assertEquals(vo.getIadmin(), vo1.getIadmin());
//        assertEquals(vo.getDelYn(), vo1.getDelYn());
//        assertEquals(vo.getCtnt(), vo1.getCtnt());
//    }
//
//    @Test
//    void updDelYnBoard() {
//        BoardUpdYnDto dto = new BoardUpdYnDto();
//        dto.setIboard(1L);
//
//        when(mapper.updDelYnBoard(any())).thenReturn(1);
//
//        int result = service.updDelYnBoard(dto);
//
//        assertEquals(1,result);
//
//    }
//}