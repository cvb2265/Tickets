package com.tickets.Tickets.mapper;

import com.tickets.Tickets.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdministratorMapper {
    Administrator adminById(long adminId);
    Administrator adminByName(String adminName );
}
