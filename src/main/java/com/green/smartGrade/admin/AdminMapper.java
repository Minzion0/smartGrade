package com.green.smartGrade.admin;

import com.green.smartGrade.admin.model.*;
import com.green.smartGrade.admin.student.model.AdminGraduationStudentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<AdminSelLectureRes>selLecture(AdminSelLectureDto dto);
    int countLceture(AdminSelLectureDto dto);
    int insLectureName(AdminInsLectureNameDto dto);
    List<AdminFindLectureNameVo> findLectureName( String lectureName );

    int lectureModify(AdminUpdLectureDto dto);
    int updLecture(AdminUpdLectureDto dto);
    List<AdminLectureInStudentRes> lectureInStudent(AdminLectureInStudentDto dto);
    int findLectureCondition(Long ilecture);
    AdminLectureConditionVo lectureCondition(Long ilecture);

    int semesterIns(AdminInsSemesterDto dto);
    List<AdminGetSemesterVo> getSemester(String year);
    List<AdminGraduationStudentVo> graduationStudent();
    int updGraduationStudent(List<AdminGraduationStudentVo> vo);
}
