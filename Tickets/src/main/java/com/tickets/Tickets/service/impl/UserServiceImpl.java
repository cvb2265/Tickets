package com.tickets.Tickets.service.impl;

import com.tickets.Tickets.entity.User;
import com.tickets.Tickets.mapper.UserMapper;
import com.tickets.Tickets.service.UserService;

import java.util.Date;
import java.util.Properties;

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
@Service("userService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class UserServiceImpl implements UserService {
	@Value("${adminEmailAccount}")
	private String adminEmailAccount;
	@Value("${adminEmailPassword}")
	private String adminEmailPassword;
	@Value("${adminEmailSMTPHost}")
	private String adminEmailSMTPHost;
	
	
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	
	@Transactional(readOnly=true)
	@Override
	public User login(String email, String password) {
		logger.info("login方法 被调用，用户邮箱是"+email);
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

	@Override
	public boolean sendActivationEmail(String email, String password) {
		boolean b = userMapper.exist(email);
		if(b) {
			return false;
		}
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setNickname("customer");
		user.setInterest("所有");
		user.setFace("default.jpg");
		user.setLevel(-1);//等级为-1代表未激活
		user.setExp(0);
		user.setPoints(0);
		user.setMoney(0);
		userMapper.save(user);

		User user2 = userMapper.find(email, password);
		
		
		
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", adminEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log

        // 3. 创建一封邮件
        String content="请点击链接激活：http://127.0.0.1:8011/tickets/user/activation?uid="+user2.getUserid();
        MimeMessage message = null;
		try {
			message = createMimeMessage(session,
					adminEmailAccount,
					"Tickets管理员",
					"用户",
					"请激活您的Tickets帐户",
					content,
					email);

	        // 4. 根据 Session 获取邮件传输对象
	        Transport transport = session.getTransport();

	        // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
	        transport.connect(adminEmailAccount, adminEmailPassword);

	        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
	        transport.sendMessage(message, message.getAllRecipients());

	        // 7. 关闭连接
	        transport.close();
	        return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean activationAccount(Integer userid) {
		User user = userMapper.findById(userid);
		if(user.getLevel()!=-1) {
			return false;
		}
		user.setLevel(1);//激活
		userMapper.update(user);
		return true;
	}



}
