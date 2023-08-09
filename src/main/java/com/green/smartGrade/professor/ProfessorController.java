package com.green.smartGrade.professor;

import com.green.smartGrade.professor.model.*;
import com.green.smartGrade.security.config.security.model.MyUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/professor")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "교수 프로필")
public class ProfessorController {
    private final ProfessorService service;


    @GetMapping
    @Operation(summary = "교수 프로필 보기",description = "iprofessor : 교수pk")
    public professorSelRes getProfessor(@RequestParam(required = false) Long iprofessor) {

        return service.selProfessor(iprofessor);
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

    @PutMapping("/changPassword")
    @Operation(summary = "초기 비밀번호 변경")
    public ResponseEntity<?> updPassword(@AuthenticationPrincipal MyUserDetails details,
                                         @RequestBody ProfessorUpdPasswordParam param) {
        ProfessorUpdPasswordDto dto = new ProfessorUpdPasswordDto();
        Long iuser = details.getIuser();
        String role = details.getRoles().get(0);
        dto.setIprofessor(iuser);
        dto.setRole(role);
        return ResponseEntity.ok().body(service.updPassword(dto, param));
    }

    @DeleteMapping
    @Operation(summary = "사진삭제", description = "pic : 사진 업데이트로 null 값으로 바꿈<br>" + "iprofessor : 교수pk")
    public int delPicProfessor(@RequestBody ProfessorDelPic pic) {
        return service.delpicByprofessor(pic);
    }
}
