package com.tickets.Tickets.mapper;

import com.tickets.Tickets.entity.Promulgator;
import org.apache.ibatis.annotations.Mapper;

@Mapper //可以让spring扫描并纳入spring管理  也可以在config的类上添加另一个注解完成工作  @MapperScan
public interface PromulgatorMapper {
    Promulgator pro(int proId);
}
