package com.green.smartGrade.professor;

import com.green.smartGrade.professor.model.*;
import com.green.smartGrade.utils.CommonUtils;
import com.green.smartGrade.utils.FileUtils;
import com.green.smartGrade.utils.PagingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorMapper mapper;
    private final CommonUtils commonUtils;

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


        public ProfessorUpRes upProfessor(ProfessorParam param) {
        ProfessorUpDto dto = new ProfessorUpDto();
        dto.setPhone(param.getPhone());
        dto.setEmail(param.getEmail());
        dto.setAddress(param.getAddress());
        dto.setIprofessor(param.getIprofessor());

        int result = mapper.upProfessor(dto);
        if (result == 1 ) {
            ProfessorUpRes res = new ProfessorUpRes(dto);
            return res;
        }
        return null;
    }
    public String upPicProfessor(MultipartFile pic , ProfessorPicDto dto) {
        String centerPath = String.format("professor/%d", dto.getIprofessor());
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
        } catch (Exception e) {
            return temp;
        }dto.setPic(savedFilePath);
        try {
            int result = mapper.upPicProfessor(dto);
            if (result == Integer.parseInt(temp)) {
                throw new Exception("스티커 사진 등록 불가");
            }
        } catch (Exception e) {
            target.delete();
            return temp;
        }
        return savedFilePath;

    }
    public professorSelRes selAllProfessor(ProfessorSelDto dto,int page) {
        int maxPage = mapper.ProfessorCount();
        PagingUtils utils = new PagingUtils(page,maxPage);


        dto.setRow(utils.getROW());
        dto.setStartIdx(utils.getStaIdx());

        List<ProfessorVo> professorVos = mapper.selAllProfessor(dto);

        return professorSelRes.builder().list(professorVos).page(utils).build();
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

}
