package com.green.smartGrade.admin;


import com.green.smartGrade.admin.model.*;
import com.green.smartGrade.config.exception.AdminException;
import com.green.smartGrade.config.exception.CommonErrorCode;
import com.green.smartGrade.config.exception.ErrorCode;
import com.green.smartGrade.config.exception.MyErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Tag(name = "관리자 강의 관리")
public class AdminController {

    private final AdminService SERVICE;

    @PostMapping("/semester")
    @Operation(summary = "학기 등록", description = "semester = 학기 1~2만 ")
    public AdminInsSemesterRes semesterIns(@RequestBody AdminInsSemesterParam param) throws AdminException {
        return SERVICE.semesterIns(param);
    }

    @PostMapping("/lecture-name")
    @Operation(summary = "강의명 등록",description = "강의명 등록과 필요 학점 꼭 등록해야함")
    public ResponseEntity<AdminInsLectureNameRes> insLectureName(@RequestBody AdminInsLectureNameParam param)throws AdminException{
        AdminInsLectureNameRes res = SERVICE.insLectureName(param);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/lecture-name")
    @Operation(summary = "강의명 검색")
    public ResponseEntity<AdminFindLectureNameRes>findLectureName(@RequestParam (required = false)String lectureName  ){
        AdminFindLectureNameRes res = SERVICE.findLectureName(lectureName);
        return ResponseEntity.ok().body(res);
    }


    @GetMapping("/semester")
    @Operation(summary = "학기 확인")
    public List<AdminGetSemesterVo> getSemester(@RequestParam(required = false) String year){
        return SERVICE.getSemester(year);
    }

    @GetMapping("/lecture/{ilecture}")
    @Operation(summary = "해당 강의 수강학생 리스트")
    public ResponseEntity<?> findProfessors(@PathVariable Long ilecture){

        return SERVICE.findLectureStudent(ilecture);
    }

    @GetMapping("/lecture")
    @Operation(summary = "강의 리스트" ,
            description = "ilecture\": pk,<br>\n" +
            "      \"lectureNm\": \"강의명<br>\",\n" +
            "      \"semester\": 학기,<br>\n" +
            "      \"majorName\": \"전공명<br>\",\n" +
            "      \"nm\": \"교수명\",<br>\n" +
            "      \"lectureRoomNm\": \"호실<br>\",\n" +
            "      \"buildingNm\": \"건물명<br>\",\n" +
            "      \"gradeLimit\": 학년제한 ex )3이면 3학년이상 수강가능<br>,\n" +
            "      \"score\": 해당 강의 이수학점<br>,\n" +
            "      \"strDate\": \"2023-03-04<br>\",\n" +
            "      \"endDate\": \"2023-06-30<br>\",\n" +
            "      \"strTime\": \"09:00:00<br>\",\n" +
            "      \"endTime\": \"10:00:00<br>\",\n" +
            "      \"maxPeople\": 강의 수강 가능인원,<br>\n" +
            "      \"currentPeople\": 현 수강인원,<br>\n" +
            "      \"procedures\": 강의 상태 0 : 반려 1강의 개설 신청 2개설 인가 수강신청 가능 3 개강 -2 개강중 빼고 모두 보기 ,<br>\n" +
            "      \"delYn\": 삭제여부<br>")
    public AdminSelRes selLecture(HttpServletRequest req,@RequestParam (defaultValue = "1") int page, @RequestParam (required = false,defaultValue = "-1")int  procedures, @RequestParam (required = false) String nm,@RequestParam(required = false,defaultValue = "0")int ilectureName){
       log.info("hd : {}",req.getHeader("Authorization"));
        AdminSelLectureParam param = new AdminSelLectureParam();
        param.setNm(nm);
        param.setPage(page);
        param.setProcedures(procedures);
        param.setIlectureName(ilectureName);
        return SERVICE.selLecture(param);
    }

    @PatchMapping("/lecture")
    @Operation(summary = "강의상태 변경",description = "procedures= 0이 강의 신청 반려 0일때는 ctnt에 반려사유 작성<br><br>" +
            "1이 기본 강의 신청 2 신청 통과 학생들이 신청을 넣을수있는 상태 3 최종 강의 오픈<br><br>" +
            "ilecture 강의 pk")
    public AdminUpdLectureRes updLecture(@RequestBody AdminUpdLectureDto dto){

        return SERVICE.lectureModify(dto);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> adminException(ErrorCode e){
        MyErrorResponse.MyErrorResponseBuilder builder = MyErrorResponse.builder();
        builder.code(CommonErrorCode.ADMIN_EXCEPTION.getMessage()).message(e.getMessage()).build();

        return ResponseEntity.status(500).body(builder);
    }



}
