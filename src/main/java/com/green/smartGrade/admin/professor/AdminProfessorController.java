package com.green.smartGrade.admin.professor;

import com.green.smartGrade.admin.professor.model.*;
import com.green.smartGrade.config.exception.AdminException;
import com.green.smartGrade.config.exception.CommonErrorCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@Tag(name = "관리자 교수 관리")
public class AdminProfessorController {

    private final AdminProfessorService SERVICE;

    @PostMapping("/professor")
    @Operation(summary = "교수등록")
    public ResponseEntity<AdminInsProfessorRes> professorEnrollment(@RequestBody AdminInsProfessorParam param)throws AdminException{
        AdminInsProfessorRes res = SERVICE.insProfessor(param);
        return ResponseEntity.ok().body(res);
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
