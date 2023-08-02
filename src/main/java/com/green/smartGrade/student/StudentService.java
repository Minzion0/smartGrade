package com.green.smartGrade.student;

import com.green.smartGrade.student.model.StudentInsDto;
import com.green.smartGrade.student.model.StudentInsRes;
import com.green.smartGrade.student.model.StudentParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentMapper mapper;


    public StudentInsRes inslecture(StudentParam param) {
        StudentInsDto dto = new StudentInsDto();
        dto.setIsudent(param.getIsudent());
        dto.setIlecture(param.getIlecture());
        dto.setFinishedYn(param.getFinishedYn());

        int result = mapper.inslecture(dto);
        if (result == 1) {
            StudentInsRes res = new StudentInsRes(dto);
            return res;
        }
        return null;
    }
}
