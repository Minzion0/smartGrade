package com.green.smart_grade.admin;

import com.green.smart_grade.admin.model.*;
import com.green.smart_grade.admin.student.model.*;
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

    public AdminProfessorRes findProfessors(int page,String name){
        int maxPage = MAPPER.countProfessor();
        PagingUtils pagingUtils = new PagingUtils(page,maxPage);

        List<AdminFindProfessorRes> professors = MAPPER.findProfessors(pagingUtils.getStaIdx(),name);

        return AdminProfessorRes.builder().professors(professors)
                .page(pagingUtils).build();



    }

}
