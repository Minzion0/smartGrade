package com.green.smart_grade.professor.professorgradeMngmn;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professorstudent")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "학생 성적관리")
public class professorgradeMngmnContoller {
    private  final professorgradeMngmnService service;





}
