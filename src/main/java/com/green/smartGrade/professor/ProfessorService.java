package com.green.smartGrade.professor;

import com.green.smartGrade.professor.model.*;
import com.green.smartGrade.utils.CommonUtils;
import com.green.smartGrade.utils.FileUtils;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorMapper mapper;
    private final CommonUtils commonUtils;
    private final PasswordEncoder PW_ENCODER;

    @Value("${file.dir}")
    private String fileDir;


    public ProfessoreDatailProFileVo selProfessor(ProfessorSelDto dto) {
        List<ProfessorMajor> major = mapper.professorMajor(dto);
        ProfessorDatilProfile profile = mapper.selProfessor(dto);


        return ProfessoreDatailProFileVo.builder().profile(profile).lectureList(major).build();
    }


//        public ProfessorUpRes upProfessor(ProfessorParam param) {
//        ProfessorUpDto dto = new ProfessorUpDto();
//        dto.setPhone(param.getPhone());
//        dto.setEmail(param.getEmail());
//        dto.setAddress(param.getAddress());
//        dto.setIprofessor(param.getIprofessor());
//
//        int result = mapper.upProfessor(dto);
//        if (result == 1 ) {
//            ProfessorUpRes res = new ProfessorUpRes(dto);
//            return res;
//        }
//        return null;
//    }
    public ProfessorUpRes upProfessor(MultipartFile pic, ProfessorParam param) {

        int result = 0;
        ProfessorUpDto dto = new ProfessorUpDto();
        dto.setAddress(param.getAddress());
        dto.setPhone(param.getPhone());
        dto.setEmail(param.getEmail());
        dto.setIprofessor(param.getIprofessor());

        dto.setIprofessor(param.getIprofessor());
        if (param.getPhone() != null && !param.getPhone().equals("string")) {
            dto.setPhone(param.getPhone());
        }
        if (param.getEmail() != null && !param.getEmail().equals("string")) {
            dto.setEmail(param.getEmail());
        }
        if (param.getAddress() != null && !param.getAddress().equals("string")) {
            dto.setAddress(param.getAddress());
        }


        result = mapper.upProfessor(dto);

        if (result == 1 ) {
            if (pic != null) {

                String centerPath = String.format("professor/%d", param.getIprofessor());
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
                    result = mapper.upProfessor(dto);
                    if (result == Integer.parseInt(temp)){
                        throw new Exception("스티커 사진 불가");
                    }
                } catch (Exception e) {
                    target.delete();
                }
            }
            ProfessorUpRes res = new ProfessorUpRes(dto);
            return res;
        }
        return null;
    }




    public SelProfessorRes selProfessorLecture(ProfessorSelLectureDto dto) {
        int maxPage = mapper.selProfessorLectureCount(dto);
        PagingUtils utils = new PagingUtils(dto.getPage(), maxPage);
        dto.setStaIdx(utils.getStaIdx());
        List<ProfessorSelLectureVo> list = mapper.selProfessorLecture(dto);
        return SelProfessorRes.builder()
                  .list(list)
                  .page(utils)
                  .build();
    }

    public String updPassword(ProfessorUpdPasswordDto dto, ProfessorUpdPasswordParam param) {
        ProfessorSelCurrentPasswordDto passwordDto = new ProfessorSelCurrentPasswordDto();
        passwordDto.setRole(dto.getRole());
        passwordDto.setIprofessor(dto.getIprofessor());
        ProfessorSelCurrentPasswordVo vo = mapper.selPasswordCurrent(passwordDto);

        if (!PW_ENCODER.matches(param.getCurrentStudentPassword(), vo.getCurrentStudentPassword())){
            return "비밀번호 변경이 완료되었습니다.";
        }
        dto.setProfessorPassword(param.getProfessorPassword());
        String npw = PW_ENCODER.encode(dto.getProfessorPassword());
        dto.setProfessorPassword(npw);
        mapper.updPassword(dto);
        return "비밀번호 변경이 완료 되었습니다.";
    }



    public void deleteUploadedFile(Long iprofessor) {
        // 데이터베이스에서 파일 경로 조회

        String filePath = mapper.picFilePathByProfessor(iprofessor);
        String centerPath = String.format("professor/%d", iprofessor);
        String dicPath = String.format("%s/%s/%s", FileUtils.getAbsolutePath(fileDir), centerPath,filePath);



        if (dicPath != null) {
            File fileToDelete = new File(dicPath);
            if (fileToDelete.exists()) {
                if (fileToDelete.delete()) {
                    // 파일 삭제 성공
                    mapper.updateFilePathNullByProfessor(iprofessor);
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
