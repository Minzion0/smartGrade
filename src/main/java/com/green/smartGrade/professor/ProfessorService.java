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


    public professorSelRes selProfessor(Long ip) {
        int maxPage = mapper.ProfessorCount();
        PagingUtils utils = new PagingUtils();
        ProfessorSelDto dto = new ProfessorSelDto();
        dto.setRow(utils.getROW());
        dto.setStartIdx(utils.getStaIdx());
        dto.setIprofessor(ip);


        List<ProfessorVo> professorVos = mapper.selProfessor(dto);

        return professorSelRes.builder().list(professorVos).page(utils).build();
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
//        dto.setAddress(param.getAddress());
//        dto.setPhone(param.getPhone());
//        dto.setEmail(param.getEmail());
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

    public int updPassword(ProfessorUpdPasswordDto dto, ProfessorUpdPasswordParam param) {
        dto.setProfessorPassword(param.getProfessorPassword());
        String npw = PW_ENCODER.encode(dto.getProfessorPassword());
        dto.setProfessorPassword(npw);
        return mapper.updPassword(dto);
    }

    public int delpicByprofessor(ProfessorDelPic pic) {
        if ("string".equals(pic.getPic())) {
           pic.setPic(null);
        }
        return mapper.delpicByprofessor(pic);
    }
}
