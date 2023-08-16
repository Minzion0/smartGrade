//package com.green.smartGrade.admin;
//
//
//import com.green.smartGrade.admin.model.*;
//import com.green.smartGrade.admin.student.model.AdminGraduationStudentVo;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//
//import org.springframework.test.context.ActiveProfiles;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.*;
//
//@MybatisTest
//@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//
//class AdminMapperTest {
//    @Autowired
//    private AdminMapper mapper;
//
//    @Test
//    void selLecture(){
//        AdminSelLectureDto dto = new AdminSelLectureDto();
//        dto.setRow(10);
//        dto.setStrIdx(0);
//        dto.setProcedures(0);
//        List<AdminSelLectureRes> adminSelLectureRes = mapper.selLecture(dto);
//        int size = adminSelLectureRes.size();
//        Assertions.assertEquals(6,size);
//        AdminSelLectureRes res = adminSelLectureRes.get(0);
//        Long ilecture = res.getIlecture();
//        assertEquals(4,ilecture);
//
//        AdminSelLectureDto dto2 = new AdminSelLectureDto();
//        dto2.setRow(10);
//        dto2.setStrIdx(0);
//        dto2.setProcedures(-2);
//        List<AdminSelLectureRes> adminSelLectureRes2 = mapper.selLecture(dto2);
//        int size2 = adminSelLectureRes2.size();
//        Assertions.assertEquals(10,size2);
//        AdminSelLectureRes res2 = adminSelLectureRes2.get(0);
//        Long ilecture2 = res2.getIlecture();
//        assertEquals(4,ilecture2);
//    }
//
//    @Test
//    void countLceture(){
//        AdminSelLectureDto dto = new AdminSelLectureDto();
//        dto.setRow(10);
//        dto.setStrIdx(0);
//        dto.setProcedures(0);
//        int i = mapper.countLceture(dto);
//        assertEquals(i,6);
//
//        AdminSelLectureDto dto2 = new AdminSelLectureDto();
//        dto2.setRow(10);
//        dto2.setStrIdx(0);
//        dto2.setProcedures(-2);
//        int i1 = mapper.countLceture(dto2);
//        assertEquals(i1,42);
//    }
//
//    @Test
//    void lectureInStudent(){
//        AdminLectureInStudentDto dto = new AdminLectureInStudentDto();
//        dto.setIlecture(4L);
//
//
//        List<AdminLectureInStudentRes> res = mapper.lectureInStudent(dto);
//        int size = res.size();
//        assertEquals(size,8);
//
//        AdminLectureInStudentDto dto2 = new AdminLectureInStudentDto();
//        dto2.setIlecture(5L);
//
//        List<AdminLectureInStudentRes> res1 = mapper.lectureInStudent(dto2);
//        int size1 = res1.size();
//        assertEquals(size1,5);
//
//        AdminLectureInStudentRes lecture = res1.get(0);
//        Long istudent = lecture.getIstudent();
//        String nm = lecture.getNm();
//        int score = lecture.getTotalScore();
//        assertEquals(istudent,6);
//        assertEquals(nm,"지코바");
//        assertEquals(score,30);
//
//
//    }
//
//    @Test
//    void lectureModify(){
//        AdminSelLectureDto dto1 = new AdminSelLectureDto();
//        dto1.setNm("재경");
//        dto1.setProcedures(-1);
//        dto1.setStrIdx(0);
//        dto1.setRow(10);
//        List<AdminSelLectureRes> res = mapper.selLecture(dto1);
//        AdminSelLectureRes res1 = res.get(0);
//        assertEquals(res1.getIlecture(),4);
//        assertEquals(res1.getProcedures(),0);
//
//        AdminUpdLectureDto dto = new AdminUpdLectureDto();
//        dto.setIlecture(4L);
//        dto.setProcedures(2);
//        int i = mapper.updLecture(dto);
//        List<AdminSelLectureRes> res2 = mapper.selLecture(dto1);
//        AdminSelLectureRes res3 = res2.get(0);
//
//        Assertions.assertEquals(res3.getIlecture(),res1.getIlecture());
//        assertNotEquals(res3.getProcedures(),res1.getProcedures());
//        assertEquals(res3.getNm(),res1.getNm());
//        assertEquals(res3.getSemester(), res1.getSemester());
//        assertEquals(res3.getLectureNm(),res1.getLectureNm());
//        assertEquals(res3.getEndTime(),res1.getEndTime());
//
//
//
//    }
//
//    @Test
//    void findLectureCondition(){
//        AdminSelLectureDto dto = new AdminSelLectureDto();
//        dto.setRow(10);
//        dto.setStrIdx(0);
//        dto.setProcedures(-1);
//        List<AdminSelLectureRes> res = mapper.selLecture(dto);
//        for (AdminSelLectureRes num : res) {
//
//            int condition = mapper.findLectureCondition(num.getIlecture());
//            assertEquals(condition,num.getProcedures());
//        }
//        AdminSelLectureDto dto1 = new AdminSelLectureDto();
//        dto1.setRow(10);
//        dto1.setStrIdx(0);
//        dto1.setProcedures(1);
//
//        List<AdminSelLectureRes> res1 = mapper.selLecture(dto1);
//
//        for (AdminSelLectureRes test : res1) {
//            int condition = mapper.findLectureCondition(test.getIlecture());
//            assertEquals(condition,test.getProcedures());
//        }
//    }
//
//
//    @Test
//    void lectureCondition(){
//        AdminLectureConditionVo vo = mapper.lectureCondition(4L);
//
//        assertEquals(vo.getIlecture(),4L);
//        assertEquals(vo.getReturnCtnt(),"진짜수업 개별로");
//        assertEquals(vo.getReturnDate(),"2023-07-24");
//
//
//        AdminLectureConditionVo vo1 = mapper.lectureCondition(18L);
//
//        assertEquals(vo1.getIlecture(),18L);
//        assertEquals(vo1.getReturnCtnt(),"교수 개인 사정");
//        assertEquals(vo1.getReturnDate(),"2023-08-04");
//
//    }
//
//    @Test
//    void semesterIns(){
//        AdminInsSemesterParam param = new AdminInsSemesterParam();
//        param.setSemester(1);
//        param.setYear("2025");
//
//        param.setSemesterStrDate(LocalDate.now());
//        param.setSemesterEndDate(LocalDate.of(2024,04,20));
//        AdminInsSemesterDto dto = new AdminInsSemesterDto(param);
//         mapper.semesterIns(dto);
//         assertEquals(dto.getIsemester(),34);
//
//    }
//
//    @Test
//    void getSemester(){
//        List<AdminGetSemesterVo> semester = mapper.getSemester(null);
//        AdminGetSemesterVo vo = semester.get(0);
//        assertEquals(vo.getSemester(),1);
//        assertEquals(vo.getYear(),"2023");
//        assertEquals(vo.getSemesterStrDate().toString(),"2023-03-02");
//        assertEquals(vo.getSemesterEndDate().toString(),"2023-06-30");
//    }
//
//    @Test
//    void graduationStudent(){
//        List<AdminGraduationStudentVo> vos = mapper.graduationStudent();
//        int size = vos.size();
//        assertEquals(size,0);
//    }
//
//
//    @Test
//    void updGraduationStudent(){
//        List<AdminGraduationStudentVo> vo =new ArrayList<>();
//        AdminGraduationStudentVo studentVo = new AdminGraduationStudentVo();
//        studentVo.setIstudent(4L);
//        AdminGraduationStudentVo studentVo2 = new AdminGraduationStudentVo();
//        studentVo2.setIstudent(6L);
//        AdminGraduationStudentVo studentVo3 = new AdminGraduationStudentVo();
//        studentVo3.setIstudent(7L);
//        vo.add(studentVo);
//        vo.add(studentVo2);
//        vo.add(studentVo3);
//
//        int i = mapper.updGraduationStudent(vo);
//        assertEquals(i,1);
//    }
//}