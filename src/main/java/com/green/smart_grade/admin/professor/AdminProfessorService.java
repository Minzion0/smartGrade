package com.green.smart_grade.admin.professor;

import com.green.smart_grade.admin.professor.model.*;
import com.green.smart_grade.utils.CommonUtils;
import com.green.smart_grade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminProfessorService {

    private final AdminProfessorMapper MAPPER;
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

    public AdminProfessorRes findProfessors(int page, String name){
        int maxPage = MAPPER.countProfessor();
        PagingUtils pagingUtils = new PagingUtils(page,maxPage);

        List<AdminFindProfessorRes> professors = MAPPER.findProfessors(pagingUtils.getStaIdx(),name);

        return AdminProfessorRes.builder().professors(professors)
                .page(pagingUtils).build();

    }
}
