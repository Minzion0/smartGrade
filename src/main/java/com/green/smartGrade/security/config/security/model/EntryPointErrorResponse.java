package com.green.smartGrade.security.config.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
// 요청을 보냈을때 권한이 없으면 메세지 보내줄 객체
public class EntryPointErrorResponse {
    private String msg;
}
