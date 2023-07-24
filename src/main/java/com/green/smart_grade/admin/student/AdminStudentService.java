package com.green.smart_grade.admin.student;

import com.green.smart_grade.admin.student.model.*;
import com.green.smart_grade.utils.CommonUtils;
import com.green.smart_grade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<AdminFindStudentRes> findStudents(AdminFindStudentDto dto,int page){
        MAPPER.findStudents()
        return MAPPER.findStudents(dto);
    }
}
