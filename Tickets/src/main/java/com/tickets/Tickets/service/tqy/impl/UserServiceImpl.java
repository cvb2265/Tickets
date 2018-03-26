package com.tickets.Tickets.service.tqy.impl;

import com.tickets.Tickets.entity.tqy.User;
import com.tickets.Tickets.mapper.tqy.UserMapper;
import com.tickets.Tickets.service.tqy.UserService;

import java.util.Date;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tqy
 * @date 2018年3月23日
 * 
 */
//加入事务管理
@Service("userService_tqy")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class UserServiceImpl implements UserService {
	@Value("${adminEmailAccount}")
	private String adminEmailAccount;
	@Value("${adminEmailPassword}")
	private String adminEmailPassword;
	@Value("${adminEmailSMTPHost}")
	private String adminEmailSMTPHost;
	
	
	@Autowired
	@Qualifier("userMapper_tqy")
	private UserMapper userMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	
	@Transactional(readOnly=true)
	@Override
	public User login(String email, String password) {
		logger.info("UserService的login方法 被调用，用户邮箱是"+email);
		return userMapper.find(email, password);
	}
	
	/**
	 * 创建邮件
	 * @param session
	 * @param sendMail
	 * @param senderName
	 * @param receiverName
	 * @param subject
	 * @param content
	 * @param receiveMail
	 * @return
	 * @throws Exception
	 */
	private MimeMessage createMimeMessage(
    		Session session,
    		String sendMail,
    		String senderName,
    		String receiverName,
    		String subject,
    		String content,
    		String receiveMail) throws Exception {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sendMail, senderName, "UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, receiverName, "UTF-8"));
        message.setSubject(subject, "UTF-8");
        message.setContent(content, "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }

	@Override
	public boolean checkEmail(String email) {
		return userMapper.exist(email);
	}

}
