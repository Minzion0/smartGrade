package com.green.smartGrade.admin.grade_mngmn;

import com.green.smartGrade.admin.grade_mngmn.model.*;
import com.green.smartGrade.professor.professorgradeMngmn.model.ProfessorGradeUpdParam;
import com.green.smartGrade.professor.professorgradeMngmn.model.ProfessorGradeUpdRes;
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


    @PostMapping
    public GradeMngmnRes insGradeMngmn(GradeMngmnInsParam p) {
        return SERVICE.insGradeMngmn(p);
    }


    @GetMapping
    @Operation(summary = "이름 학번으로 검색 ", description = "" +
            "page: 페이지번호\n" +
            "\ngrade : 학년\n" +
            "\nsemester : 학기\n" +
            "\nlectureName : 과목이름\n" +
            "\nprofessorName : 교수이름\n" +
            "\nlectureScore : 과목학점\n" +
            "\ntotalScore : 과목 총점\n" +
            "\nrating : 과목 등급\n" +
            "\navgScore : 학기 평균점수\n" +
            "\navgRating : 학기 평점")
    public GradeMngmnDetailAvgVo getGradeFindStudent(@RequestParam(defaultValue = ("1")) int page
            , @RequestParam(required = false, defaultValue = "0") int grade
            , @RequestParam String studentNum) {
        GradeMngmnAvgDto dto = new GradeMngmnAvgDto();
        dto.setPage(page);
        dto.setGrade(grade);
        dto.setStudentNum(studentNum);

        return SERVICE.selGradeFindStudentVo(dto);
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
    public GradeMngmnDetailVo getGradeFindStudentDetail(@PathVariable Long istudent) {
        GradeMngmnDetailSelDto dto = new GradeMngmnDetailSelDto();
        dto.setIstudent(istudent);
        return SERVICE.selGradeFindStudentDetail(dto);
    }

    @PatchMapping
    @Operation(summary = "총점 + 평점 수정하기")
    public GradeUpdRes updAvgScore(@RequestParam Long istudent, @RequestParam int semester) {
        GradeUpdParam p = new GradeUpdParam();
        p.setIstudent(istudent);
        p.setSemester(semester);
        return SERVICE.updAvgScore(p);
    }
}
