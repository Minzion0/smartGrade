package com.green.smart_grade.admin.grade_mngmn;

import com.green.smart_grade.admin.grade_mngmn.model.*;
import com.green.smart_grade.utils.GradeUtils;
import com.green.smart_grade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GradeMngmnService {

    @Autowired
    private final GradeMngmnMapper MAPPER;


    public GradeMngmnFindRes selGradeFindStudent(GradeMngmnInsParam p, int page) {
        int maxPage = MAPPER.countGradeFindStudent();
        GradeMngmnSelDto dto = new GradeMngmnSelDto();
        PagingUtils utils = new PagingUtils(page,maxPage);

        if (p.getStudentNum() != null) {
            dto.setStudentNum(p.getStudentNum().replaceAll(" ", ""));
        }
        if (p.getName() != null) {
            dto.setName(p.getName().replaceAll(" ", ""));
        }
        dto.setStaIdx(utils.getStaIdx());

        List<GradeMngmnVo> gradeMngmn = MAPPER.selGradeFindStudent(dto);
        return GradeMngmnFindRes.builder()
                .gradeMngmn(gradeMngmn)
                .page(utils)
                .build();
    }

    public GradeMngmnDetailVo selGradeFindStudentDetail(GradeMngmnDetailSelDto dto) {
        return MAPPER.selGradeFindStudentDetail(dto);
    }
}
