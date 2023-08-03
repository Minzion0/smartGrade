package com.green.smartGrade.student;

import com.green.smartGrade.student.model.*;
import com.green.smartGrade.utils.GradeUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/student")
@Tag(name = "학생")
public class StudentController {
    private final StudentService service;


    @PostMapping
    @Operation(summary = "학생 수강 신청")
    public StudentInsRes postStudent(@RequestBody StudentParam param) {
        return service.inslecture(param);
    }

    @GetMapping
    @Operation(summary = "학생 강의별 성적 조회")
    public StudentSelRes getStudentGrade(@RequestParam(defaultValue = "1") int page,@RequestParam Long studentnum) {
        StudentSelDto dto = new StudentSelDto();
        dto.setStudentNum(studentnum);


        return service.selAllSdy(dto, page);
    }

    @GetMapping("{studentNum}")
    @Operation(summary = "학생 프로필 조회")
    public StudentSelProfileRes getStudentProfile(@RequestParam(defaultValue = "1") int page,@PathVariable Long studentNum ) {
        StudentSelProfileDto dto = new StudentSelProfileDto();
        dto.setStudentNum(studentNum);
        return service.selStudentProfile(dto, page);
    }

    @GetMapping("/studentpoint")
    @Operation(summary = "학점 조회")
    public StudentSelPointRes getStudentPoint(@RequestParam(defaultValue = "1") int page, @RequestParam Long studentNum) {
        StudentSelPointDto dto = new StudentSelPointDto();
        dto.setStudentNum(studentNum);
        return service.selStudentRemainingPoint(dto, page);
    }
}
