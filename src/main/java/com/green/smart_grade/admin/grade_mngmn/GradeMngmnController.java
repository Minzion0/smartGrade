package com.green.smart_grade.admin.grade_mngmn;

import com.green.smart_grade.admin.grade_mngmn.model.GradeMngmnDetailSelDto;
import com.green.smart_grade.admin.grade_mngmn.model.GradeMngmnDetailVo;
import com.green.smart_grade.admin.grade_mngmn.model.GradeMngmnSelDto;
import com.green.smart_grade.admin.grade_mngmn.model.GradeMngmnVo;
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
    public GradeMngmnVo getGradeFindStudent(@RequestParam int num, @RequestParam String name) {
        GradeMngmnSelDto dto = new GradeMngmnSelDto();
        dto.setStudentNum(num);
        dto.setName(name);
        return SERVICE.selGradeFindStudent(dto);
    }
    @GetMapping("/detail")
    @Operation(summary = "상세보기")
    public GradeMngmnDetailVo getGradeFindStudentDetail(@RequestParam int num
            , @RequestParam String name) {
        GradeMngmnDetailSelDto dto = new GradeMngmnDetailSelDto();
        dto.setStudentNum(num);
        dto.setName(name);
        return SERVICE.selGradeFindStudentDetail(dto);
    }
}
