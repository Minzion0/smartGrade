package com.green.smartGrade.student;

import com.green.smartGrade.admin.board.model.BoardUpdRes;
import com.green.smartGrade.lecture_applly.model.LectureApllyDto;
import com.green.smartGrade.professor.model.ProfessorUpdPasswordDto;
import com.green.smartGrade.professor.model.SelProfessorRes;
import com.green.smartGrade.student.model.*;
import com.green.smartGrade.utils.FileUtils;
import com.green.smartGrade.utils.GradeUtils;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentMapper mapper;
    private final PasswordEncoder PW_ENCODER;
    @Value("${file.dir}")
    private String fileDir;


    public StudentInsRes insSdy(StudentParam param) {
        StudentInsDto dto = new StudentInsDto();

        dto.setIstudent(param.getIstudent());
        dto.setIlecture(param.getIlecture());
        dto.setFinishedYn(param.getFinishedYn());

//        StudentInsDto apllyDto = new StudentInsDto();
//        apllyDto.setDayWeek(String.valueOf(integer));
//        apllyDto.setIlecture(dto.getIlecture());
//        updatedDayList.add(apllyDto);

        List<Integer> dayList = mapper.selDayWeek(dto.getIlecture());
//        List<StudentInsDto> updatedDayList = new ArrayList<>();
        String temp="";
        temp=dayList.get(0).toString();
        for (int i = 1; i < dayList.size(); i++) {
            temp+=",";
            temp+=dayList.get(i).toString();

        }

        int result = mapper.insSdy(dto);
        if (result == 1) {
            StudentInsRes res = new StudentInsRes(dto);
            res.setDayWeek(temp);
            return res;
        }
        return null;
    }


    public StudentSelRes selAllSdy(StudentSelDto dto,int page) {
        int maxpage = mapper.StudentCount();
        PagingUtils utils = new PagingUtils(page,maxpage);
        dto.setStartIdx(utils.getStaIdx());
        dto.setStudentNum(dto.getStudentNum());
        dto.setRow(utils.getROW());

        List<StudentSelVo> list = mapper.selAllSdy(dto);
        for (StudentSelVo  vo  :  list ) {
            GradeUtils gradeUtils = new GradeUtils(vo.getTotalScore());
            double score = gradeUtils.totalScore();
            String rating = gradeUtils.totalRating(score);
            vo.setRating(rating);
        }
        return StudentSelRes.builder()
                .list(list)
                .page(utils)
                .build();

    }

    public StudentSelProfileRes selStudentProfile(StudentSelProfileDto dto,int page) {
        int maxpage = mapper.StudentCount();
        PagingUtils utils = new PagingUtils(page,maxpage);
        dto.setStartIdx(utils.getStaIdx());
        dto.setStudentNum(dto.getStudentNum());
        dto.setRow(utils.getROW());
        List<StudentSelProfileVo> list = mapper.selStudentProfile(dto);

        return StudentSelProfileRes.builder().list(list).page(utils).build();
    }

    public StudentSelPointRes selStudentRemainingPoint(StudentSelPointDto dto, int page) {
        int maxpage = mapper.StudentCount();
        PagingUtils utils = new PagingUtils(page, maxpage);
        dto.setStartIdx(utils.getStaIdx());
        dto.setRow(utils.getROW());
        dto.setStudentNum(dto.getStudentNum());
        List<StudentSelPointVo> list = mapper.selStudentRemainingPoint(dto);

        return StudentSelPointRes.builder().list(list).page(utils).build();
    }

    public StudentUpRes upStudent(MultipartFile pic, StudentUpParam param) {
        StudentUpdto dto = new StudentUpdto();
        dto.setAddress(param.getAddress());
        dto.setPhone(param.getPhone());
        dto.setEmail(param.getEmail());
        dto.setIstudent(param.getIstudent());
        int result = 0;
//        if (dto.getPhone() != null && !dto.getPhone().equals("string")) {
//            dto.setPhone(param.getPhone());
//        }
//        if (dto.getEmail() != null && !dto.getEmail().equals("string")) {
//            dto.setEmail(param.getEmail());
//        }
//        if (dto.getAddress() != null && !dto.getAddress().equals("string")) {
//            dto.setAddress(param.getAddress());
//        }

         result = mapper.upStudent(dto);
        if (result == 1) {
            if (pic != null) {
                String centerPath = String.format("students/%d", param.getIstudent());
                String dicPath = String.format("%s/%s", FileUtils.getAbsolutePath(fileDir), centerPath);
                String temp = "0";

                File dic = new File(dicPath);
                if(!dic.exists()) {
                    dic.mkdirs();
                }

                String originFileName = pic.getOriginalFilename();
                String savedFileName = FileUtils.makeRandomFileNm(originFileName);
                String savedFilePath = String.format("%s/%s", centerPath, savedFileName);
                String targetPath = String.format("%s/%s", FileUtils.getAbsolutePath(fileDir), savedFilePath);

                File target = new File(targetPath);

                try {
                    pic.transferTo(target);
                } catch (IOException e) {
                    throw new RuntimeException(temp);
                }
                  dto.setPic(savedFileName);
                try {
                    result = mapper.upStudent(dto);
                    if (result == Integer.parseInt(temp)) {
                        throw new Exception("사진 등록 불가");
                    }
                } catch (Exception e) {
                    target.delete();
                }
            }

            StudentUpRes res = new StudentUpRes(dto);
            return res;
        }
        return null;

    }
    public String updPassword(StudentUpdPasswordDto dto,StudentUpdPasswordParam param) {
        StudentSelCurrentPasswordDto passwordDto = new StudentSelCurrentPasswordDto();
        passwordDto.setRole(dto.getRole());
        passwordDto.setIstudent(dto.getIstudent());
        StudentSelCurrentPasswordVo vo = mapper.selPasswordCurrent(passwordDto);

        if (!PW_ENCODER.matches(param.getCurrentStudentPassword(), vo.getCurrentStudentPassword())){
            return "비밀번호 변경을 실패했습니다";
        }
        dto.setStudentPassword(param.getStudentPassword());
        String npw = PW_ENCODER.encode(dto.getStudentPassword());
        dto.setStudentPassword(npw);
        mapper.updPassword(dto);
        return "비밀번호 변경이 완료되었습니다.";
    }

    public void deleteUploadedFile(Long studentNum) {
        // 데이터베이스에서 파일 경로 조회

        String filePath = mapper.picFilePathByStudent(studentNum);
        String centerPath = String.format("students/%d", studentNum);
        String dicPath = String.format("%s/%s/%s", FileUtils.getAbsolutePath(fileDir), centerPath,filePath);



        if (dicPath != null) {
            File fileToDelete = new File(dicPath);
            if (fileToDelete.exists()) {
                if (fileToDelete.delete()) {
                    // 파일 삭제 성공
                    mapper.updateFilePathNullByStudent(studentNum);
                } else {
                    // 파일 삭제 실패
                    throw new RuntimeException("파일 삭제 실패");
                }
            } else {
                // 파일이 존재하지 않음
                throw new RuntimeException("파일이 존재하지 않음: " + filePath);
            }
        } else {
            // 파일 경로가 없음
            throw new RuntimeException("파일 경로가 없음");
        }
    }
}
