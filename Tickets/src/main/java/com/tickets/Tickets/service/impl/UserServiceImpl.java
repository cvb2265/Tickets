package com.tickets.Tickets.service.impl;

import com.tickets.Tickets.entity.Goods;
import com.tickets.Tickets.entity.Level;
import com.tickets.Tickets.entity.Order;
import com.tickets.Tickets.entity.Seatprice;
import com.tickets.Tickets.entity.User;
import com.tickets.Tickets.mapper.GoodsMapper;
import com.tickets.Tickets.mapper.LevelMapper;
import com.tickets.Tickets.mapper.OrderMapper;
import com.tickets.Tickets.mapper.SeatpriceMapper;
import com.tickets.Tickets.mapper.UserMapper;
import com.tickets.Tickets.service.UserService;
import com.tickets.Tickets.util.ResultMessage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
	@Autowired
	@Qualifier("orderMapper")
	private OrderMapper orderMapper;
	@Autowired
	@Qualifier("seatpriceMapper")
	private SeatpriceMapper seatpriceMapper;
	@Autowired
	@Qualifier("goodsMapper")
	private GoodsMapper goodsMapper;
	@Autowired
	@Qualifier("levelMapper")
	private LevelMapper levelMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	
	@Transactional(readOnly=true)
	@Override
	public User login(String email, String password) {
		logger.info("login方法 被调用，用户邮箱是"+email);
		return userMapper.find(email, password);
	}
	
	@Transactional(readOnly=true)
	@Override
	public User getById(Long userid) {
		logger.info("getById方法 被调用，用户id是"+userid);
		return userMapper.findById(userid);
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
	public boolean activationAccount(Long userid) {
		User user = userMapper.findById(userid);
		if(user.getLevel()!=-1) {
			return false;
		}
		user.setLevel(1);//激活
		userMapper.update(user);
		return true;
	}


	@Override
	public synchronized ResultMessage createSeatpriceOrder(Long userid, String spids, Integer points_cost) {
		logger.info("createSeatpriceOrder方法 被调用");
		ResultMessage rm = new ResultMessage();
		double money = 0.0;

		//先检查座位是否已经被预订
		List<Seatprice> ls = new ArrayList<Seatprice>();
		String[] ss = spids.split("-");
		for(int i=0;i<ss.length;i++) {
			Seatprice sp = seatpriceMapper.findById(Long.parseLong(ss[i]));
			if(!sp.isAvail()) {
				rm.setResult(false);
				rm.setMessage("座位已经被预订，请重新预订！");
				return rm;
			}
			money += sp.getPrice();
			ls.add(sp);
		}
		
		//一场音乐会每人最多买两张票，检查之前有没有预定过票
		long spcount = seatpriceMapper.getSPCountByPlanidAndUserid(ls.get(0).getPlanid(), userid);
		if(spcount + ss.length > 2) {
			rm.setResult(false);
			rm.setMessage("一场音乐会每人最多买两张票，票数超出限制！");
			return rm;
		}
		

		//更新user表，扣除积分
		User u = userMapper.findById(userid);
		if(points_cost!=0) {
			if(u.getPoints()<points_cost) {//积分不够，失败
				rm.setResult(false);
				rm.setMessage("积分不足，预订失败！");
				return rm;
			}
			u.setPoints(u.getPoints() - points_cost);
			userMapper.update(u);
		}
		
		
		//增加order记录
		Order order = new Order();
		order.setUserid(userid);
	    Date dt = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
	    String time = sdf.format(dt);
		order.setTime(time);
		order.setMoney(money);
		order.setPoints_cost(points_cost);
		Level level = levelMapper.findByLevel_num(u.getLevel());
		System.out.println(level.getDiscount());
		double perc=level.getDiscount();
		if(points_cost==100) {
			double d = 0.01; perc-=d;
		}else if(points_cost==200) {
			double d = 0.02; perc-=d;
		}else if(points_cost==300) {
			double d = 0.03; perc-=d;
		}else if(points_cost==400) {
			double d = 0.04; perc-=d;
		}else if(points_cost==500) {
			double d = 0.05; perc-=d;
		}
		order.setPerc(perc);
		order.setRmoney(money*perc);
		order.setState("unpaid");
		orderMapper.save(order);
		
		
		//更新seatprice表
		long orderid = orderMapper.getOrderid(userid, time);
		for(int i=0;i<ls.size();i++) {
			ls.get(i).setAvail(false);
			ls.get(i).setOrderid(orderid);
			seatpriceMapper.update(ls.get(i));
		}
		

		rm.setResult(true);
		return rm;
	}
	
	
	@Override
	public synchronized ResultMessage createGoodsOrder(Long userid, Long goodsid) {
		logger.info("createGoodsOrder方法 被调用");
		ResultMessage rm = new ResultMessage();

		//先检查goods是否已经被预订
		Goods goods = goodsMapper.findById(goodsid);
		if(goods==null) {
			rm.setResult(false);
			rm.setMessage("没有这个周边产品！");
			return rm;
		}
		if(goods.getOrderid()!=null) {
			rm.setResult(false);
			rm.setMessage("周边产品已经被预订！");
			return rm;
		}
		
		//一场音乐会每人最多买一个周边产品，检查之前有没有预定过周边产品
		long  goodscount = goodsMapper.getGoodsCountByPlanidAndUserid(goods.getPlanid(), userid);
		if(goodscount > 0) {
			rm.setResult(false);
			rm.setMessage("一场音乐会每人最多买一个周边产品，不可再购买！");
			return rm;
		}
		

		//更新user表，扣除积分
		User u = userMapper.findById(userid);
		
		
		//增加order记录
		Order order = new Order();
		order.setUserid(userid);
	    Date dt = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
	    String time = sdf.format(dt);
		order.setTime(time);
		order.setMoney(goods.getPrice());
		order.setPoints_cost(0);
		Level level = levelMapper.findByLevel_num(u.getLevel());
		System.out.println(level.getDiscount());
		double perc=level.getDiscount();
		order.setPerc(perc);
		order.setRmoney(goods.getPrice()*perc);
		order.setState("unpaid");
		orderMapper.save(order);
		
		
		//更新goods表
		long orderid = orderMapper.getOrderid(userid, time);
		goods.setOrderid(orderid);
		goodsMapper.update(goods);
		

		rm.setResult(true);
		return rm;
	}



}
