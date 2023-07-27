package com.green.smart_grade.professor.professorgradeMngmn;

import com.green.smart_grade.professor.professorgradeMngmn.model.professorGradeMngmnUpParam;
import com.green.smart_grade.professor.professorgradeMngmn.model.professorGradeMngmnUpRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professorstudent")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "학생 성적관리")
public class professorGradeMngmnContoller {
    private  final professorGradeMngmnService service;

    @PutMapping("/{iprofessor}")
    @Operation(summary = "성적 입력")
    public professorGradeMngmnUpRes putProfessorGradeMngnm(@PathVariable Long iprofessor, @RequestParam Long ilectureStudent, @RequestBody professorGradeMngmnUpParam param) {



        return service.upMngnm(param,iprofessor,ilectureStudent);
    }


}
