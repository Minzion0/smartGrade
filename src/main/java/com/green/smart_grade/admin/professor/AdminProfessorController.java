package com.green.smart_grade.admin.professor;

import com.green.smart_grade.admin.professor.model.AdminInsProfessorParam;
import com.green.smart_grade.admin.professor.model.AdminInsProfessorRes;
import com.green.smart_grade.admin.professor.model.AdminProfessorRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/professoor")
@Tag(name = "관리자 교수 관리")
public class AdminProfessorController {

    private final AdminProfessorService SERVICE;

    @PostMapping("/professor")
    @Operation(summary = "교수등록")
    public AdminInsProfessorRes professorEnrollment(@RequestBody AdminInsProfessorParam param){
        return SERVICE.insProfessor(param);

    }

    @GetMapping("/find/pro")
    @Operation(summary = "교수 검색" )
    public AdminProfessorRes findP(@RequestParam (defaultValue = "1") int page, @RequestParam (required = false) String name){
        return SERVICE.findProfessors(page,name);
    }



}
