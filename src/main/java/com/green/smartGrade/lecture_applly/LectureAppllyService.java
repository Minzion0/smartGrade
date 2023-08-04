package com.green.smartGrade.lecture_applly;

import com.green.smartGrade.lecture_applly.model.*;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LectureAppllyService {
    private final LectureAppllyMapper mapper;


    public LectureAppllyRes InsApplly(LectureAppllyInsParam param){
        LectureAppllyInsDto dto = new LectureAppllyInsDto();
        String msg="";
        LectureAppllyRes res= new LectureAppllyRes();

        dto.setIlectureName(param.getIlectureName());
        dto.setIlectureRoom(param.getIlectureRoom());
        dto.setIprofessor(param.getIprofessor());
        dto.setIsemester(param.getIsemester());
        dto.setOpeningProcedures(param.getOpeningProcedures());
        dto.setLectureStrDate(param.getLectureStrDate());
        dto.setLectureEndDate(param.getLectureEndDate());
        dto.setLectureStrTime(param.getLectureStrTime());
        dto.setLectureEndTime(param.getLectureEndTime());
        dto.setDayWeek(param.getDayWeek());



        // 입력 값들을 가져온다
        int attendance = param.getAttendance();
        int midtermExamination = param.getMidtermExamination();
        int finalExamination = param.getFinalExamination();


        // 출석, 중간고사, 기말고사 점수의 합을 계산
        int totalScore = attendance + midtermExamination + finalExamination;

        // 합이 100을 넘는 경우 예외 처리.
        if (totalScore > 100) {
           msg+= "출석, 중간고사, 기말고사 점수의 합은 100을 넘을 수 없습니다.";
           res.setMsg(msg);
           return res;
        } else if (totalScore < 100) {
            msg+="출석, 중간고사, 기말고사 점수의 합은 100미만 일수 없습니다.";
            res.setMsg(msg);
            return res;

        }

        dto.setAttendance(attendance);
        dto.setMidtermExamination(midtermExamination);
        dto.setFinalExamination(finalExamination);


        int garedLimit = param.getGaredLimit();
        if (garedLimit < 1 || garedLimit > 5) {
            // garedLimit 값이 1부터 5 사이에 없는 경우, 기본값으로 1을 설정
            garedLimit = 1;
        }
        dto.setGaredLimit(garedLimit);

        int lectureMaxPeople = param.getLectureMaxPeople();
        // lectureMaxPeople 값이 1부터 30 사이에 없는 경우, 기본값으로 1을 설정
        if (lectureMaxPeople < 1 || lectureMaxPeople >= 30) {
            lectureMaxPeople = 10;
        }
        dto.setLectureMaxPeople(lectureMaxPeople);

        int openingProcedures = param.getOpeningProcedures();
        if (openingProcedures <= 0 || openingProcedures > 5) {
            openingProcedures = 1;
        }
        dto.setOpeningProcedures(openingProcedures);


        try {
            int result = mapper.InsApplly(dto);
            if (result != 1) {
                throw new RuntimeException();
            }
        } catch (IllegalArgumentException ex) {
           ex.fillInStackTrace();
        }

        String dayWeek = dto.getDayWeek();
        String[] split = dayWeek.split(",");

        List<LectureApllyDto> liss = new ArrayList<>();
        for (String s : split) {
            LectureApllyDto apllyDto = new LectureApllyDto();
            apllyDto.setDayWeek(s);
            apllyDto.setIlecture(dto.getIlecture());
            liss.add(apllyDto);
        }

        int re = mapper.InsDayWeek(liss);
        if (re ==0){
            return null;
        }
        res.setDto(dto);

        return res;


    }


    public LectureApllySelRes selLectureApplly(int page,Long ip) {
        int maxPage = mapper.selAplly();
        PagingUtils utils = new PagingUtils(page,maxPage);

        LectureApllyT t = new LectureApllyT();
        t.setRow(utils.getROW());
        t.setStartIdx(utils.getStaIdx());
        t.setIprofessor(ip);

        List<LectureAppllySelOneRes> applly = mapper.selLectureApplly(t);

        return LectureApllySelRes.builder().list(applly).page(utils).build();
    }


}
