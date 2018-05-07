package com.tickets.Tickets.service;

import com.tickets.Tickets.entity.UserInfo;

public interface UserInfoService {
    public UserInfo getUserInfoByUserId(long UserId);
    public boolean updateUserInfo(UserInfo userInfo);
}
