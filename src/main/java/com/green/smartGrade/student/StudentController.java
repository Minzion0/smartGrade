package com.green.smartGrade.student;

import com.green.smartGrade.student.model.StudentInsRes;
import com.green.smartGrade.student.model.StudentParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
