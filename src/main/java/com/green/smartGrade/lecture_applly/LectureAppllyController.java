package com.green.smartGrade.lecture_applly;

import com.green.smartGrade.lecture_applly.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professorlecture")
@AllArgsConstructor
@Slf4j
@Tag(name = "교수 강의 신청")
public class LectureAppllyController {
    private final LectureAppllyService service;


    @PostMapping
    @Operation(summary = "강의 등록", description = "ilecture : 강의신청 pk<br>"+
    "ilecture_name : 강의pk<br>"+"ilecture_room : 강의실pk<br>"+"iprofessor : 교수pk<br>"
    +"isemester : 학기pk<br>"+"openingProcedures : 개강절차<br>"+"lectureStrDate : 개강시작 일자<br>"
    +"lectureEndDate : 개강종료 일자<br>"+"lectureStrTime : 수업시작시간<br>"+"lectureEndTime : 수업종료시간<br>"
    +"attendace : 출결 배점<br>"+"midtermExamination : 중간고사 배점<br>"+"finalExamination : 기말고사 배점<br>"
    +"lectureMaxPeople : 강의최대 인원<br>"+"gradeLimit : 학년범위<br>"+"delYn : 삭제 여부<br>"
           +"<br>" +"기본 배점 출결(20),중간고사(40),기말고사(40)<br>")
    public LectureAppllyRes postApply(@RequestBody LectureAppllyInsParam param){

            return service.InsApplly(param);


    }


    @GetMapping
    @Operation(summary = "신청중인 강의 리스트 뽑기")
  public LectureApllySelRes getLectureApplly
            (@RequestParam(defaultValue = "1") int page,@RequestParam (required = false) Long iprofessor){



        return service.selLectureApplly(page,iprofessor);
    }
}
