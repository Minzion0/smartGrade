package com.green.smartGrade.professor;

import com.green.smartGrade.professor.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/professor")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "교수 프로필")
public class ProfessorController {
    private final ProfessorService service;


    @GetMapping("/list")
    @Operation(summary = "교수 리스트 보기",description = "iprofessor : 교수pk")
    public professorSelRes getProfessor(@RequestParam(required = false) Long iprofessor) {

        return service.selProfessor(iprofessor);
    }




    @GetMapping
    @Operation(summary = "교수 프로필 전체 보기" ,description = "page : 기본 1<br>"+ "row : 기본 프로필 10개 <br>"+"<br>"+"iprofessor : 교수pk"
    +"name : 이름<br>"+ "gender : 성별<br>"+"birthdate : 생년월일<br>"+"phone : 폰번호<br>"+"email : 이메일<br>" + "address : 주소")
    public professorSelRes gstAllProfessor(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10")  int row) {
        ProfessorSelDto dto = new ProfessorSelDto();
        dto.setPage(page);
        dto.setRow(row);
        return service.selAllProfessor(dto,page);
    }

    @PutMapping(name = "/pic", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(summary = "프로필 수정", description = "phone : 폰번호<br>"+
            "email : 이메일 <br>"+"address : 주소<br>"+"iprofessor : 교수pk<br>" + "pic : 사진")
    public ProfessorUpRes patchPicProfessor(@RequestPart(required = false) MultipartFile pic,
                                            @RequestPart  ProfessorParam param) {
        return service.upProfessor(pic, param);
    }

//    @PutMapping
//    @Operation(summary = "교수 프로필 수정",description = "imajor : 전공pk<br>"+"phone : 폰번호<br>"+
//            "email : 이메일 <br>"+"address : 주소<br>"+"iprofessor : 교수pk<br>")
//    public ProfessorUpRes putProfessor(@RequestBody ProfessorParam param) {
//
//        return service.upProfessor(param);
//    }



    @GetMapping("/{iprofessor}")
    @Operation(summary = "본인의 강의 목록 전체",description = "iprofessor : 교수pk<br>"+"openingProcedures : 개강절차 0 반려 1개강신청 2개강인원모집중 3개강 4수강종료<br>"
    +"lectureStrDate : 강의 시작일자<br>"+"lectureEndDate : 강의 종강 일자<br>"+"lectureStrTime : 강의시작 시간<br>"+"lectureEndTime : 강의종료 시간<br>"
    +"gradeLimit : 입력된 학년 이상 들을 수 있음<br>"+"lectureName : 강의 이름<br>"+"score : 강의 학점<br>"+"lectureRoomName : 강의실<br>"
    +"maxCapacity : 강의실 수용 인원<br>"+"dayWeek : 강의 시작요일<br>"+"semester : 학기")
    public SelProfessorRes selProfessorLecture (@PathVariable int iprofessor,
                                                @RequestParam (defaultValue = "1") int page,
                                                @RequestParam (required = false ) String openingProcedures) {
        ProfessorSelLectureDto dto = new ProfessorSelLectureDto();
        dto.setIprofessor(iprofessor);
        dto.setPage(page);
        dto.setOpeningProcedures(openingProcedures);
        return service.selProfessorLecture(dto);
    }
}