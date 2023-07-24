package com.green.smart_grade.admin.major;

import com.green.smart_grade.admin.major.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MajorService {

    @Autowired
    private final MajorMapper MAPPER;

    public MajorRes insMajor(MajorInsParam p) {
        MajorInsDto dto = new MajorInsDto();
        dto.setMajorName(p.getMajorName());
        dto.setGraduationScore(p.getGraduationScore());
        int result = MAPPER.insMajor(dto);
        if (result == 1) {
            new MajorRes(dto);
        }
        return null;
    }

    public List<MajorVo> selMajor() {
        return MAPPER.selMajor();
    }

    public MajorVo selMajorDetail(MajorDetailDto dto) {
        return MAPPER.selMajorDetail(dto);
    }

    public int delMajor(MajorDelDto dto) {
        return MAPPER.delMajor(dto);
    }
}
