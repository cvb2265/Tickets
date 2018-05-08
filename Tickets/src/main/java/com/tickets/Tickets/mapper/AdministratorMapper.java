package com.tickets.Tickets.mapper;

import com.tickets.Tickets.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sun.security.util.Password;

@Mapper
public interface AdministratorMapper {
    Administrator find(@Param("name")String name,@Param("password") String password);
    Administrator adminById(long adminId);
    Administrator adminByName(String adminName );
}
