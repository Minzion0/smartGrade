package com.green.smartGrade.admin.professor;

import com.green.smartGrade.admin.professor.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@Tag(name = "관리자 교수 관리")
public class AdminProfessorController {

    private final AdminProfessorService SERVICE;

    @PostMapping("/professor")
    @Operation(summary = "교수등록")
    public AdminInsProfessorRes professorEnrollment(@RequestBody AdminInsProfessorParam param) {
        return SERVICE.insProfessor(param);

    }

    @GetMapping("/professor")
    @Operation(summary = "교수 검색")
    public AdminProfessorRes findP(@RequestParam(defaultValue = "1") int page, @RequestParam(required = false) String name,@RequestParam (required = false,defaultValue = "0")Long imajor) {

        AdminFindProfessorDto dto = new AdminFindProfessorDto();
        dto.setImajor(imajor);
        dto.setName(name);
        return SERVICE.findProfessors(page, dto);
    }

    @GetMapping("/professor/{iprofessor}")
    @Operation(summary = "교수 상세보기")
    public AdminProfessorDetailVo findProfessorDetail(@PathVariable Long iprofessor) {
        AdminProfessorDetailDto dto = new AdminProfessorDetailDto();
        dto.setIprofessor(iprofessor);
        return SERVICE.findProfessorDetail(dto);
    }
}
