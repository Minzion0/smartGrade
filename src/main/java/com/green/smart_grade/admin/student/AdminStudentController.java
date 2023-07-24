package com.green.smart_grade.admin.student;

import com.green.smart_grade.admin.student.model.AdminFindStudentDto;
import com.green.smart_grade.admin.student.model.AdminFindStudentRes;
import com.green.smart_grade.admin.student.model.AdminIInsStudentRes;
import com.green.smart_grade.admin.student.model.AdminInsStudentParam;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminStudentController {

    private final AdminStudentService SERVICE;

    @PostMapping("/student")
    @Operation(summary = "학생등록")
    public AdminIInsStudentRes studentEnrollment(@RequestBody AdminInsStudentParam param){
        return SERVICE.insStudent(param);
    }

    @GetMapping
    @Operation(summary = "학생 검색", description = "학번이나 이름 둘중 하나로 찾기가능")
    public List<AdminFindStudentRes> searchStudent(@RequestParam(required = false) String studentNum, @RequestParam(required = false)String nm,@RequestParam (defaultValue = "1") int page){
        AdminFindStudentDto dto = new AdminFindStudentDto();
        dto.setNm(nm);
        dto.setStudentNum(studentNum);
        return SERVICE.findStudents(dto,page);
    }
}
