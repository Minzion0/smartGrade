package com.green.smart_grade.admin.model;

import com.green.smart_grade.utils.PagingUtils;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Getter
@Builder
public class AdminSelRes {
    private PagingUtils page;
    private List<AdminSelLectureVo> lectures;
}
