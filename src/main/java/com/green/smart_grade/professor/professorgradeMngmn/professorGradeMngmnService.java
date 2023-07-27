package com.green.smart_grade.professor.professorgradeMngmn;

import com.green.smart_grade.professor.professorgradeMngmn.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class professorGradeMngmnService {
    private final professorGradeMngmnMapper mapper;


    public professorGradeMngmnUpRes upMngnm(professorGradeMngmnUpParam param,Long iprofessor,Long ilectureStudent ) {



        professorgradeMngmnUpDto dto = new professorgradeMngmnUpDto();
        dto.setIlectureStudent(ilectureStudent);
        dto.setIpofessor(iprofessor);
        dto.setAttendance(param.getAttendance());
        dto.setFinishedYn(param.getFinishedYn());
        dto.setMidtermExamination(param.getMidtermExamination());
        dto.setFinalExamination(param.getFinalExamination());
        dto.setTotalScore(param.getTotalScore());



        int result = mapper.upMngnm(dto);
        if (result == 1) {
            professorGradeMngmnUpRes res = new professorGradeMngmnUpRes(dto);
            res.setIpofessor(iprofessor);
            res.setIlectureStudent(ilectureStudent);
            return res;
        }
        return null;

    }






}
