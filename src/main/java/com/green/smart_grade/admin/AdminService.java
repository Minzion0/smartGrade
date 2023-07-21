package com.green.smart_grade.admin;

import com.green.smart_grade.admin.model.AdminIInsStudentRes;
import com.green.smart_grade.admin.model.AdminInsStudentDto;
import com.green.smart_grade.admin.model.AdminInsStudentParam;
import com.green.smart_grade.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.green.smart_grade.utils.CommonUtils.encodeSha256;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {

    @Autowired
    private final AdminMapper MAPPER;
    private final CommonUtils commonUtils;


    public AdminIInsStudentRes insStudent(AdminInsStudentParam param){
        String year = String.valueOf(LocalDate.now().getYear()).substring(2);
        String format = String.format("%s%02d", year, param.getImajor());
        AdminInsStudentDto dto = new AdminInsStudentDto(param);
        dto.setStudentNum(format);
        String rePw = dto.getBirthdate().toString().replaceAll("-", "");
        String nPw = commonUtils.encodeSha256(rePw);
        dto.setStudentPassword(nPw);

        int result = MAPPER.insStudent(dto);

        if (result==1){

            return MAPPER.selStudent(dto.getEmail());
        }
        return null;

    }

}
