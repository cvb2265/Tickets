package com.tickets.Tickets.mapper;

import com.tickets.Tickets.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    UserInfo userInfoByUserId(long user_id);
    void addUserInfo(UserInfo userInfo);
    boolean deleteInfoByUserId(long user_id);
    void updateUserInfo(UserInfo userInfo);
}
