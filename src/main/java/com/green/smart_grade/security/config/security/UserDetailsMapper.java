package com.green.smart_grade.security.config.security;

import com.green.smart_grade.security.config.security.model.UserEntity;
import com.green.smart_grade.security.config.security.model.UserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDetailsMapper {

    UserEntity getByUid(String uid);

    int updUserToken(UserTokenEntity p);
    UserTokenEntity selUserToken(UserTokenEntity p);
}
