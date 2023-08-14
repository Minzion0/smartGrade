package com.green.smartGrade.admin.major;

import com.green.smartGrade.admin.lectureroom.model.LectureRoomRes;
import com.green.smartGrade.admin.major.model.*;
import com.green.smartGrade.utils.PagingUtils;
import lombok.Data;
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
            MajorRes majorRes = new MajorRes(dto);
            return majorRes;
        }
        return null;
    }

    public MajorfindRes selMajor(MajorSelDto dto) {
        int maxPage = MAPPER.countMajor(dto);
        PagingUtils utils = new PagingUtils(dto.getPage(),maxPage);
        dto.setStaIdx(utils.getStaIdx());

        List<MajorVo> major = MAPPER.selMajor(dto);
        return MajorfindRes.builder()
                .major(major)
                .page(utils)
                .build();
    }

    public int delMajor(MajorDelDto dto) {

        return MAPPER.delMajor(dto);
    }

    public MajorUpdRes updMajor(MajorUpdParam p)throws Exception{
        MajorUpdDto dto = new MajorUpdDto();
        dto.setMajorName(p.getMajorName());
        dto.setImajor(p.getImajor());

        try {
            int result = MAPPER.updMajor(dto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("이미 존재하는 학과입니다");
        }
        return new MajorUpdRes(p);
    }

}
