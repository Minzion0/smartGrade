package com.green.smart_grade.major;

import com.green.smart_grade.major.model.MajorInsDto;
import com.green.smart_grade.major.model.MajorInsParam;
import com.green.smart_grade.major.model.MajorRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public MajorRes insMajor(@RequestParam String majorName, @RequestParam int graduationScore) {
        MajorInsParam p = new MajorInsParam();
        p.setMajorName(majorName);
        p.setGraduationScore(graduationScore);
        return SERVICE.insMajor(p);
    }
}
