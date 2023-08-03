package com.green.smartGrade.admin;


import com.green.smartGrade.admin.model.*;
import com.green.smartGrade.utils.CommonUtils;

import com.green.smartGrade.utils.GradeUtils;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

       return AdminSelRes.builder().lectures(res).page(utils).build();

    }
    @Transactional(rollbackFor = Exception.class)
    public AdminUpdLectureRes lectureModify(AdminUpdLectureDto dto){
       try {

           int upded = MAPPER.updLecture(dto);
           if (dto.getProcedures()==0){
               MAPPER.lectureModify(dto);
           }
           if (upded==1){
               return new AdminUpdLectureRes(dto);
           }
       }catch (Exception e){
           return null;
       }
        return null;
    }

    public AdminLectureStudentResm findlectureStudent(Long ilecture,int page ){
        AdminLectureInStudentDto dto = new AdminLectureInStudentDto();

        int currentPeople = MAPPER.lectureCountStudent(ilecture);
        PagingUtils pagingUtils = new PagingUtils(page,currentPeople);
        dto.setIlecture(ilecture);
        dto.setRow(pagingUtils.getROW());
        dto.setStrIdx(pagingUtils.getStaIdx());


        List<AdminLectureInStudentRes> adminLectureInStudentRes = MAPPER.lectureInStudent(dto);
        long str = System.currentTimeMillis();
        log.info("시작시간 : {}",str);
        for (AdminLectureInStudentRes res : adminLectureInStudentRes) {

            GradeUtils utils = new GradeUtils(res.getTotalScore());
            double v = utils.totalScore();
            String s = utils.totalRating(v);
            res.setGread(s);
            res.setAvg(v);
//            int score = res.getTotalScore();
//            utils2.getGread(score);
//            String grade = utils2.getGrade();
//            double pp = utils2.getPp();
//            res.setAvg(pp);
//            res.setGread(grade);

        }

        long end = System.currentTimeMillis();
        log.info("종료시간 : {}",end);
        log.info("시간은? : {}",end-str);
        AdminLectureStudentResm resm = new AdminLectureStudentResm();
        resm.setList(adminLectureInStudentRes);
        resm.setPage(pagingUtils);
        return resm;
    }






}

class GradeUtils2{
    private  double pp;
    private  String grade;

    public double getPp() {
        return pp;
    }

    public String getGrade() {
        return grade;
    }


    public void getGread(int totalScore){
        int temp= totalScore/10;
        int temp2=totalScore%10;
        double result=0;
        String gread="F";
        if (temp>=9){
            result=4.0;
            gread="A";
        }else if (temp>=8){
            result= 3.0;
            gread="B";
        }else if (temp>=7){
            result=2.0;
            gread="C";
        } else if (temp >= 6) {
            result=1.0;
            gread="D";

        }

        if (temp2>4 || totalScore== 100){
            result+=0.5;
            gread+="+";
        }
        this.pp=result;
        this.grade=gread;
    }


}


