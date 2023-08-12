//package com.green.smartGrade.professor;
//
//import com.green.smartGrade.professor.model.ProfessorDatilProfile;
//import com.green.smartGrade.professor.model.ProfessorMajor;
//import com.green.smartGrade.professor.model.ProfessorSelDto;
//import com.green.smartGrade.professor.model.ProfessoreDatailProFileVo;
//import lombok.Builder;
//import lombok.Getter;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.io.FileInputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//@Getter
//@Builder
//class FileInfo {
//    private String fileNm;
//    private String ext;
//    private String dic;
//
//    public String getFullFileNm() {
//        return String.format("%s.%s", fileNm, ext);
//    }
//    public String getPath() {
//        return String.format("%s/%s", dic, getFullFileNm());
//    }
//    public FileInputStream getStream() throws Exception {
//        return new FileInputStream(getPath());
//    }
//}
//
//@ExtendWith(SpringExtension.class)
//@Import({ProfessorService.class})
//class ProfessorServiceTest {
//
//    @MockBean
//    ProfessorMapper mapper;
//
//    @Autowired
//    ProfessorService service;
//
//    @Value("${file.dir}")
//    private String upPic;
//
//    @Test
//    void selProfessor() {
//
//
//
//    }
//
//
//
//    @Test
//    void upProfessor() {
//
//    }
//
//    @Test
//    void selProfessorLecture() {
//    }
//
//    @Test
//    void updPassword() {
//    }
//
//    @Test
//    void deleteUploadedFile() {
//    }
//}