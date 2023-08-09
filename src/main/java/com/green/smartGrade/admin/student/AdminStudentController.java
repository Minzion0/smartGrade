package com.green.smartGrade.admin.student;

import com.green.smartGrade.admin.student.model.*;
import com.green.smartGrade.config.exception.AdminException;
import com.green.smartGrade.config.exception.CommonErrorCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@Tag(name = "관리자 학생 관리")
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminStudentController {

    private final AdminStudentService SERVICE;

    @PostMapping("/students")
    @Operation(summary = "학생등록")
    public ResponseEntity<?> studentEnrollment(@RequestBody AdminInsStudentParam param) throws AdminException {
        AdminIInsStudentRes res = SERVICE.insStudent(param);

        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/students")
    @Operation(summary = "학생 검색", description = "학번이나 이름 둘중 하나로 찾기가능")
    public AdminStudentRes searchStudent(@RequestParam(required = false) String studentNum, @RequestParam(required = false)String nm, @RequestParam (defaultValue = "1") int page
            ,@RequestParam (defaultValue = "0") int grade,@RequestParam (defaultValue = "0",required = false) int finishedYn
            ,@RequestParam (required = false,defaultValue = "0")Long imajor){

        AdminFindStudentDto dto = new AdminFindStudentDto();
        dto.setGrade(grade);
        dto.setNm(nm);
        dto.setImajor(imajor);
        dto.setFinishedYn(finishedYn);
        dto.setStudentNum(studentNum);
        return SERVICE.findStudents(dto,page);
    }

    @GetMapping("/students/{istudent}")
    @Operation(summary = "학생 디테일")
    public AdminStudentDetalRes studentDet(@PathVariable Long istudent){
        return SERVICE.studentDet(istudent);
    }


}
