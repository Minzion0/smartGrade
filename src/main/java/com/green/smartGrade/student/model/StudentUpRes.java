package com.green.smartGrade.student.model;

import com.green.smartGrade.utils.PagingUtils;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class StudentUpRes {
    private Long studentNum;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime updatedAt;

    public StudentUpRes(StudentUpdto dto) {
        this.studentNum = dto.getStudentNum();
        this.phone = dto.getPhone();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.updatedAt = LocalDateTime.now();
    }
}
