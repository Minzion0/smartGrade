package com.green.smartGrade.student;

import com.green.smartGrade.professor.model.ProfessorUpDto;
import com.green.smartGrade.student.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    int insSdy(StudentInsDto dto);

    List<StudentSelVo> selAllSdy(StudentSelDto dto);

    int StudentCount();

    //List<StudentSelProfile> selStudentProfile(StudentSelProfileDto dto);

    List<StudentSelPointVo> selStudentRemainingPoint(StudentSelPointDto dto);

    int upStudent(StudentUpdto dto);


    List<Integer> selDayWeek(Long ilecture);

    int updPassword (StudentUpdPasswordDto dto);

    StudentSelCurrentPasswordVo selPasswordCurrent (StudentSelCurrentPasswordDto dto);

    String picFilePathByStudent(Long istudent);

    void updateFilePathNullByStudent(Long istudent);

    StudentSelProfile selStudentProfile(StudentSelProfileDto dto);
    List<StudentMajor> selStudentMajor(StudentSelProfileDto dto);

    StudentUpdto getStudentById(Long istudent);
}
