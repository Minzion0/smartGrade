package com.green.smartGrade.admin.professor;

import com.green.smartGrade.admin.professor.model.*;
import com.green.smartGrade.config.exception.AdminException;
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


        CheckUtils utils = CheckUtils
                .builder()
                .nm(dto.getNm())
                .phoneNum(dto.getPhone())
                .gender(dto.getGender())
                .build();
        String msg = utils.getMsg();
        if (msg != null) {
            String format = String.format("%s 의 입력 오류가 있습니다", msg);
            throw new AdminException(format);

        }


        int result = MAPPER.insProfessor(dto);
        log.info("result : {}",result);
        if (result == 0) {
            throw new AdminException("등록오류");
        }
        res.setRes(dto);


        return res;
    }

    public AdminProfessorRes findProfessors(int page, AdminFindProfessorDto dto) {
        int maxPage = MAPPER.countProfessor(dto);
        PagingUtils pagingUtils = new PagingUtils(page, maxPage);
        dto.setStaIdx(pagingUtils.getStaIdx());
        List<AdminFindProfessorRes> professors = MAPPER.findProfessors(dto);

        return AdminProfessorRes.builder().professors(professors)
                .page(pagingUtils).build();

    }

    public AdminProfessorDetailVo findProfessorDetail(AdminProfessorDetailDto dto) {
        List<AdminProfessorMajor> major = MAPPER.professorMajor(dto);
        AdminProfessorDetailProfile profile = MAPPER.professorProfile(dto);

        return AdminProfessorDetailVo.builder()
                .profile(profile)
                .lectureList(major)
                .build();
    }


}
