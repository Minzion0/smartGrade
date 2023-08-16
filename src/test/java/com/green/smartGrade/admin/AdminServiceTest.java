//package com.green.smartGrade.admin;
//
//import com.green.smartGrade.admin.model.*;
//import com.green.smartGrade.utils.GradeUtils;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//@Import({AdminService.class})
//class AdminServiceTest {
//    @MockBean
//    private AdminMapper mapper;
//
//    @Autowired
//    private  AdminService service;
//
//    @Test
//    void selLecture() {
//        List<AdminSelLectureRes> res = new ArrayList<>();
//        AdminSelLectureRes t1= new AdminSelLectureRes();
//        t1.setIlecture(1L);
//        t1.setLectureNm("호호호");
//        t1.setNm("김재경");
//        t1.setLectureNm("요리조리학");
//        t1.setProcedures(0);
//        t1.setBuildingNm("백매관");
//        t1.setLectureRoomNm("503호");
//        t1.setMajorName("금속공학");
//        t1.setStrDate(LocalDate.of(2023,01,01));
//        t1.setEndDate(LocalDate.now());
//        t1.setStrTime("14:00:00");
//        t1.setEndTime("15:00:00");
//        t1.setGradeLimit(3);
//        t1.setDelYn(0);
//        t1.setMaxPeople(20);
//        t1.setCurrentPeople(15);
//        t1.setSemester(2);
//        t1.setScore(2);
//
//        AdminSelLectureRes t2= new AdminSelLectureRes();
//        t2.setIlecture(2L);
//        t2.setLectureNm("이것이?");
//        t2.setNm("혁박사");
//        t2.setLectureNm("조~았어~");
//        t2.setProcedures(0);
//        t2.setBuildingNm("백매관");
//        t2.setLectureRoomNm("505호");
//        t2.setMajorName("인스타");
//        t2.setStrDate(LocalDate.of(2023,01,01));
//        t2.setEndDate(LocalDate.now());
//        t2.setStrTime("12:00:00");
//        t2.setEndTime("13:00:00");
//        t2.setGradeLimit(1);
//        t2.setDelYn(0);
//        t2.setMaxPeople(10);
//        t2.setCurrentPeople(1);
//        t2.setSemester(2);
//        t2.setScore(3);
//        res.add(t2);
//
//        when(mapper.selLecture(any())).thenReturn(res);
//        AdminSelLectureParam param = new AdminSelLectureParam();
//        param.setPage(1);
//        param.setProcedures(-1);
//
//
//        AdminSelRes adminSelRes = service.selLecture(param);
//
//        List<AdminSelLectureRes> lectures = adminSelRes.getLectures();
//
//
//        for (int i = 0; i < lectures.size(); i++) {
//            AdminSelLectureRes res1 = lectures.get(i);
//            AdminSelLectureRes res2 = res.get(i);
//
//            assertEquals(res1.getNm(),res2.getNm());
//            assertEquals(res1.getIlecture(),res2.getIlecture());
//            assertEquals(res1.getEndTime(),res2.getEndTime());
//            assertEquals(res1.getProcedures(),res2.getProcedures());
//            assertEquals(res1.getSemester(),res2.getSemester());
//            assertEquals(res1.getBuildingNm(),res2.getBuildingNm());
//            assertEquals(res1.getStrDate(),res2.getStrDate());
//
//        }
//
//
//        verify(mapper).selLecture(any());
//
//    }
//
//    @Test
//    void lectureModify() {
//
//        when(mapper.updLecture(any())).thenReturn(1);
//
//
//        AdminUpdLectureDto dto = new AdminUpdLectureDto();
//        dto.setIlecture(1L);
//        dto.setProcedures(1);
//
//        AdminUpdLectureDto dto2 = new AdminUpdLectureDto();
//        dto2.setIlecture(12L);
//        dto2.setProcedures(0);
//        service.lectureModify(dto2);
//
//        AdminUpdLectureRes res = service.lectureModify(dto);
//
//        assertEquals(dto.getProcedures(),res.getProcedures());
//
//        verify(mapper).updLecture(dto);
//        verify(mapper).lectureModify(dto2);
//
//    }
//
//    @Test
//    void findLectureStudent() {
//
//
//        when(mapper.findLectureCondition(any())).thenReturn(1);
//
//        AdminLectureInStudentRes res = new AdminLectureInStudentRes();
//        List<AdminLectureInStudentRes> list = new ArrayList<>();
//
//        res.setIstudent(1L);
//        res.setNm("재경킴");
//        res.setMajorNm("요리조리학");
//        res.setAttendance(15);
//        res.setMinEx(20);
//        res.setFinEx(30);
//        res.setTotalScore(65);
//        GradeUtils gradeUtils = new GradeUtils(res.getTotalScore());
//        double v = gradeUtils.totalScore();
//        res.setGread(gradeUtils.totalRating(v));
//        res.setAvg(v);
//
//        AdminLectureInStudentRes res2 = new AdminLectureInStudentRes();
//        res2.setIstudent(2L);
//        res2.setNm("혁박사");
//        res2.setMajorNm("인서타");
//        res2.setAttendance(10);
//        res2.setMinEx(10);
//        res2.setFinEx(30);
//        res2.setTotalScore(65);
//        GradeUtils gradeUtils2 = new GradeUtils(res2.getTotalScore());
//        double v1 = gradeUtils2.totalScore();
//        res2.setGread(gradeUtils2.totalRating(v1));
//        res2.setAvg(v1);
//
//        list.add(res2);
//        list.add(res);
//        AdminLectureStudentResm resm = new AdminLectureStudentResm();
//        resm.setList(list);
//        ResponseEntity<AdminLectureStudentResm> body = ResponseEntity.ok().body(resm);
//        when(mapper.lectureInStudent(any())).thenReturn(list);
//
//        ResponseEntity<?> entity = service.findLectureStudent(4L);
//
//        //ResponseEntity<?> 라서 tdd과정에서는 반환 확인이 어렵다
//
//
//
//    }
//
//    @Test
//    void semesterIns() {
//        AdminInsSemesterParam param = new AdminInsSemesterParam();
//        param.setSemester(1);
//        param.setYear("2023");
//        param.setSemesterStrDate(LocalDate.now());
//        param.setSemesterEndDate(LocalDate.of(2023,10,20));
//        AdminInsSemesterDto dto = new AdminInsSemesterDto(param);
//       when(mapper.semesterIns(dto)).thenReturn(1);
//
//        AdminInsSemesterRes res = service.semesterIns(param);
//
//        assertEquals(res.getIsemester(),dto.getIsemester());
//        assertEquals(res.getSemester(),dto.getSemester());
//        assertEquals(res.getSemesterStrDate(),dto.getSemesterStrDate());
//        assertEquals(res.getSemesterEndDate(),dto.getSemesterEndDate());
//        verify(mapper).semesterIns(dto);
//
//
//        AdminInsSemesterParam param2 = new AdminInsSemesterParam();
//        param2.setSemester(1);
//        param2.setYear("2023");
//        param2.setSemesterStrDate(LocalDate.now());
//        param2.setSemesterEndDate(LocalDate.of(2023,10,20));
//        AdminInsSemesterDto dto2 = new AdminInsSemesterDto(param);
//        when(mapper.semesterIns(dto2)).thenReturn(0);
//
//        AdminInsSemesterRes res1 = service.semesterIns(param2);
//
//        assertNotEquals(res1,res);
//
//        assertEquals(res1.getMsg(),"학기 중복 입니다");
//
//
//
//    }
//
//    @Test
//    void getSemester() {
//        List<AdminGetSemesterVo> list = new ArrayList<>();
//        AdminGetSemesterVo vo = new AdminGetSemesterVo();
//        vo.setSemester(1);
//        vo.setYear("2023");
//        vo.setSemesterStrDate(LocalDate.of(2023,10,20));
//        vo.setSemesterEndDate(LocalDate.now());
//        vo.setIsemester(1L);
//
//        AdminGetSemesterVo vo2 = new AdminGetSemesterVo();
//        vo2.setSemester(2);
//        vo2.setYear("2023");
//        vo2.setSemesterStrDate(LocalDate.of(2023,10,20));
//        vo2.setSemesterEndDate(LocalDate.now());
//        vo2.setIsemester(2L);
//
//        list.add(vo2);
//        list.add(vo);
//
//        when(mapper.getSemester(any())).thenReturn(list);
//
//        List<AdminGetSemesterVo> semester = service.getSemester("2023");
//
//        for (int i = 0; i < semester.size(); i++) {
//            AdminGetSemesterVo vo1 = semester.get(i);
//            AdminGetSemesterVo vo3 = list.get(i);
//            assertEquals(vo1.getIsemester(),vo3.getIsemester());
//            assertEquals(vo1.getYear(),vo3.getYear());
//            assertEquals(vo1.getSemester(),vo3.getSemester());
//            assertEquals(vo1.getSemesterStrDate(),vo3.getSemesterStrDate());
//            assertEquals(vo1.getSemesterEndDate(),vo3.getSemesterEndDate());
//
//
//        }
//        verify(mapper).getSemester(any());
//
//    }
//
//
//}