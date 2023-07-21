package com.green.smart_grade.major;

import com.green.smart_grade.major.model.MajorInsDto;
import com.green.smart_grade.major.model.MajorInsParam;
import com.green.smart_grade.major.model.MajorRes;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "전공",description = "")
public class MajorController {

    @Autowired
    private final MajorService SERVICE;


    @PostMapping
    public MajorRes insMajor(MajorInsDto dto) {
        MajorInsParam p = new MajorInsParam();
        p.setMajorName(dto.getMajorName());
        p.setGraduationScore(dto.getGraduationScore());
        return SERVICE.insMajor(p);
    }
}
