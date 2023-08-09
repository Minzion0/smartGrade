package com.green.smartGrade.student.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class StudentUpRes {
    private Long istudent;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime updatedAt;
    private String pic;

    public StudentUpRes(StudentUpdto dto) {
        this.istudent = dto.getIstudent();
        this.phone = dto.getPhone();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.updatedAt = LocalDateTime.now();
        this.pic = dto.getPic();
    }
}
