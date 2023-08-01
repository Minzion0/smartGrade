package com.green.smartGrade.admin.student;

import com.green.smartGrade.admin.student.model.*;
import com.green.smartGrade.utils.CheckUtils;
import com.green.smartGrade.utils.CommonUtils;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminStudentService {
    private final AdminStudentMapper MAPPER;
    private final CommonUtils commonUtils;

    public AdminIInsStudentRes insStudent(AdminInsStudentParam param) {
        String year = String.valueOf(LocalDate.now().getYear()).substring(2);
        String format = String.format("%s%02d", year, param.getImajor());
        AdminInsStudentDto dto = new AdminInsStudentDto(param);
        AdminIInsStudentRes res = new AdminIInsStudentRes();
        //이메일 유효성검사도 해야할듯?
        dto.setStudentNum(format);

        String rePw = dto.getBirthdate().toString().replaceAll("-", "");
        String nPw = commonUtils.encodeSha256(rePw);
        dto.setStudentPassword(nPw);

        CheckUtils utils = CheckUtils.builder().email(dto.getEmail()).phoneNum(dto.getPhone()).gender(dto.getGender()).build();
        String msg = utils.getMsg();
        if (msg != null) {
            String substring = msg.substring(4);
            String msgs = String.format("%s 오류가 있습니다", substring);
            res.setMsg(msgs);
            return res;

        }


        int result = MAPPER.insStudent(dto);
        if (result == 0) {
            res.setMsg("이미 등록한 이메일 입니다");
            return res;
        }

        res = MAPPER.selStudent(dto.getEmail());

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
            AdminStudentDetalRes res = MAPPER.studentDt(istudent);
            List<AdminStudentLectureDataRes> dataRes = MAPPER.studentLectures(istudent);
            res.setLectureList(dataRes);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}

