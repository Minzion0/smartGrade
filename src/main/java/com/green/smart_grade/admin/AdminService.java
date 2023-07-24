package com.green.smart_grade.admin;


import com.green.smart_grade.admin.model.*;
import com.green.smart_grade.utils.CommonUtils;

import com.green.smart_grade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {

    @Autowired
    private final AdminMapper MAPPER;
    private final CommonUtils commonUtils;

    public AdminSelRes selLecture(AdminSelLectureParam param){
        AdminSelLectureDto dto = new AdminSelLectureDto(param);
        int maxpage = MAPPER.countLceture(dto);
        PagingUtils utils = new PagingUtils(param.getPage(),maxpage);
        dto.setRow(utils.getROW());
        dto.setStrIdx(utils.getStaIdx());
        List<AdminSelLectureRes> res = MAPPER.selLecture(dto);
        List<AdminSelLectureVo> list = new ArrayList<>();
        for (AdminSelLectureRes re : res) {
            AdminSelLectureVo vo = new AdminSelLectureVo(re);
            String date = String.format("%s ~ %s", re.getStrDate(), re.getEndDate());
            LocalTime strTime = LocalTime.parse(re.getStrTime());
            LocalTime endTime = LocalTime.parse(re.getEndTime());
            String  time = endTime.minusHours(strTime.getHour()).toString();
            vo.setDate(date);
            vo.setTime(time);
            list.add(vo);
        }

       return AdminSelRes.builder().lectures(list).page(utils).build();

    }
    @Transactional(rollbackFor = Exception.class)
    public AdminUpdLectureRes lectureModify(AdminUpdLectureDto dto){
       try {

           int upded = MAPPER.updLecture(dto);
           if (dto.getProcedures()==0){
               MAPPER.lectureModify(dto);
           }
           if ( upded==1){
               return new AdminUpdLectureRes(dto);
           }
       }catch (Exception e){
           return null;
       }
        return null;
    }





}
