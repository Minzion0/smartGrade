package com.green.smart_grade.lecture_applly;

import com.green.smart_grade.admin.lectureroom.model.LectureRoomRes;
import com.green.smart_grade.lecture_applly.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
        if (garedLimit < 1 || garedLimit >= 4) {
            // garedLimit 값이 1부터 4 사이에 없는 경우, 기본값으로 1을 설정
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
        if (openingProcedures <= 0 || openingProcedures > 4) {
            openingProcedures = 1;
        }
        dto.setOpeningProcedures(openingProcedures);




        int result = mapper.InsApplly(dto);
        if (result == 1) {
            new LectureAppllyRes(dto);
        }
        return null;
    }

    List<LectureAppllyListVo> selLectureApplly(LectureAppllyListOneDto dto) {
        dto.setIprofessor(dto.getIprofessor());
        return mapper.selLectureApplly(dto);
    }


}
