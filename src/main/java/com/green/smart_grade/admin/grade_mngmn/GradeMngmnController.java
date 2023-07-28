package com.green.smart_grade.admin.grade_mngmn;

import com.green.smart_grade.admin.grade_mngmn.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/grade")
@RequiredArgsConstructor
@Tag(name = "관리자 통합 성적관리")
public class GradeMngmnController {

    @Autowired
    private final GradeMngmnService SERVICE;

    @GetMapping
    @Operation(summary = "이름 학번으로 검색 ", description = "" +
            "page: 페이지번호\n" +
            "\nistudent : 학생pk\n" +
            "\nstudenNum : 학번\n" +
            "\nname : 이름\n")
    public GradeMngmnDetailAvgVo getGradeFindStudent(@RequestParam (defaultValue = ("1"))int page
                        ,@RequestParam (required = false) String semester,@RequestParam (required = false) String grade, @RequestParam (required = false) String studentNum) {
        GradeMngmnAvgDto dto = new GradeMngmnAvgDto();
        if (grade == null) {
            int temp = 0;
            dto.setGrade(temp);
        } else {
            int temp2 = Integer.parseInt(grade);
            dto.setGrade(temp2);
        }
        if (semester == null) {
            int temp = 0;
            dto.setSemester(temp);
        } else {
            int temp2 = Integer.parseInt(semester);
            dto.setSemester(temp2);
        }
        dto.setStudentNum(studentNum);
        return SERVICE.selGradeFindStudentVo(dto,page);
    }
    @GetMapping("/{istudent}")
    @Operation(summary = "상세보기", description = "" +
            "사진 pic \n" +
            "이름 name \n" +
            "성별 gender \n" +
            "\n생년월일 birthdate\n" +
            "전화번호 phone \n" +
            "학번 student_num \n" +
            "전공 major_name\n" +
            "\n입학년도 created_at \n" +
            "email email \n" +
            "현재 학점 score \n" +
            "평점 rating\n" +
            "\nnum : 학번\n" +
            "\nname : 이름")
    public GradeMngmnDetailVo getGradeFindStudentDetail(@PathVariable int istudent) {
        GradeMngmnDetailSelDto dto = new GradeMngmnDetailSelDto();
        dto.setIstudent(istudent);
        return SERVICE.selGradeFindStudentDetail(dto);
    }
}
