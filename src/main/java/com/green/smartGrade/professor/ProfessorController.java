package com.green.smartGrade.professor;

import com.green.smartGrade.professor.model.*;
import com.green.smartGrade.security.config.security.model.MyUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    @Operation(summary = "교수 프로필 보기")
    public ProfessoreDatailProFileVo getProfessor(@AuthenticationPrincipal MyUserDetails details)  {
        ProfessorSelDto dto = new ProfessorSelDto();
        dto.setIprofessor(details.getIuser());

        return service.selProfessor(dto);
    }



//    @PutMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    @Operation(summary = "프로필 수정", description = "phone : 폰번호<br>"+
//            "email : 이메일 <br>"+"address : 주소<br>"+"iprofessor : 교수pk<br>" + "pic : 사진")
//    public ProfessorUpRes putPicProfessor(@RequestPart(required = false) MultipartFile pic,@AuthenticationPrincipal MyUserDetails details,
//                                            @RequestPart  ProfessorUpdDto dto) {
//        ProfessorParam param = new ProfessorParam();
//        param.setPhone(dto.getPhone());
//        param.setEmail(dto.getEmail());
//        param.setAddress(dto.getAddress());
//        param.setIprofessor(details.getIuser());
//        return service.upProfessor(pic, param);
//    }

    @PutMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(summary = "프로필 수정", description = "phone : 폰번호<br>"+
            "email : 이메일 <br>"+"address : 주소<br>"+"iprofessor : 교수pk<br>" + "pic : 사진")
    public ProfessorUpRes putPicProfessor(@RequestPart(required = false) MultipartFile pic, @AuthenticationPrincipal MyUserDetails details,
                                          @RequestPart ProfessorUpdDto dto) {
        ProfessorParam param = new ProfessorParam();
        param.setPhone(dto.getPhone());
        param.setEmail(dto.getEmail());
        param.setAddress(dto.getAddress());
        param.setIprofessor(details.getIuser());

        // 이전 프로필 사진 삭제
        service.deleteProfessorPic(param.getIprofessor());

        return service.upProfessor(pic, param);
    }

    @GetMapping("/lecture-List")
    @Operation(summary = "본인의 강의 목록 전체",description = "iprofessor : 교수pk<br>"+"openingProcedures : 개강절차 0 반려 1개강신청 2개강인원모집중 3개강 4수강종료<br>"
    +"lectureStrDate : 강의 시작일자<br>"+"lectureEndDate : 강의 종강 일자<br>"+"lectureStrTime : 강의시작 시간<br>"+"lectureEndTime : 강의종료 시간<br>"
    +"gradeLimit : 입력된 학년 이상 들을 수 있음<br>"+"lectureName : 강의 이름<br>"+"score : 강의 학점<br>"+"lectureRoomName : 강의실<br>"
    +"maxCapacity : 강의실 수용 인원<br>"+"dayWeek : 강의 시작요일<br>"+"semester : 학기")
    public SelProfessorRes selProfessorLecture (@AuthenticationPrincipal MyUserDetails details,
                                                @RequestParam (defaultValue = "1") int page,
                                                @RequestParam (required = false ) String openingProcedures) {
        ProfessorSelLectureDto dto = new ProfessorSelLectureDto();
        dto.setIprofessor(details.getIuser());
        dto.setPage(page);
        dto.setOpeningProcedures(openingProcedures);
        return service.selProfessorLecture(dto);
    }

    @PutMapping("/changPassword")
    @Operation(summary = "비밀번호 변경",
            description = "studentPassword : 바꿀 비밀번호 <br>" + "currentProfessorPassword : 현재 비밀번호")
    public ResponseEntity<?> updPassword(@AuthenticationPrincipal MyUserDetails details,
                                         @RequestBody ProfessorUpdPasswordParam param) throws Exception {
        ProfessorUpdPasswordDto dto = new ProfessorUpdPasswordDto();
        Long iuser = details.getIuser();
        String role = details.getRoles().get(0);
        dto.setIprofessor(iuser);
        dto.setRole(role);
        return ResponseEntity.ok().body(service.updPassword(dto, param));
    }




    @DeleteMapping
    @Operation(summary = "교수 사진 삭제")
    public ResponseEntity<String> deleteFile(@AuthenticationPrincipal MyUserDetails details) {
        try {
            service.deleteUploadedFile(details.getIuser());
            return ResponseEntity.ok("File deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting file: " + e.getMessage());
        }
    }
}
