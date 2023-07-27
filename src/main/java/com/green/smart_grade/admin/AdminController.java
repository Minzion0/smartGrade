package com.green.smart_grade.admin;


import com.green.smart_grade.admin.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Tag(name = "관리자",description = "")
public class AdminController {

    @Autowired
    private final AdminService SERVICE;


    @GetMapping("/lecture/{ilecture}")
    @Operation(summary = "수강학생 리스트")
    public List<AdminLectureInStudentRes>findProfessors(@PathVariable Long ilecture){
        return SERVICE.findlectureStudent(ilecture);
    }

    @GetMapping("/lecture")
    @Operation(summary = "강의 리스트")
    public AdminSelRes selLecture(@RequestParam (defaultValue = "1") int page,@RequestParam int procedures,@RequestParam (required = false) String nm){
        AdminSelLectureParam param = new AdminSelLectureParam();
        param.setNm(nm);
        param.setPage(page);
        param.setProcedures(procedures);
        return SERVICE.selLecture(param);
    }

    @PatchMapping("/lecture")
    @Operation(summary = "강의상태 변경",description = "procedures= 0이 강의 신청 반려 0일때는 ctnt에 반려사유 작성<br><br>" +
            "1이 기본 강의 신청 2 신청 통과 학생들이 신청을 넣을수있는 상태 3 최종 강의 오픈<br><br>" +
            "ilecture 강의 pk")
    public AdminUpdLectureRes updLecture(@RequestBody AdminUpdLectureDto dto){
        return SERVICE.lectureModify(dto);
    }






}
