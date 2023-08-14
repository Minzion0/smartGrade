package com.green.smartGrade.admin.major;

import com.green.smartGrade.admin.major.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/major")
@RequiredArgsConstructor
@Tag(name = "관리자 전공 관리",description = "")
public class AdminMajorController {

    @Autowired
    private final AdminMajorService SERVICE;


    @PostMapping
    @Operation(summary = "전공 등록", description = "" +
            "majorName : 전공 이름 \n" +
            "\n graduationScore : 졸업 학점")
    public MajorRes postMajor(@RequestParam String majorName, @RequestParam int graduationScore) {
        MajorInsParam p = new MajorInsParam();
        p.setMajorName(majorName);
        p.setGraduationScore(graduationScore);
        return SERVICE.insMajor(p);
    }

    @GetMapping
    @Operation(summary = "전공리스트 전체 보기 ( 검색 )", description = "" +
            "imajor : 전공 pk\n" +
            "\nmajorName : 전공 이름\n" +
            "\ngraduationScore : 졸업 시 필요한 학점")
    public MajorfindRes getMajor(@RequestParam (defaultValue = "1") int page,
                                 @RequestParam (required = false) String majorName
                                ,@RequestParam(required = false) String delYn) {
        MajorSelDto dto = new MajorSelDto();
        dto.setMajorName(majorName);
        dto.setPage(page);
        dto.setDelYn(delYn);
        return SERVICE.selMajor(dto);
    }


    @DeleteMapping
    @Operation(summary = "전공 폐지 ( 삭제여부 0 1 변경)" , description = "" +
            "imajor : 전공 pk \n" +
            "\n majorName : 전공 이름")
    public int delMajor(@RequestParam Long imajor) {
        MajorDelDto dto = new MajorDelDto();
        dto.setImajor(imajor);
        return SERVICE.delMajor(dto);
    }

    @PatchMapping
    @Operation(summary = "전공 이름 수정", description = "" +
            "imajor : 전공 pk \n" +
            "\n majorName : 전공 이름")
    public MajorUpdRes patchMajor(@RequestBody MajorUpdParam p) throws Exception{
        return SERVICE.updMajor(p);
    }
}
