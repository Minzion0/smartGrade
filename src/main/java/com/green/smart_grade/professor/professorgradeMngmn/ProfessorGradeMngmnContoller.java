package com.green.smart_grade.professor.professorgradeMngmn;

import com.green.smart_grade.professor.professorgradeMngmn.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor/grade")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "교수 학생 성적관리")
public class ProfessorGradeMngmnContoller {
    private final ProfessorGradeMngmnService service;

    @PutMapping("/{iprofessor}")
    @Operation(summary = "성적 입력")
    public ProfessorGradeMngmnUpRes putProfessorGradeMngnm(@PathVariable Long iprofessor
                                                         , @RequestParam Long ilecture
                                                         , @RequestParam Long ilectureStudent
                                                         , @RequestBody ProfessorGradeMngmnUpParam param) {


        return service.upMngnm(param, iprofessor, ilecture,ilectureStudent);
    }

    @GetMapping("/{iprofessor}")
    @Operation(summary = "내 강의를 듣고 있는 학생 목록")
    public ProfessorGradeMngmnSelRES selStudentScore(@PathVariable int iprofessor,
                                                     @RequestParam(defaultValue = "1") int page,
                                                     @RequestParam(defaultValue = "0") int ilecture,
                                                     @RequestParam(defaultValue = "0") int studentNum) {
        ProfessorGradeMngmnSelDto dto = new ProfessorGradeMngmnSelDto();
        dto.setIprofessor(iprofessor);
        dto.setPage(page);
        dto.setIlecture(ilecture);
        dto.setStudentNum(studentNum);
        return service.selStudentScore(dto);
    }


}
