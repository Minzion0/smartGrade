package com.green.smart_grade.admin;

import com.green.smart_grade.admin.model.*;
import com.green.smart_grade.admin.student.model.AdminFindStudentDto;
import com.green.smart_grade.admin.student.model.AdminFindStudentRes;
import com.green.smart_grade.admin.student.model.AdminIInsStudentRes;
import com.green.smart_grade.admin.student.model.AdminInsStudentParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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



    @PostMapping("/professor")
    @Operation(summary = "교수등록")
    public AdminInsProfessorRes professorEnrollment(@RequestBody AdminInsProfessorParam param){
        return SERVICE.insProfessor(param);

    }






    @GetMapping("/find/pro")
    @Operation(summary = "교수 검색" )
    public AdminProfessorRes findP(@RequestParam (defaultValue = "1") int page,@RequestParam (required = false) String name){
        return SERVICE.findProfessors(page,name);
    }




}
