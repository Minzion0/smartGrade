package com.green.smartGrade.student;

import com.green.smartGrade.student.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    int insSdy(StudentInsDto dto);

    List<StudentSelVo> selAllSdy(StudentSelDto dto);

    int StudentCount();

    List<StudentSelProfileVo> selStudentProfile(StudentSelProfileDto dto);

    List<StudentSelPointVo> selStudentRemainingPoint(StudentSelPointDto dto);

    int upStudent(StudentUpdto dto);


    List<Integer> selDayWeek(Long ilecture);

    int updPassword (StudentUpdPasswordDto dto);

    StudentSelCurrentPasswordVo selCurrentStudentPassword (Long istudent, String role);
}
