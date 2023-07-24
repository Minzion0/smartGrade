package com.green.smart_grade.lecture_applly;

import com.green.smart_grade.lecture_applly.model.LectureAppllyInsParam;
import com.green.smart_grade.lecture_applly.model.LectureAppllyRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lectureapplly")
@AllArgsConstructor
@Slf4j
@Tag(name = "강의 신청")
public class LectureAppllyController {
    private final LectureAppllyService service;


    @PostMapping
    @Operation(summary = "강의 등록")
    public LectureAppllyRes postApply(@RequestBody LectureAppllyInsParam param) {
        return service.InsApplly(param);
    }
}
