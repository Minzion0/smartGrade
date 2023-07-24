package com.green.smart_grade.admin;

import com.green.smart_grade.admin.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Tag(name = "관리자",description = "")
public class AdminController {

    @Autowired
    private final AdminService SERVICE;


    @PostMapping("/student")
    @Operation(summary = "학생등록")
    public AdminIInsStudentRes studentEnrollment(@RequestBody AdminInsStudentParam param){
       return SERVICE.insStudent(param);
    }
    @PostMapping("/professor")

    @Operation(summary = "교수등록")
    public AdminInsProfessorRes professorEnrollment(@RequestBody AdminInsProfessorParam param){
        return SERVICE.insProfessor(param);

    }




    @GetMapping
    @Operation(summary = "학생 검색", description = "학번이나 이름 둘중 하나로 찾기가능")
    public List<AdminFindStudentRes>searchStudent(@RequestParam(required = false) String studentNum,@RequestParam(required = false)String nm){
        AdminFindStudentDto dto = new AdminFindStudentDto();
        dto.setNm(nm);
        dto.setStudentNum(studentNum);
        return SERVICE.findStudents(dto);
    }

    @GetMapping("/find/pro")
    public AdminProfessorRes findP(@RequestParam (defaultValue = "1") int page){
        return SERVICE.findProfessors(page);
    }




}
