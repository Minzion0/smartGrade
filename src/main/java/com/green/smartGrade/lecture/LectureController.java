package com.green.smartGrade.lecture;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lecture")
@Tag(name = "통합 강의관리")
@RequiredArgsConstructor
public class LectureController {

    @Autowired
    private final LectureService SERVICE;
}
