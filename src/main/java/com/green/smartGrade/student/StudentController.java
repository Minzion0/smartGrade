package com.green.smartGrade.student;

import com.green.smartGrade.professor.model.ProfessorParam;
import com.green.smartGrade.professor.model.ProfessorUpRes;
import com.green.smartGrade.professor.model.ProfessorUpdDto;
import com.green.smartGrade.professor.model.ProfessorUpdPasswordDto;
import com.green.smartGrade.security.config.security.model.MyUserDetails;
import com.green.smartGrade.student.model.*;
import com.green.smartGrade.utils.GradeUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/student")
@Tag(name = "학생")
public class StudentController {
    private final StudentService service;


    @PostMapping
    @Operation(summary = "학생 수강 신청",description = "ilectureStudent : 강의 pk 자동으로 올라감<br>"
            +"istudent : 학생pk<br>"+"ilecture : 수강신청할 강의pk<br>"+"dayweek : 수강요일 0~6 일~토<br>"+"finishedYn : 수료여부<br>"
            +"attendance : 출결<br>"+"midtermExamination : 중간고사<br>"+"finalExamination : 기말고사<br>"+"totalScore : 총점수<br>"
    +"createdAt : 수강신청 일자<br>"+"delYn : 삭제여부<br>"+"<br>"+"finishedYn : 수료여부는 신청이기 때문에 0으로 시작")
    public StudentInsRes postStudent(@AuthenticationPrincipal MyUserDetails details,@RequestBody StudentParam param) {
        StudentInsDto dto = new StudentInsDto();
        dto.setIstudent(details.getIuser());
        dto.setIlecture(param.getIlecture());
        dto.setFinishedYn(param.getFinishedYn());

        return service.insSdy(dto);
    }

    @GetMapping
    @Operation(summary = "학생 강의별 성적 조회",description = "istudent : 학생pk<br>"+"studentNum : 학번<br>"+"ilectureName : 강의이름pk<br>"
    +"lectureName : 강의이름<br>"+"iprofessor : 담당교수pk<br>"+"score : 강의학점<br>"+
            "attendance : 출결<br>"+"midtermExamination : 중간고사<br>"+"finalExamination : 기말고사<br>"+"totalScore: 총점수<br>"
    +"grade : 학년<br>"+"rating : 알파벳등급<br>"+"finishedYn : 수료여부 1이 수료했다는 의미<br>")
    public StudentSelRes getStudentGrade(@AuthenticationPrincipal MyUserDetails details) {
        StudentSelDto dto = new StudentSelDto();
        dto.setIstudent(details.getIuser());

        return service.selAllSdy(dto);
    }

    @GetMapping("/profile")
    @Operation(summary = "학생 프로필 조회",description = "istudent : 학생pk<br>"+"studentNum : 학번<br>"+"imajor : 전공<br>"+
    "grade : 학년<br>"+ "nm : 이름<br>"+"pic : 사진<br>"+"birthdate : 생년월일<br>"+"phone : 폰번호<br>"+"email : 이메일<br>"+"address : 주소<br>"
    +"finishedYn : 재학여부<br> 1->재학중, 2-> 졸업<br>"+"score : 현재 채운 학점")
    public StudentDatilProFileVo getStudentProfile(@AuthenticationPrincipal MyUserDetails details) {
        StudentSelProfileDto dto = new StudentSelProfileDto();
        dto.setIstudent(details.getIuser());
        return service.selStudentProfile(dto);
    }

    @GetMapping("/studentpoint")
    @Operation(summary = "학점 조회",description = "studentNum : 학번<br>"+"istudent : 학생pk<br>"+"imajor : 전공<br>"+
    "grade : 학년<br>"+"finishedYn : 재학여부<br> 1->재학중, 2-> 졸업<br>"+"score : 현재 학점<br>"
            +"graduationScore : 전공학점<br>"+"remainingPoints : 채워야할 학점")
    public StudentSelPointRes getStudentPoint(@AuthenticationPrincipal MyUserDetails details) {
        StudentSelPointDto dto = new StudentSelPointDto();
        dto.setIstudent(details.getIuser());
        return service.selStudentRemainingPoint(dto);
    }

//    @PutMapping(name = "/pic", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    @Operation(summary = "학생 프로필 수정",description = "studentNum : 학번<br>"+"phone : 폰번호<br>"+"email : 이메일<br>"+"address : 주소<br>"
//    +"updatedAt : 수정일자 <br>" + "pic : 사진")
//    public StudentUpRes putStudentProfile(@RequestPart(required = false) MultipartFile pic
//                ,@AuthenticationPrincipal MyUserDetails details
//            ,@RequestPart(required = false) StudentUpdDto dto) {
//        StudentUpParam param = new StudentUpParam();
//        param.setPhone(dto.getPhone());
//        param.setEmail(dto.getEmail());
//        param.setAddress(dto.getAddress());
//        param.setIstudent(details.getIuser());
//        return service.upStudent(pic,param);
//    }

    @PutMapping(name = "/pic", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(summary = "학생 프로필 수정",description = "studentNum : 학번<br>"+"phone : 폰번호<br>"+"email : 이메일<br>"+"address : 주소<br>"
    +"updatedAt : 수정일자 <br>" + "pic : 사진")
    public StudentUpRes putPicProfessor(@RequestPart(required = false) MultipartFile pic, @AuthenticationPrincipal MyUserDetails details,
                                          @RequestPart StudentUpdDto dto) {
        StudentUpParam param = new StudentUpParam();
        param.setPhone(dto.getPhone());
        param.setEmail(dto.getEmail());
        param.setAddress(dto.getAddress());
        param.setIstudent(details.getIuser());

        // 이전 프로필 사진 삭제
        service.deleteStudentPic(param.getIstudent());

        return service.upStudent(pic, param);
    }





    @PutMapping("/changPassword")
    @Operation(summary = "비밀번호 변경",
    description = "studentPassword : 바꿀 비밀번호 <br>" + "currentStudentPassword : 현재 비밀번호")
    public ResponseEntity<?> updPassword(@AuthenticationPrincipal MyUserDetails details, @RequestBody StudentUpdPasswordParam param ) throws Exception {
        StudentUpdPasswordDto dto = new StudentUpdPasswordDto();
        Long  iuser = details.getIuser();
        String role = details.getRoles().get(0);
        dto.setIstudent(iuser);
        dto.setRole(role);

        return ResponseEntity.ok().body(service.updPassword(dto, param));
    }

    @DeleteMapping
    @Operation(summary = "학생 사진 삭제")
    public ResponseEntity<String> deleteFile(@AuthenticationPrincipal MyUserDetails details) {
        try {
            service.deleteUploadedFile(details.getIuser());
            return ResponseEntity.ok("사진파일이 삭제 완료되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting file: " + e.getMessage());
        }
    }

}
