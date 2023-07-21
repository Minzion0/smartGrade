package com.green.smart_grade.professor;

import com.green.smart_grade.professor.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "교수 프로필")
public class ProfessorController {
    private final ProfessorService service;


    @GetMapping
    @Operation(summary = "교수 리스트 보기",description = "Page : 페이지,기본적으로 1부터 시작"+"row : 리스트갯수 : 기본 10개 시작")
    public List<ProfessorVo> getProfessor(@RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "10") int row) {
            ProfessorSelDto dto = new ProfessorSelDto();
            dto.setPage(page);
            dto.setRow(row);
        return service.selProfessor(dto);
    }


    @PatchMapping
    @Operation(summary = "교수 비밀번호 번경")
    public int patchProfessor(@RequestBody ProfessorUpPW dto) {
        return service.upProfessorPw(dto);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "" +
            "리턴값 : " + "(1)로그인 성공" + "(2)아이디 없음" + "(3)비밀번호 다름")
    public int posLoginProfessor(@RequestBody ProfessorLoginDto dto) {
        return service.selProfessorById(dto);
    }


    @PutMapping("/{iprofessor}")
    @Operation(summary = "교수 프로필 수정")
    public ProfessorInsRes putProfessor(@PathVariable Long iprofessor,@RequestBody ProfessorParam param) {
        ProfessorEntity entity = new ProfessorEntity();
        entity.setIprofessor(iprofessor);
        return service.upProfessor(param);
    }



}
