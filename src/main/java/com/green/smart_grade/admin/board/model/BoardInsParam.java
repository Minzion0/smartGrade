package com.green.smart_grade.admin.board.model;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class BoardInsParam {
    private Long iadmin;
    private String ctnt;
    private String title;
    private int importance;
}
