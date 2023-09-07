package com.green.smartGrade.admin.student;

import com.green.smartGrade.admin.student.model.*;
import com.green.smartGrade.config.exception.AdminException;
import com.green.smartGrade.utils.CheckUtils;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminStudentService {
    private final AdminStudentMapper MAPPER;
    private final PasswordEncoder PW_ENCODER;

    public AdminIInsStudentRes insStudent(AdminInsStudentParam param) throws AdminException {
        String year = String.valueOf(LocalDate.now().getYear()).substring(2);
        String format = String.format("%s%02d", year, param.getImajor());
        AdminInsStudentDto dto = new AdminInsStudentDto(param);

        dto.setStudentNum(format);

        String rePw = dto.getBirthdate().toString().replaceAll("-", "");
        String encode = PW_ENCODER.encode(rePw);
        dto.setStudentPassword(encode);

        CheckUtils utils = CheckUtils.builder().nm(dto.getNm()).phoneNum(dto.getPhone()).gender(dto.getGender()).build();
        String msg = utils.getMsg();
        if (msg != null) {
            String msgs = String.format("%s 오류가 있습니다", msg);

            throw new AdminException(msgs);

        }


        int result = MAPPER.insStudent(dto);
        if (result == 0) {
            throw new AdminException("등록 오류");

        }

        AdminIInsStudentRes   res = MAPPER.selStudent(dto.getStudentPassword());

        return res;

    }

    public AdminStudentRes findStudents(AdminFindStudentDto dto, int page) {
        int maxCount = MAPPER.countStudents(dto);
        PagingUtils utils = new PagingUtils(page, maxCount);
        dto.setRow(utils.getROW());
        dto.setStaIdx(utils.getStaIdx());
        List<AdminFindStudentRes> students = MAPPER.findStudents(dto);
        return AdminStudentRes.builder().students(students).page(utils).build();

    }

    public AdminStudentDetalRes studentDet(Long istudent) {
        try {
            AdminStudentDetalRes res = new AdminStudentDetalRes();
            AdminStudentDetalVo vo = MAPPER.studentDt(istudent);
            List<AdminStudentLectureDataRes> dataRes = MAPPER.studentLectures(istudent);
            res.setLectureList(dataRes);//private List<AdminStudentLectureDataRes>lectureList;
            res.setProfile(vo);
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    // todo 매년 연말에 4학년을 제외한 모든 학생들을 진학
    @Scheduled(cron = "0 59 23 31 12 ?")
    public void grade() {
        int result = MAPPER.promotionGrade();
        log.info("{}년도 진학한 학생의수 : {}", LocalDateTime.now().plusYears(1).getYear(), result);

    }
//      smartGradeExceptionHandler 로 일괄 처리
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> handlerAdminStudent(Exception e) {
//        StackTraceElement element = Thread.currentThread().getStackTrace()[1];
//        String className = element.getClassName().substring(element.getClassName().lastIndexOf(".") + 1);
//        String path = String.format("class :%s  ", className);
//        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(path);
//
//    }

}

