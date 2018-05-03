package com.tickets.Tickets.service.impl;

import com.tickets.Tickets.entity.Goods;
import com.tickets.Tickets.entity.Level;
import com.tickets.Tickets.entity.Notice;
import com.tickets.Tickets.entity.Order;
import com.tickets.Tickets.entity.Plan;
import com.tickets.Tickets.entity.Seatprice;
import com.tickets.Tickets.entity.User;
import com.tickets.Tickets.mapper.GoodsMapper;
import com.tickets.Tickets.mapper.LevelMapper;
import com.tickets.Tickets.mapper.NoticeMapper;
import com.tickets.Tickets.mapper.OrderMapper;
import com.tickets.Tickets.mapper.PlanMapper;
import com.tickets.Tickets.mapper.SeatpriceMapper;
import com.tickets.Tickets.mapper.UserMapper;
import com.tickets.Tickets.service.UserService;
import com.tickets.Tickets.util.ResultMessage;

import java.text.ParseException;
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
	@Autowired
	@Qualifier("planMapper")
	private PlanMapper planMapper;
	@Autowired
	@Qualifier("noticeMapper")
	private NoticeMapper noticeMapper;

	
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
		
		//发送系统消息
		Notice notice = new Notice();
		notice.setUserid(userid);
	    Date dt = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
	    String time = sdf.format(dt);
		notice.setTime(time);
		notice.setTitle("欢迎注册Tickets账号");
		notice.setContent("Tickets欢迎您加入！Tickets是一家音乐会在线售票网站。在这里，每天都会发布音乐会信息，为您提供全国近期演出信息，包括演唱会、音乐会、歌舞会等众多演出活动，并且提供24小时票务网上在线预订！多逛逛Tickets心情就会好很多！");
		notice.setRead(false);
		noticeMapper.save(notice);
		return true;
	}


	@Override
	public synchronized ResultMessage createSeatpriceOrder(Long userid, String spids, Integer points_cost) {
		logger.info("createSeatpriceOrder方法 被调用");
		ResultMessage rm = new ResultMessage();
		double money = 0.0;

		//先检查座位是否已经被预订，以及plan是否过期
		List<Seatprice> ls = new ArrayList<Seatprice>();
		String[] ss = spids.split("-");
		for(int i=0;i<ss.length;i++) {
			Seatprice sp = seatpriceMapper.findById(Long.parseLong(ss[i]));
			if(i==0) {
				Plan plan = planMapper.findById(sp.getPlanid());
				if(plan.isOverdue()) {//如果过期了
					rm.setResult(false);
					rm.setMessage("音乐会已经过期！");
					return rm;
				}
			}
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

		//先检查goods是否已经被预订，以及plan是否过期
		Goods goods = goodsMapper.findById(goodsid);
		if(goods==null) {
			rm.setResult(false);
			rm.setMessage("没有这个周边产品！");
			return rm;
		}
		if(!goods.isAvail()) {
			rm.setResult(false);
			rm.setMessage("周边产品已经被预订！");
			return rm;
		}
		Plan plan = planMapper.findById(goods.getPlanid());
		if(plan.isOverdue()) {//如果过期了
			rm.setResult(false);
			rm.setMessage("音乐会已经过期！");
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
		goods.setAvail(false);
		goodsMapper.update(goods);
		

		rm.setResult(true);
		return rm;
	}

	
	@Override
	public ResultMessage payOrder(Long userid, Long orderid) {
		logger.info("payOrder方法 被调用");
		ResultMessage rm = new ResultMessage();
		
		Order o = orderMapper.findByOrderid(orderid);
		if(!o.getUserid().equals(userid)) {
			rm.setResult(false);
			rm.setMessage("非本人操作，操作失败！");
			return rm;
		}

		//先验证订单是否超过15分钟
		Date dt = new Date();
		dt.setTime(dt.getTime() - 15*60*1000);
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date dt2 = null;
		try {
			dt2 = sdf.parse(o.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(dt.after(dt2)) {
			//删除order
			orderMapper.deleteByOrderid(o.getOrderid());
			
			
			//更新seatprice或者goods表，看订单是买了seatprice还是goods
			List<Seatprice> sps = seatpriceMapper.findByOrderid(o.getOrderid());
			if(sps.size()!=0) {//证明买的是seatprice
				for(int i=0;i<sps.size();i++) {
					sps.get(i).setAvail(true);
					sps.get(i).setOrderid(null);
					seatpriceMapper.update(sps.get(i));
				}
			}else {
				Goods goods = goodsMapper.findByOrderid(o.getOrderid());
				goods.setAvail(true);
				goods.setOrderid(null);
				goodsMapper.update(goods);
			}
			
			//更新user表，返还积分
			User user = userMapper.findById(o.getUserid());
			int p = user.getPoints();
			user.setPoints( p + o.getPoints_cost() );
			userMapper.update(user);
			
			//发送系统消息
			Notice notice = new Notice();
			notice.setUserid(userid);
		    Date dt_n = new Date(); 
		    String time_n = sdf.format(dt_n);
			notice.setTime(time_n);
			notice.setTitle("您的订单已经取消");
			notice.setContent("您于"+o.getTime().substring(0, 19)+"下的订单已经取消！");
			notice.setRead(false);
			noticeMapper.save(notice);
			
			rm.setResult(false);
			rm.setMessage("未在15分钟内支付，订单自动取消！");
			return rm;
		}
		
		
		//再验证钱是否足够
		User user = userMapper.findById(userid);
		if(user.getMoney()<o.getRmoney()) {
			rm.setResult(false);
			rm.setMessage("余额不足，请充值！");
			return rm;
		}
		
		//修改order
		o.setState("paid");
		orderMapper.update(o);
		
		
		//更新user，扣除余额
		double m = user.getMoney();
		user.setMoney( m - o.getRmoney() );
		userMapper.update(user);
		
		
		rm.setResult(true);
		return rm;
	}

	@Override
	public ResultMessage cancelOrder(Long userid, Long orderid) {
		logger.info("cancelOrder方法 被调用");
		ResultMessage rm = new ResultMessage();
		
		Order o = orderMapper.findByOrderid(orderid);
		if(!o.getUserid().equals(userid)) {
			rm.setResult(false);
			rm.setMessage("非本人操作，操作失败！");
			return rm;
		}
		
		//删除order
		orderMapper.deleteByOrderid(o.getOrderid());
		
		
		//更新seatprice或者goods表，看订单是买了seatprice还是goods
		List<Seatprice> sps = seatpriceMapper.findByOrderid(o.getOrderid());
		if(sps.size()!=0) {//证明买的是seatprice
			for(int i=0;i<sps.size();i++) {
				sps.get(i).setAvail(true);
				sps.get(i).setOrderid(null);
				seatpriceMapper.update(sps.get(i));
			}
		}else {
			Goods goods = goodsMapper.findByOrderid(o.getOrderid());
			goods.setAvail(true);
			goods.setOrderid(null);
			goodsMapper.update(goods);
		}
		
		//更新user表，返还积分
		User user = userMapper.findById(o.getUserid());
		int p = user.getPoints();
		user.setPoints( p + o.getPoints_cost() );
		userMapper.update(user);
		
		//发送系统消息
		Notice notice = new Notice();
		notice.setUserid(userid);
	    Date dt_n = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
	    String time_n = sdf.format(dt_n);
		notice.setTime(time_n);
		notice.setTitle("您的订单已经取消");
		notice.setContent("您于"+o.getTime().substring(0, 19)+"下的订单已经取消！");
		notice.setRead(false);
		noticeMapper.save(notice);
		
		rm.setResult(true);
		return rm;
	}

	@Override
	public ResultMessage unsubscribeOrder(Long userid, Long orderid) {
		logger.info("unsubscribeOrder方法 被调用");
		ResultMessage rm = new ResultMessage();
		
		Order o = orderMapper.findByOrderid(orderid);
		if(!o.getUserid().equals(userid)) {
			rm.setResult(false);
			rm.setMessage("非本人操作，操作失败！");
			return rm;
		}

		List<Seatprice> sps = seatpriceMapper.findByOrderid(orderid);
		Goods goods = null;
		Long pid = null;
		if(sps.size()!=0) {//证明买的是seatprice
			pid = sps.get(0).getPlanid();
		}else {
			goods = goodsMapper.findByOrderid(o.getOrderid());
			pid = goods.getPlanid();
		}
		
		Plan plan = planMapper.findById(pid);
		//计算距离演出开始的时间
		Date now = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d2 = null;
		try {
			d2 = sdf.parse(plan.getStarttime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int f = 6;
		double perc = 1.0;
		long diff = d2.getTime() - now.getTime();//相差的毫秒数
		if(diff<=86400000) {//小于等于1天，订单不能退订
			//handleOverduePlan();
			rm.setResult(false);
			rm.setMessage("距离演出开始不足1天，不可退票！");
			return rm;
		}else if(86400000<diff && diff <=2*86400000) {//小于等于2天且大于1天
			f=2;
			perc = 0.6;
		}else if(2*86400000<diff && diff <=3*86400000) {//小于等于3天且大于2天
			f=3;
			perc = 0.7;
		}else if(3*86400000<diff && diff <=4*86400000) {//小于等于4天且大于3天
			f=4;
			perc = 0.8;
		}else if(4*86400000<diff && diff <=5*86400000) {//小于等于5天且大于4天
			f=5;
			perc = 0.9;
		}else if(5*86400000<diff) {//大于5天
			f=6;
			perc = 1.0;
		}
		
		
		
		//删除order
		orderMapper.deleteByOrderid(orderid);
		

		//更新seatprice或者goods表，看订单是买了seatprice还是goods
		if(sps.size()!=0) {//证明买的是seatprice
			for(int i=0;i<sps.size();i++) {
				sps.get(i).setAvail(true);
				sps.get(i).setOrderid(null);
				seatpriceMapper.update(sps.get(i));
			}
		}else {
			goods.setAvail(true);
			goods.setOrderid(null);
			goodsMapper.update(goods);
		}
		
		
		//更新user表，返还积分和金额
		User user = userMapper.findById(o.getUserid());
		int p = user.getPoints();
		user.setPoints( p + o.getPoints_cost() );
		double mon = user.getMoney();
		user.setMoney( mon + o.getRmoney()*perc );
		userMapper.update(user);
		

		//经理获得收益
//		if(f!=6) {
//			Manager manager = managerMapper.findById(1);
//			manager.setMoney(manager.getMoney()+o.getRmoney()*(1.0-perc));
//			managerMapper.updateMoney(manager);
//		}
		

		rm.setResult(true);
		if(f==2) {
			rm.setMessage("根据距离演出的时间，退还60%的金额给您！");
		}else if(f==3) {
			rm.setMessage("根据距离演出的时间，退还70%的金额给您！");
		}else if(f==4) {
			rm.setMessage("根据距离演出的时间，退还80%的金额给您！");
		}else if(f==5) {
			rm.setMessage("根据距离演出的时间，退还90%的金额给您！");
		}else if(f==6) {
			rm.setMessage("根据距离演出的时间，退还100%的金额给您！");
		}
		return rm;
	}



}
