package com.green.smart_grade.admin.student;

import com.green.smart_grade.admin.student.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "관리자 학생 관리")
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminStudentController {

    private final AdminStudentService SERVICE;

    @PostMapping("/student")
    @Operation(summary = "학생등록")
    public AdminIInsStudentRes studentEnrollment(@RequestBody AdminInsStudentParam param){
        return SERVICE.insStudent(param);
    }

    @GetMapping("/student")
    @Operation(summary = "학생 검색", description = "학번이나 이름 둘중 하나로 찾기가능")
    public AdminStudentRes searchStudent(@RequestParam(required = false) String studentNum, @RequestParam(required = false)String nm, @RequestParam (defaultValue = "1") int page){
        AdminFindStudentDto dto = new AdminFindStudentDto();
        dto.setNm(nm);
        dto.setStudentNum(studentNum);
        return SERVICE.findStudents(dto,page);
    }
}
