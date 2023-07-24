package com.green.smart_grade.admin;


import com.green.smart_grade.admin.model.AdminSelLectureParam;
import com.green.smart_grade.admin.model.AdminSelRes;
import com.green.smart_grade.admin.model.AdminUpdLectureDto;
import com.green.smart_grade.admin.model.AdminUpdLectureRes;
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



    @GetMapping
    @Operation(summary = "강의 리스트")
    public AdminSelRes selLecture(@RequestParam (defaultValue = "1") int page,@RequestParam int procedures,@RequestParam (required = false) String nm){
        AdminSelLectureParam param = new AdminSelLectureParam();
        param.setNm(nm);
        param.setPage(page);
        param.setProcedures(procedures);
        return SERVICE.selLecture(param);
    }

    @PatchMapping
    @Operation(summary = "강의상태 변경")
    public AdminUpdLectureRes updLecture(@RequestBody AdminUpdLectureDto dto){
        return SERVICE.lectureModify(dto);
    }





}
