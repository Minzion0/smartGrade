package com.green.smart_grade.admin.grade_mngmn;

import com.green.smart_grade.admin.grade_mngmn.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grademngmn")
@RequiredArgsConstructor
@Tag(name = "통합 성적관리")
public class GradeMngmnController {

    @Autowired
    private final GradeMngmnService SERVICE;

    @GetMapping
    @Operation(summary = "이름 학번으로 검색", description = "" +
            "num : 학번\n" +
            "\nname : 이름\n")
    public GradeMngmnRes getGradeFindStudent(@RequestParam (defaultValue = ("1"))int page
                        , @RequestParam int num, @RequestParam String name) {
        GradeMngmnSelDto dto = new GradeMngmnSelDto();
        dto.setName(name);
        dto.setStudentNum(num);
        return SERVICE.selGradeFindStudent(dto,page);

    }
    @GetMapping("/detail")
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
    public GradeMngmnDetailVo getGradeFindStudentDetail(@RequestParam int num
            , @RequestParam String name) {
        GradeMngmnDetailSelDto dto = new GradeMngmnDetailSelDto();
        dto.setStudentNum(num);
        dto.setName(name);
        return SERVICE.selGradeFindStudentDetail(dto);
    }
}
