package com.green.smartGrade.security.config.security;

import com.green.smartGrade.security.config.security.model.UserEntity;
import com.green.smartGrade.security.config.security.model.UserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDetailsMapper {
//    int save(UserEntity p);
    UserEntity getByUid(String uid);


    int updUserToken(UserTokenEntity p);
    UserTokenEntity selUserToken(UserTokenEntity p);
}
