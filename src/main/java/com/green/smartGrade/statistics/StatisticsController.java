package com.green.smartGrade.statistics;

import com.green.smartGrade.statistics.model.StatisticsSelDto;
import com.green.smartGrade.statistics.model.StatisticsSelRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistics")
@RequiredArgsConstructor
@Tag(name = "통계")
public class StatisticsController {
    private final StatisticsService service;

    @GetMapping
    @Operation(summary = "통계표" ,description = "imajor : 학생전공<br>"+"ilecture : 강의 pk<br>"+"lectureName : 강의 이름 <br>"+
            "lectureCount : 강의 들은 수<br>"+
            "percentage 각 강의 퍼센트" )
    public StatisticsSelRes getStatistics() {

        return service.selStatistics();
    }

}
