package com.green.smartGrade.admin.professor;

import com.green.smartGrade.admin.professor.model.*;
import com.green.smartGrade.utils.CheckUtils;
import com.green.smartGrade.utils.CommonUtils;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminProfessorService {

    private final AdminProfessorMapper MAPPER;
    private final PasswordEncoder PW_ENCODER;

    public AdminInsProfessorRes insProfessor(AdminInsProfessorParam param) {
        AdminInsProfessorDto dto = new AdminInsProfessorDto(param);
        AdminInsProfessorRes res = new AdminInsProfessorRes();

        String rBd = param.getBirthdate().toString().replaceAll("-", "");
        String nPw = PW_ENCODER.encode(rBd);
        dto.setProfessorPassword(nPw);
        log.info("{}", dto.getPhone());

        //이메일 유효성검사도 해야할듯?
        CheckUtils utils = CheckUtils.builder().phoneNum(dto.getPhone()).gender(dto.getGender()).email(dto.getEmail()).build();
        String msg = utils.getMsg();
        if (msg != null) {

            String format = String.format("%s 오류가 있습니다", msg);
            res.setMsg(format);
            return res;
        }


        int result = MAPPER.insProfessor(dto);
        log.info("result : {}",result);
        if (result == 0) {
            res.setMsg("이미 등록한 이메일 입니다");
            return res;
        }
        res.setRes(dto);


        return res;
    }

    public AdminProfessorRes findProfessors(int page, String name) {
        int maxPage = MAPPER.countProfessor();
        PagingUtils pagingUtils = new PagingUtils(page, maxPage);

        List<AdminFindProfessorRes> professors = MAPPER.findProfessors(pagingUtils.getStaIdx(), name);

        return AdminProfessorRes.builder().professors(professors)
                .page(pagingUtils).build();

    }

    public AdminProfessorDetailVo findProfessorDetail(AdminProfessorDetailDto dto) {
        List<AdminProfessorMajor> major = MAPPER.professorMajor(dto);
        AdminProfessorDetailProfile profile = MAPPER.professorProfile(dto);

        return AdminProfessorDetailVo.builder()
                .profile(profile)
                .majorList(major)
                .build();
    }

}
