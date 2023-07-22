package com.green.smart_grade.admin;

import com.green.smart_grade.admin.model.*;
import com.green.smart_grade.utils.CommonUtils;
import com.green.smart_grade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


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

    public List<AdminFindStudentRes> findStudents(AdminFindStudentDto dto){
       return MAPPER.findStudents(dto);
    }

    public AdminInsProfessorRes insProfessor(AdminInsProfessorParam param){
        AdminInsProfessorDto dto = new AdminInsProfessorDto(param);

        String rBd = param.getBirthdate().toString().replaceAll("-", "");
        String nPw = commonUtils.encodeSha256(rBd);
        dto.setProfessorPassword(nPw);

        //이메일 유효성검사도 해야할듯?


        int result = MAPPER.insProfessor(dto);
        if (result==1){
           return new AdminInsProfessorRes(dto);
        }
        return null;
    }

    public AdminProfessorRes findProFessors(int page){
        int result = MAPPER.countProfessor();
        int startIdx = PagingUtils.startIdx(page);
        int maxPage = PagingUtils.maxPage(result);
        int isMore = PagingUtils.isMore(maxPage, page);

        List<AdminFindProfessorRes> professors = MAPPER.findProfessors(startIdx);

        return AdminProfessorRes.builder().professors(professors)
                        .page(page).maxPage(maxPage).isMore(isMore).build();



    }

}
