package com.tickets.Tickets.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.tickets.Tickets.entity.User;

@Mapper
@Repository
public interface UserMapper {

	@Select(value = "SELECT * FROM user WHERE email = #{email} AND password = #{password}")
	public User find(@Param("email")String email, @Param("password")String password);
}
