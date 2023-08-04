package com.green.smartGrade.admin;


import com.green.smartGrade.admin.model.*;
import com.green.smartGrade.admin.student.model.AdminGraduationStudentVo;
import com.green.smartGrade.utils.CommonUtils;

import com.green.smartGrade.utils.GradeUtils;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {

    @Autowired
    private final AdminMapper MAPPER;

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

    public AdminLectureStudentResm findlectureStudent(Long ilecture ){
        AdminLectureInStudentDto dto = new AdminLectureInStudentDto();
       dto.setIlecture(ilecture);

        List<AdminLectureInStudentRes> adminLectureInStudentRes = MAPPER.lectureInStudent(dto);
        for (AdminLectureInStudentRes res : adminLectureInStudentRes) {

            GradeUtils utils = new GradeUtils(res.getTotalScore());
            double v = utils.totalScore();
            String s = utils.totalRating(v);
            res.setGread(s);
            res.setAvg(v);

        }
        AdminLectureStudentResm resm = new AdminLectureStudentResm();
        resm.setList(adminLectureInStudentRes);
        return resm;
    }

    public AdminInsSemesterRes semesterIns(AdminInsSemesterParam param){
        AdminInsSemesterDto dto = new AdminInsSemesterDto(param);
        String year = dto.getYear();
        Pattern pattern = Pattern.compile(year);
        LocalDate strDate = dto.getSemesterStrDate();
        int strDateYear = strDate.getYear();
        String strYear = String.valueOf(strDateYear);
        LocalDate eDate = dto.getSemesterEndDate();
        String endDate = String.valueOf(eDate.getYear());
        AdminInsSemesterRes res = new AdminInsSemesterRes();
        boolean matches = pattern.matcher(strYear).matches();
        boolean matches1 = pattern.matcher(endDate).matches();

        if (matches&&matches1){

            int result=0;
            try {

                result = MAPPER.semesterIns(dto);
            }catch (Exception e){
                res.setMsg("학기는 년도당 하나씩 가능합니다");
            }
            if (result==1){
                res.semesterSet(dto);
                List<AdminGraduationStudentVo> vo = MAPPER.graduationStudent();
                int graduationStudent = MAPPER.updGraduationStudent(vo);
                log.info("이번년도 졸업인원 : {}",graduationStudent);
                String format = String.format("이번학기 졸업인원은 : %s명 입니다", graduationStudent);
                res.setMsg(format);
                return res;
            }
            res.setMsg("학기 중복 입니다");
            return res;
        }

        res.setMsg("학기와 같은 년도가 아님");
        return res;
    }

    public List<AdminGetSemesterVo> getSemester(String year){
        return MAPPER.getSemester(year);
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


