package com.tickets.Tickets.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//详细解释清参见https://blog.csdn.net/carrie__yang/article/details/77504778?locationNum=3&fps=1
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/js/**", "/css/**", "/images/**", "/user/", "/user/login").permitAll()	//可多填，任何用户都可以访问的url
                .antMatchers( "/user/**").hasRole("USER")   //只有"USER"类用户才能访问这类url
                .anyRequest().authenticated()	
                .and()
            .formLogin()
                .loginPage("/user/ssslogin")  //被拦截之后跳转到该url，属于重定向
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
