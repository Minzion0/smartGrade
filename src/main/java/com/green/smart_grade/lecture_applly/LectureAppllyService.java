package com.green.smart_grade.lecture_applly;

import com.green.smart_grade.admin.lectureroom.model.LectureRoomRes;
import com.green.smart_grade.lecture_applly.model.*;
import com.green.smart_grade.utils.PagingUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class LectureAppllyService {
    private final LectureAppllyMapper mapper;


    public LectureAppllyRes InsApplly(LectureAppllyInsParam param) {
        LectureAppllyInsDto dto = new LectureAppllyInsDto();
        dto.setIlectureName(param.getIlectureName());
        dto.setIlectureRoom(param.getIlectureRoom());
        dto.setIprofessor(param.getIprofessor());
        dto.setIsemester(param.getIsemester());
        dto.setOpeningProcedures(param.getOpeningProcedures());
        dto.setLectureStrDate(param.getLectureStrDate());
        dto.setLectureEndDate(param.getLectureEndDate());
        dto.setLectureStrTime(param.getLectureStrTime());
        dto.setLectureEndTime(param.getLectureEndTime());
        dto.setAttendance(param.getAttendance());
        dto.setMidtermExamination(param.getMidtermExamination());
        dto.setFinalExamination(param.getFinalExamination());
        dto.setLectureMaxPeople(param.getLectureMaxPeople());
        dto.setGaredLimit(param.getGaredLimit());
        dto.setDelYn(param.getDelYn());

        int garedLimit = param.getGaredLimit();
        if (garedLimit < 1 || garedLimit > 5) {
            // garedLimit 값이 1부터 5 사이에 없는 경우, 기본값으로 1을 설정
            garedLimit = 1;
        }
        dto.setGaredLimit(garedLimit);

        int lectureMaxPeople = param.getLectureMaxPeople();
        // lectureMaxPeople 값이 1부터 30 사이에 없는 경우, 기본값으로 1을 설정
        if (lectureMaxPeople < 1 || lectureMaxPeople >= 30) {
            lectureMaxPeople = 1;
        }
        dto.setLectureMaxPeople(lectureMaxPeople);

        int openingProcedures = param.getOpeningProcedures();
        if (openingProcedures <= 0 || openingProcedures > 5) {
            openingProcedures = 1;
        }
        dto.setOpeningProcedures(openingProcedures);

        int aTT = param.getAttendance();
        int midEX  = param.getMidtermExamination();
        int fnEx = param.getFinalExamination();
        int total = aTT + midEX + fnEx;

        if (total != 100) {
            double scale = 100.0 / total;
            aTT = (int) (aTT * scale);
            midEX = (int) (midEX * scale);
            fnEx = (int) (fnEx * scale);

            // 총 합이 100이 되지 않는 경우 부족한 값을 마지막 점수에 더함.
            int diff = 100 - (aTT + midEX + fnEx);
            fnEx += diff;
        }

        dto.setAttendance(aTT);
        dto.setMidtermExamination(midEX);
        dto.setFinalExamination(fnEx);




        int result = mapper.InsApplly(dto);
        if (result == 1) {
            new LectureAppllyRes(dto);
        }
        return null;
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
