package com.tickets.Tickets.mapper.tqy;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.tickets.Tickets.entity.tqy.User;

/**
 * @author tqy
 * @date 2018年3月23日
 * 
 */
@Mapper
@Repository("userMapper_tqy")
public interface UserMapper {

	@Select(value = "SELECT * FROM user WHERE email = #{email} AND password = #{password}")
	public User find(@Param("email")String email, @Param("password")String password);

	@Select(value = "SELECT * FROM user WHERE email = #{email}")
	public User findByEmail(@Param("email")String email);
	
	@Select(value = "SELECT * FROM user WHERE userid = #{userid}")
	public User findById(@Param("email")Integer userid);
	
	@Select(value = "SELECT COUNT(userid) FROM user WHERE email = #{email}")
	public boolean exist(@Param("email")String email);
	
	@Insert(value = "INSERT INTO user(email, password, nickename, interest, face, level, exp, points, money)\n" + 
			"VALUES (#{email}, #{password}, #{nickename}, #{interest}, #{face}, #{level}, #{exp}, #{points}, #{money})")
	public Integer save(User user);
	
	
	@Update(value = "UPDATE user SET email=#{email}, password=#{password}, \n" + 
			"nickename=#{nickename}, interest=#{interest}, face=#{face}, level=#{level},\n" + 
			"exp=#{exp}, points=#{points}, money=#{money}\n" + 
			"WHERE userid = #{userid}")
	public Integer update(User user);

}
