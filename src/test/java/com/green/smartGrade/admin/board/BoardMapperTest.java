//package com.green.smartGrade.admin.board;
//
//import com.green.smartGrade.admin.board.model.*;
//import org.junit.jupiter.api.Test;
//import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@MybatisTest
//@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class BoardMapperTest {
//
//    @Autowired
//    private BoardMapper MAPPER;
//
//    @Test
//    void insBoard() {
//        BoardInsDto dto = new BoardInsDto();
//        dto.setIadmin(1L);
//        dto.setTitle("제목 TEST");
//        dto.setCtnt("내용 TEST");
//        dto.setImportance(0);
//
//        int result = MAPPER.insBoard(dto);
//        assertEquals(1,result);
//
//
//        List<BoardSelVo> list = MAPPER.selBoard(0,10);
//
//        BoardSelVo vo = list.get(0);
//        assertEquals(dto.getIboard(), vo.getIboard());
//        assertEquals(dto.getIadmin(), vo.getIadmin());
//        assertEquals(dto.getTitle(), vo.getTitle());
//        assertEquals(dto.getImportance(), vo.getImportance());
//        assertEquals(0,vo.getDelYn());
//        assertEquals(0,vo.getBoardView());
//
//    }
//
//    @Test
//    void insBoardPic() {
//        List<BoardPicEntity> list = new ArrayList<>();
//        BoardPicEntity entity = new BoardPicEntity();
//        entity.setIboard(1L);
//        entity.setIpic(1L);
//        entity.setPic("TEST.png");
//
//        BoardPicEntity entity2 = new BoardPicEntity();
//        entity2.setIboard(1L);
//        entity2.setIpic(2L);
//        entity2.setPic("TEST.png");
//
//        list.add(entity);
//        list.add(entity2);
//        assertEquals(2,list.size());
//    }
//
//    @Test
//    void updBoard() {
//        BoardUpdDto dto = new BoardUpdDto();
//        dto.setTitle("제목을 바꾸자");
//        dto.setCtnt("내용을 바꾸자");
//        dto.setIboard(3L);
//        dto.setView(1);
//        dto.setImportance(1);
//        dto.setUpdatedAt(LocalDateTime.now());
//
//        int result = MAPPER.updBoard(dto);
//        assertEquals(1, result);
//
//        // 인서트 된거 리스트로 확인
//        BoardSelDetailDto detailDto = new BoardSelDetailDto();
//        detailDto.setIboard(dto.getIboard());
//        BoardSelDetailVo vo = MAPPER.selByIdBoard(detailDto);
//        assertEquals(dto.getIboard(), vo.getIboard());
//        assertEquals(dto.getTitle(), vo.getTitle());
//        assertEquals(dto.getCtnt(), vo.getCtnt());
//        assertEquals(dto.getImportance(), vo.getImportance());
//    }
//
//    @Test
//    void selBoard() {
//        List<BoardSelVo> list = MAPPER.selBoard(1,10);
//        assertEquals(10, list.size());
//
//        BoardSelVo vo = list.get(0);
//        assertEquals(24, vo.getIboard());
//        assertEquals(1, vo.getIadmin());
//        assertEquals("qwe", vo.getTitle());
//        assertEquals(0, vo.getImportance());
//        assertEquals(LocalDateTime.of(2023,8,03,15,16) , vo.getCreatedAt());
//        assertEquals(0,vo.getDelYn());
//        assertEquals(0,vo.getBoardView());
//
//
//        List<BoardSelVo> list2 = MAPPER.selBoard(11,10);
//        assertEquals(9, list2.size());
//
//        BoardSelVo vo2 = list2.get(0);
//        assertEquals(13, vo2.getIboard());
//        assertEquals(1, vo2.getIadmin());
//        assertEquals("pppp", vo2.getTitle());
//        assertEquals(0, vo2.getImportance());
//        assertEquals(LocalDateTime.of(2023,7,24,10,37,06) , vo2.getCreatedAt());
//        assertEquals(0,vo2.getDelYn());
//        assertEquals(4,vo2.getBoardView());
//
//    }
//
//    @Test
//    void selSearchBoard() {
//        // countSearchBoard() 에서 동시 테스트 진행
//    }
//
//    @Test
//    void countSearchBoard() {
//        BoardSelSearchDto dto = new BoardSelSearchDto();
//        dto.setRow(10);
//        dto.setStaIdx(0);
//        dto.setTitle("같은");
//
//        List<BoardSelVo> list = MAPPER.selSearchBoard(dto);
//        BoardSelVo vo = list.get(0);
//        assertEquals(3, list.size());
//        assertEquals(6, vo.getIboard());
//        assertEquals(1, vo.getIadmin());
//        assertEquals("저같은 놈은 맞아야해요", vo.getTitle());
//        assertEquals(LocalDateTime.of(2023,7,21,16,46,18),vo.getCreatedAt());
//        assertEquals(0,vo.getDelYn());
//        assertEquals(0,vo.getBoardView());
//
//        BoardSelVo vo2 = list.get(1);
//        assertEquals(3, list.size());
//        assertEquals(5, vo2.getIboard());
//        assertEquals(1, vo2.getIadmin());
//        assertEquals("저같은 놈은 맞아야해요", vo2.getTitle());
//        assertEquals(LocalDateTime.of(2023,7,21,16,44,48),vo2.getCreatedAt());
//        assertEquals(0,vo2.getDelYn());
//        assertEquals(0,vo2.getBoardView());
//    }
//
//    @Test
//    void selBoardImportance() {
//        List <BoardSelImportanceVo> list = MAPPER.selBoardImportance();
//        BoardSelImportanceVo vo = list.get(0);
//        assertEquals(2,list.size());
//        assertEquals(12, vo.getIboard());
//        assertEquals(1, vo.getIadmin());
//        assertEquals("bbbb",vo.getTitle());
//        assertEquals(LocalDateTime.of(2023,7,24,10,36,59),vo.getCreatedAt());
//        assertEquals(1,vo.getImportance());
//        assertEquals(2,vo.getBoardView());
//        assertEquals(0,vo.getDelYn());
//    }
//
//
//    @Test
//    void selByIdBoard() {
//        BoardSelDetailDto dto = new BoardSelDetailDto();
//        dto.setIboard(3L);
//        BoardSelDetailVo vo = MAPPER.selByIdBoard(dto);
//
//        assertEquals(3, vo.getIboard());
//        assertEquals(1, vo.getIadmin());
//        assertEquals(LocalDateTime.of(2023,07,21,16,41,19), vo.getCreatedAt());
//        assertEquals("ㅁㄴㅇ", vo.getTitle());
//        assertEquals("ㅁㄴㅇ", vo.getCtnt());
//        assertEquals(0, vo.getDelYn());
//        assertEquals(0, vo.getImportance());
//    }
//
//    @Test
//    void updDelYnBoard() {
//        BoardUpdYnDto dto = new BoardUpdYnDto();
//        dto.setIboard(3L);
//
//        int result = MAPPER.updDelYnBoard(dto);
//        assertEquals(1, result);
//
//        // 삭제 완료 확인
//        BoardSelDetailDto detailDto = new BoardSelDetailDto();
//        detailDto.setIboard(dto.getIboard());
//        BoardSelDetailVo vo = MAPPER.selByIdBoard(detailDto);
//        assertNull(vo);
//    }
//
//    @Test
//    void updViewBoard() {
//        BoardSelDetailDto dto = new BoardSelDetailDto();
//        dto.setIboard(3L);
//
//        int result = MAPPER.updViewBoard(dto);
//        assertEquals(1,result);
//    }
//}