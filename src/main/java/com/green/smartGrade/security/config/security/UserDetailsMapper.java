package com.green.smartGrade.security.config.security;

import com.green.smartGrade.security.config.security.model.UserEntity;
import com.green.smartGrade.security.config.security.model.UserSelRoleEmailVo;
import com.green.smartGrade.security.config.security.model.UserTokenEntity;
import com.green.smartGrade.security.config.security.model.UserUpdSecretKeyDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDetailsMapper {
//    int save(UserEntity p);
    UserEntity getByUid(String uid, String role);


    int updUserToken(UserTokenEntity p);
    UserTokenEntity selUserToken(UserTokenEntity p);

    UserSelRoleEmailVo getUserRoleEmail(String uid, String role);
   int updSecretKey(UserUpdSecretKeyDto dto);
}