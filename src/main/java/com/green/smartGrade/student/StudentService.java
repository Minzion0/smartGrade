package com.green.smartGrade.student;

import com.green.smartGrade.professor.model.SelProfessorRes;
import com.green.smartGrade.student.model.*;
import com.green.smartGrade.utils.GradeUtils;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentMapper mapper;


    public StudentInsRes inslecture(StudentParam param) {
        StudentInsDto dto = new StudentInsDto();

        dto.setIstudent(param.getIstudent());
        dto.setIlecture(param.getIlecture());
        dto.setFinishedYn(param.getFinishedYn());

        int result = mapper.insSdy(dto);
        if (result == 1) {
            StudentInsRes res = new StudentInsRes(dto);
            return res;
        }
        return null;
    }


    public StudentSelRes selAllSdy(StudentSelDto dto,int page) {
        int maxpage = mapper.StudentCount();
        PagingUtils utils = new PagingUtils(page,maxpage);
        dto.setStartIdx(utils.getStaIdx());
        dto.setStudentNum(dto.getStudentNum());
        dto.setRow(utils.getROW());

        List<StudentSelVo> list = mapper.selAllSdy(dto);
        for (StudentSelVo  vo  :  list ) {
            GradeUtils gradeUtils = new GradeUtils(vo.getTotalScore());
            double score = gradeUtils.totalScore();
            String rating = gradeUtils.totalRating(score);
            vo.setRating(rating);
        }
        return StudentSelRes.builder()
                .list(list)
                .page(utils)
                .build();

    }

    public StudentSelProfileRes selStudentProfile(StudentSelProfileDto dto,int page) {
        int maxpage = mapper.StudentCount();
        PagingUtils utils = new PagingUtils(page,maxpage);
        dto.setStartIdx(utils.getStaIdx());
        dto.setStudentNum(dto.getStudentNum());
        dto.setRow(utils.getROW());
        List<StudentSelProfileVo> list = mapper.selStudentProfile(dto);

        return StudentSelProfileRes.builder().list(list).page(utils).build();
    }

    public StudentSelPointRes selStudentRemainingPoint(StudentSelPointDto dto, int page) {
        int maxpage = mapper.StudentCount();
        PagingUtils utils = new PagingUtils(page, maxpage);
        dto.setStartIdx(utils.getStaIdx());
        dto.setRow(utils.getROW());
        dto.setStudentNum(dto.getStudentNum());
        List<StudentSelPointVo> list = mapper.selStudentRemainingPoint(dto);

        return StudentSelPointRes.builder().list(list).page(utils).build();
    }


}
