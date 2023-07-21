package com.green.smart_grade.major;

import com.green.smart_grade.major.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/major")
@RequiredArgsConstructor
@Tag(name = "전공",description = "")
public class MajorController {

    @Autowired
    private final MajorService SERVICE;


    @PostMapping
    @Operation(summary = "전공 등록", description = "" +
            "majorName : 전공 이름 \n" +
            "graduationScore : 졸업 학점")
    public MajorRes postMajor(@RequestParam String majorName, @RequestParam int graduationScore) {
        MajorInsParam p = new MajorInsParam();
        p.setMajorName(majorName);
        p.setGraduationScore(graduationScore);
        return SERVICE.insMajor(p);
    }

    @GetMapping
    @Operation(summary = "전공리스트 전체 보기")
    public List<MajorVo> getMajor() {
        return SERVICE.selMajor();
    }

    @PostMapping("/detail")
    @Operation(summary = "전공 이름으로 검색")
    public MajorVo getMajorDetail(@RequestBody MajorDetailDto dto) {
        dto.setMajorName(dto.getMajorName());
        return SERVICE.selMajorDetail(dto);
    }

    @DeleteMapping
    @Operation(summary = "전공 삭제 ( 삭제여부 0 1 변경)" , description = "" +
            "imajor : 전공 pk \n" +
            "majorName : 전공 이름")
    public int delMajor(@RequestParam Long imajor, @RequestParam String majorName) {
        MajorDelDto dto = new MajorDelDto();
        dto.setImajor(imajor);
        dto.setMajorName(majorName);
        return SERVICE.delMajor(dto);
    }
}
