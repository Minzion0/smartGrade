package com.green.smart_grade.admin;

import com.green.smart_grade.admin.model.*;
import com.green.smart_grade.admin.professor.model.AdminFindProfessorRes;
import com.green.smart_grade.admin.professor.model.AdminInsProfessorDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<AdminSelLectureRes>selLecture(AdminSelLectureDto dto);
    int countLceture(AdminSelLectureDto dto);

    int lectureModify(AdminUpdLectureDto dto);
    int updLecture(AdminUpdLectureDto dto);
    List<AdminLectureInStudentRes> lectureInStudent(AdminLectureInStudentDto dto);
    int lectureCountStudent (Long ilecture);
}
