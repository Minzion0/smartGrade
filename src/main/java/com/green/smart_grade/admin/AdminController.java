package com.green.smart_grade.admin;

import com.green.smart_grade.admin.model.AdminIInsStudentRes;
import com.green.smart_grade.admin.model.AdminInsStudentParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Tag(name = "관리자",description = "")
public class AdminController {

    @Autowired
    private final AdminService SERVICE;


    @PostMapping
    public AdminIInsStudentRes student_enrollment(@RequestBody AdminInsStudentParam param){
       return SERVICE.insStudent(param);
    }




}
