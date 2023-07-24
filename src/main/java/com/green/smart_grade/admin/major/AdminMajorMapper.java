package com.green.smart_grade.admin.major;

import com.green.smart_grade.admin.major.model.MajorDelDto;
import com.green.smart_grade.admin.major.model.MajorDetailDto;
import com.green.smart_grade.admin.major.model.MajorInsDto;
import com.green.smart_grade.admin.major.model.MajorVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMajorMapper {
    int insMajor(MajorInsDto dto);

    List<MajorVo> selMajor();

    MajorVo selMajorDetail(MajorDetailDto dto);

    int delMajor(MajorDelDto dto);
}
