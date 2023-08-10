package com.green.smartGrade.admin;


import com.green.smartGrade.admin.model.*;
import com.green.smartGrade.admin.student.model.AdminGraduationStudentVo;
import com.green.smartGrade.config.exception.AdminException;
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
        for (AdminSelLectureRes re : res) {
            int str = re.getStrTime().lastIndexOf(":");
            re.getStrTime().substring(str);
            re.getEndTime();
        }

       return AdminSelRes.builder().lectures(res).page(utils).build();

    }
    @Transactional(rollbackFor = Exception.class)
    public AdminUpdLectureRes lectureModify(AdminUpdLectureDto dto){


           int upded = MAPPER.updLecture(dto);
           if (dto.getProcedures()==0){
               MAPPER.lectureModify(dto);
           }
           if (upded==1){
               return new AdminUpdLectureRes(dto);
           }
       throw  new AdminException("수정 오류");
    }

    public AdminLectureStudentResm findlectureStudent(Long ilecture ){
        AdminLectureInStudentDto dto = new AdminLectureInStudentDto();
       dto.setIlecture(ilecture);

        List<AdminLectureInStudentRes> adminLectureInStudentRes = MAPPER.lectureInStudent(dto);
        for (AdminLectureInStudentRes res : adminLectureInStudentRes) {
            GradeUtils utils = new GradeUtils(res.getTotalScore());
            double num = utils.totalScore();
            String result = utils.totalRating(num);
            res.setGread(result);
            res.setAvg(num);
        }
        AdminLectureStudentResm resm = new AdminLectureStudentResm();
        resm.setList(adminLectureInStudentRes);
        return resm;
    }

    public AdminInsSemesterRes semesterIns(AdminInsSemesterParam param) throws AdminException {
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
        throw new AdminException(res.getMsg());
    }

    public List<AdminGetSemesterVo> getSemester(String year){
        return MAPPER.getSemester(year);
    }





}




