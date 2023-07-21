package com.green.smart_grade.major;

import com.green.smart_grade.major.model.MajorDelDto;
import com.green.smart_grade.major.model.MajorInsDto;
import com.green.smart_grade.major.model.MajorDetailDto;
import com.green.smart_grade.major.model.MajorVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MajorMapper {
    int insMajor(MajorInsDto dto);

    List<MajorVo> selMajor();

    MajorVo selMajorDetail(MajorDetailDto dto);

    int delMajor(MajorDelDto dto);
}
