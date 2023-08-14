package com.green.smartGrade.admin.major;

import com.green.smartGrade.admin.major.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMajorMapper {
    int insMajor(MajorInsDto dto);

    List<MajorVo> selMajor(MajorSelDto dto);

    int updMajor(MajorUpdDto dto);

    int delMajor(MajorDelDto dto);

    int countMajor(MajorSelDto dto);
}
