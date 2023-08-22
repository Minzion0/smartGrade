package com.green.smartGrade.student;

import com.green.smartGrade.professor.model.ProfessorUpDto;
import com.green.smartGrade.student.model.*;
import com.green.smartGrade.utils.FileUtils;
import com.green.smartGrade.utils.GradeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentMapper mapper;
    private final PasswordEncoder PW_ENCODER;
    @Value("${file.dir}")
    private String fileDir;


    public StudentInsRes insSdy(StudentInsDto dto) {

//        dto.setIlecture(param.getIlecture());
//        dto.setFinishedYn(param.getFinishedYn());

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


    public StudentSelRes selAllSdy(StudentSelDto dto) {


        List<StudentSelVo> list = mapper.selAllSdy(dto);
        for (StudentSelVo  vo  :  list ) {
            GradeUtils gradeUtils = new GradeUtils(vo.getTotalScore());
            double score = gradeUtils.totalScore();
            String rating = gradeUtils.totalRating(score);
            vo.setRating(rating);
        }
        return StudentSelRes.builder()
                .list(list)
                .build();

    }

    public StudentDatilProFileVo selStudentProfile(StudentSelProfileDto dto) {
        List<StudentMajor> major = mapper.selStudentMajor(dto);
        StudentSelProfile profile = mapper.selStudentProfile(dto);

        profile.setSecretKey(profile.getSecretKey() == null ? "false" : "true");

        return StudentDatilProFileVo.builder()
                .profile(profile).lectureList(major).build();
    }

    public StudentSelPointRes selStudentRemainingPoint(StudentSelPointDto dto) {

        dto.setStudentNum(dto.getStudentNum());
        dto.setIstudent(dto.getIstudent());
        List<StudentSelPointVo> list = mapper.selStudentRemainingPoint(dto);

        return StudentSelPointRes.builder().list(list).build();
    }

    public StudentUpRes upStudent(MultipartFile pic, StudentUpParam param) {
        StudentUpdto dto = new StudentUpdto();
        dto.setAddress(param.getAddress());
        dto.setPhone(param.getPhone());
        dto.setEmail(param.getEmail());
        dto.setIstudent(param.getIstudent());
        int result = 0;

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

    public void deleteStudentPic(Long istudent) {
        StudentUpdto getStudent = mapper.getStudentById(istudent); // 해당 학생의 정보 가져오기
        if (getStudent != null && getStudent.getPic() != null) {
            // 기존 사진이 있을 경우 삭제
            String picPath = String.format("students/%d/%s", istudent, getStudent.getPic());
            String fullPath = String.format("%s/%s", FileUtils.getAbsolutePath(fileDir), picPath);

            File picFile = new File(fullPath);
            if (picFile.exists()) {
                picFile.delete();
            }
        }
    }




    public String updPassword(StudentUpdPasswordDto dto,StudentUpdPasswordParam param) throws Exception {
        StudentSelCurrentPasswordDto passwordDto = new StudentSelCurrentPasswordDto();
        passwordDto.setRole(dto.getRole());
        passwordDto.setIstudent(dto.getIstudent());
        StudentSelCurrentPasswordVo vo = mapper.selPasswordCurrent(passwordDto);

        if (!PW_ENCODER.matches(param.getCurrentStudentPassword(), vo.getCurrentStudentPassword())){
            throw  new Exception("기존 비밀번호 입력을 다시 확인해주세요");
        }
        dto.setStudentPassword(param.getStudentPassword());
        String npw = PW_ENCODER.encode(dto.getStudentPassword());
        dto.setStudentPassword(npw);
        mapper.updPassword(dto);
        return "비밀번호 변경이 완료되었습니다.";
    }

    public void deleteUploadedFile(Long istudent) {
        // 데이터베이스에서 파일 경로 조회

        String filePath = mapper.picFilePathByStudent(istudent);
        String centerPath = String.format("students/%d", istudent);
        String dicPath = String.format("%s/%s/%s", FileUtils.getAbsolutePath(fileDir), centerPath,filePath);



        if (dicPath != null) {
            File fileToDelete = new File(dicPath);
            if (fileToDelete.exists()) {
                if (fileToDelete.delete()) {
                    // 파일 삭제 성공
                    mapper.updateFilePathNullByStudent(istudent);
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
