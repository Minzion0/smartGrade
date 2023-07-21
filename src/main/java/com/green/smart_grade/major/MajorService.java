package com.green.smart_grade.major;

import com.green.smart_grade.major.model.MajorInsDto;
import com.green.smart_grade.major.model.MajorInsParam;
import com.green.smart_grade.major.model.MajorRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MajorService {

    @Autowired
    private final MajorMapper MAPPER;

    public MajorRes insMajor(MajorInsParam p) {
        MajorInsDto dto = new MajorInsDto();
        MAPPER.insMajor(dto);
        return new MajorRes(dto);
    }
}