package com.tickets.Tickets.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @author tqy
 * @date 2018年3月23日
 * 
 */
//详细解释清参见https://blog.csdn.net/carrie__yang/article/details/77504778?locationNum=3&fps=1
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            	//可多填，任何用户都可以访问的url
//            .antMatchers("/**", "/js/**", "/css/**", "/images/**", "/user/",
//            		"/user/indexV", "/user/loginV", "/user/regV"
//            		).permitAll()
            .antMatchers("/**").permitAll();
                
                //只有"USER"类用户才能访问这类url
                //.antMatchers( "/user/**").hasRole("USER")
                //.anyRequest().authenticated()	
                //.and()
            //.formLogin()
                //.loginPage("/user/ssslogin")  //被拦截之后跳转到该url，属于重定向
                //.permitAll()
                //.and()
            //.logout()
                //.permitAll();
        
        //关闭csrf，否则ajax的post请求无法提交
        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth
            //.inMemoryAuthentication()
                //.withUser("user").password("password").roles("USER");
    }
}
