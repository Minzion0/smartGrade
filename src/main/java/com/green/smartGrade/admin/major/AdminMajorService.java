package com.green.smartGrade.admin.major;

import com.green.smartGrade.admin.lectureroom.model.LectureRoomRes;
import com.green.smartGrade.admin.major.model.*;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminMajorService {

    @Autowired
    private final AdminMajorMapper MAPPER;

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

    public MajorfindRes selMajor(MajorSelDto dto) {
        int maxPage = MAPPER.countMajor();
        PagingUtils utils = new PagingUtils(dto.getPage(),maxPage);


        List<MajorVo> major = MAPPER.selMajor(dto);
        return MajorfindRes.builder()
                .major(major)
                .page(utils)
                .build();
    }

    public int delMajor(MajorDelDto dto) {

        return MAPPER.delMajor(dto);
    }

    public MajorUpdRes updMajor(MajorUpdParam p) {
        MajorUpdDto dto = new MajorUpdDto();
        dto.setMajorName(p.getMajorName());
        dto.setImajor(p.getImajor());
        dto.setRemarks(p.getRemarks());

        int result = MAPPER.updMajor(dto);
        if (result == 1) {
            return new MajorUpdRes(p);
        }
        return null;
    }

}
