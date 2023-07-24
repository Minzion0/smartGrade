package com.green.smart_grade.admin.major;

import com.green.smart_grade.admin.major.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMajorMapper {
    int insMajor(MajorInsDto dto);

    List<MajorVo> selMajor(int staIdx);

    MajorVo selMajorDetail(MajorDetailDto dto);

    int delMajor(MajorDelDto dto);

    int countMajor();
}
