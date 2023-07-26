package com.green.smart_grade.admin.student;

import com.green.smart_grade.admin.student.model.*;
import com.green.smart_grade.utils.CommonUtils;
import com.green.smart_grade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminStudentService {
    private final AdminStudentMapper MAPPER;
    private final CommonUtils commonUtils;

    public AdminIInsStudentRes insStudent(AdminInsStudentParam param){
        String year = String.valueOf(LocalDate.now().getYear()).substring(2);
        String format = String.format("%s%02d", year, param.getImajor());
        AdminInsStudentDto dto = new AdminInsStudentDto(param);
        //이메일 유효성검사도 해야할듯?
        dto.setStudentNum(format);

        String rePw = dto.getBirthdate().toString().replaceAll("-", "");
        String nPw = commonUtils.encodeSha256(rePw);
        dto.setStudentPassword(nPw);

        try {
            int result = MAPPER.insStudent(dto);
            if (result==1){
                return MAPPER.selStudent(dto.getEmail());
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return null;

    }
    public AdminStudentRes findStudents(AdminFindStudentDto dto,int page){
        int maxCount = MAPPER.countStudents(dto);
        PagingUtils utils = new PagingUtils(page, maxCount);
        dto.setRow(utils.getROW());
        dto.setStaIdx(utils.getStaIdx());
        List<AdminFindStudentRes> students = MAPPER.findStudents(dto);
        return AdminStudentRes.builder().studnets(students).page(utils).build();

    }
    public AdminStudentLectureRes studentDet(Long istudent){
        AdminStudentDetalRes res = MAPPER.studentDt(istudent);
        AdminStudentLectureRes lectureRes = new AdminStudentLectureRes(res);

        String[] ilecture = res.getIlecture().split(",");
        String[] lectureNm = res.getLectureName().split(",");
        String[] attendance = res.getAttendance().split(",");
        String[] mixEx = res.getMidtermEx().split(",");
        String[] finEx = res.getFinalEx().split(",");
        String[] totalScore = res.getTotalScore().split(",");
        List<AdminStudentLectureDataRes>list= new ArrayList<>();
        for (int i = 0; i < ilecture.length; i++) {
            AdminStudentLectureDataRes dataRes = new AdminStudentLectureDataRes();
            dataRes.setIlecture(Long.valueOf(ilecture[i]));
            dataRes.setLectureNm(lectureNm[i]);
            dataRes.setAttendance(Integer.parseInt(attendance[i]));
            dataRes.setMixEx(Integer.parseInt(mixEx[i]));
            dataRes.setFinEx(Integer.parseInt(finEx[i]));
            dataRes.setTotalScore(Integer.parseInt(totalScore[i]));
            list.add(dataRes);
        }
        lectureRes.setList(list);
        return lectureRes;
    }
}
