//package com.green.smartGrade.admin.board;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.green.smartGrade.admin.board.model.BoardInsDto;
//import com.green.smartGrade.admin.board.model.BoardInsParam;
//import com.green.smartGrade.admin.board.model.BoardInsRes;
//import com.green.smartGrade.security.config.security.JwtTokenProvider;
//import com.green.smartGrade.security.config.security.SecurityConfiguration;
//import com.green.smartGrade.security.config.security.model.MyUserDetails;
//import org.checkerframework.checker.units.qual.A;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.web.multipart.MultipartFile;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@WebMvcTest(BoardController.class)
//@Import({SecurityConfiguration.class, JwtTokenProvider.class})
//class BoardControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private BoardService service;
//
//    private String path = "/api/board";
//
//    @BeforeEach
//    void beforeEach() {
//        UserDetails user = createUserDetails();
//
//        SecurityContext context = SecurityContextHolder.getContext();
//        context.setAuthentication(new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities()));
//
//    }
//    private UserDetails createUserDetails() {
//        List<String> roles = new ArrayList<>();
//        roles.add("ROLE_ADMIN");
//
//        UserDetails userDetails = MyUserDetails.builder()
//                .iuser(1L)
//                .roles(roles)
//                .build();
//        return userDetails;
//    }
//
//    @Test
//    void insBoard() throws Exception{
//
//        BoardInsParam param = new BoardInsParam();
//        param.setTitle("New Board Title");
//        param.setCtnt("This is a new board content.");
//        param.setImportance(1);
//
//        BoardInsDto dto = new BoardInsDto();
//        dto.setTitle(param.getTitle());
//        dto.setImportance(param.getImportance());
//        dto.setCtnt(param.getCtnt());
//
//        List<MultipartFile> pics = new ArrayList<>();
//        pics.add(new MockMultipartFile("test.jpg", "test.jpg", "image/jpeg", new byte[]{}));
//        pics.add(new MockMultipartFile("test2.png", "test2.png", "image/png", new byte[]{}));
//
//        BoardInsRes res = service.insBoard(dto, pics);
//        String requestBody = objectMapper.writeValueAsString(dto);
//
//        when(service.insBoard(dto, pics)).thenReturn(res);
//
//        mvc.perform(MockMvcRequestBuilders.post(path)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(requestBody))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(jsonPath("$.title").value(dto.getTitle()))
//                .andExpect(jsonPath("$.ctnt").value(dto.getCtnt()))
//                .andExpect(jsonPath("$.importance").value(dto.getImportance()))
//                .andDo(print());
//
//        verify(service).insBoard(dto, pics);
//
//    }
//
//    @Test
//    void updBoard() {
//    }
//
//    @Test
//    void selBoard() {
//    }
//
//    @Test
//    void selImportanceList() {
//    }
//
//    @Test
//    void selByIdBoard() {
//    }
//
//    @Test
//    void updDelYnBoard() {
//    }
//}