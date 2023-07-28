package com.green.smart_grade.admin;

import com.green.smart_grade.admin.model.AdminLectureInStudentRes;
import com.green.smart_grade.admin.model.AdminSelLectureDto;
import com.green.smart_grade.admin.model.AdminSelLectureRes;
import com.green.smart_grade.admin.model.AdminUpdLectureDto;
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
    List<AdminLectureInStudentRes> lectureInStudent(Long ilecture);
}
