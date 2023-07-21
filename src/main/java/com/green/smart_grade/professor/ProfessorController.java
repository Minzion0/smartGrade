package com.green.smart_grade.professor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Professor")
@RequiredArgsConstructor
@Tag(name = "교수 프로필")
public class ProfessorController {
    private final ProfessorService service;




}
