package com.green.smart_grade.admin;


import com.green.smart_grade.admin.model.AdminSelLectureDto;
import com.green.smart_grade.admin.model.AdminSelLectureParam;
import com.green.smart_grade.admin.model.AdminSelLectureRes;
import com.green.smart_grade.utils.CommonUtils;

import com.green.smart_grade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {

    @Autowired
    private final AdminMapper MAPPER;
    private final CommonUtils commonUtils;

//    public List<AdminSelLectureRes> selLecture(AdminSelLectureParam param){
//        AdminSelLectureDto dto = new AdminSelLectureDto(param);
//        int maxpage = MAPPER.countLceture(dto);
//        List<AdminSelLectureRes> res = MAPPER.selLecture();
//
//    }





}
