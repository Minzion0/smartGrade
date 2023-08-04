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
    @Operation(summary = "교수 프로필 전체 보기" ,description = "page : 기본 1<br>"+ "row : 기본 프로필 10개 <br>")
    public professorSelRes gstAllProfessor(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10")  int row) {
        ProfessorSelDto dto = new ProfessorSelDto();
        dto.setPage(page);
        dto.setRow(row);
        return service.selAllProfessor(dto,page);
    }

    @PutMapping(name = "/pic", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(summary = "프로필 사진 등록", description = "iprofessr : 유저 PK 값<br> "+" 쿼리스트링")
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
    @Operation(summary = "본인이 강의하고 있는 강의 목록 전체")
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
