package com.green.smart_grade.utils;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Slf4j
@Builder
public class CheckUtils {
    private String gender;
    private String email;
    private String phoneNum;
    private String msg;



    public boolean genderCheck(){
        String regx = "^[FM]$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(gender);

        return matcher.matches();
    }

    public boolean emailCheck(){
        String regx = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern patten = Pattern.compile(regx);

        Matcher matcher = patten.matcher(email);

        //정상적인 이메일형식이면 true,아니면 false
        return matcher.matches();
    }

    public boolean phoneCheck(){
        String pattern = "^01([0|1|6|7|8|9])-(\\d{3,4})-(\\d{4})$";

        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(phoneNum);
        String s = phoneNum.replaceAll(" ", "");

        log.info("phoneNum : {}",phoneNum);
        log.info("matcher.matches() : {}",matcher.matches());
        return matcher.matches();

    }

    public String getMsg(){
        if (!phoneCheck()){
            msg+=" 전화번호";
        }
        if (!emailCheck()){
            msg+=" 이메일";
        }
        if (!genderCheck()){
            msg+=" 성별";
        }
        return msg;
    }

}
