package com.green.smart_grade.major;

import com.green.smart_grade.major.model.MajorInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MajorMapper {
    int insMajor(MajorInsDto dto);
}
