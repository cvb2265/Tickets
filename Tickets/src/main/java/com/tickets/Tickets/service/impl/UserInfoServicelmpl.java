package com.tickets.Tickets.service.impl;

import com.tickets.Tickets.entity.UserInfo;
import com.tickets.Tickets.mapper.UserInfoMapper;
import com.tickets.Tickets.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userInfoService")
public class UserInfoServicelmpl implements UserInfoService{


    @Autowired
    private UserInfoMapper userInfoMapper;

    @Transactional(readOnly=true)
    @Override
    public UserInfo getUserInfoByUserId(long userId) {
        UserInfo userInfo =userInfoMapper.userInfoByUserId(userId);
        return userInfo;
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        System.out.println("Service数据展示_____");
        System.out.println(userInfo.getId());
        System.out.println(userInfo.getUser_id());
        System.out.println(userInfo.getBirthdate());
        System.out.println(userInfo.getEducation());
        System.out.println(userInfo.getJob());
        userInfoMapper.updateUserInfo(userInfo);
        return true;
    }
}
