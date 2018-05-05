package com.tickets.Tickets.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tickets.Tickets.entity.Goods;
import com.tickets.Tickets.entity.Level;
import com.tickets.Tickets.entity.Notice;
import com.tickets.Tickets.entity.Order;
import com.tickets.Tickets.entity.Plan;
import com.tickets.Tickets.entity.Promulgator;
import com.tickets.Tickets.entity.Seatprice;
import com.tickets.Tickets.entity.User;
import com.tickets.Tickets.mapper.GoodsMapper;
import com.tickets.Tickets.mapper.LevelMapper;
import com.tickets.Tickets.mapper.NoticeMapper;
import com.tickets.Tickets.mapper.OrderMapper;
import com.tickets.Tickets.mapper.PlanMapper;
import com.tickets.Tickets.mapper.PromulgatorMapper;
import com.tickets.Tickets.mapper.SeatpriceMapper;
import com.tickets.Tickets.mapper.UserMapper;

/**
 * 定时任务
 * @author tqy
 * @date 2018年5月5日
 * 
 */
@Component
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class TimerTask {
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
	@Autowired
	@Qualifier("promulgatorMapper")
	private PromulgatorMapper promulgatorMapper;

	
	//打印日志
	private static final Log logger = LogFactory.getLog(TimerTask.class);
	

	/**
	 * 每天00:01启动任务
	 * 将已经支付的订单设为完成
	 */
	@Scheduled(cron = "0 01 00 ? * *")
	public void test1() {
		logger.info("job1 开始执行，将plan设为过期，将order设为完成。");
		Date dt = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
	    String time = sdf.format(dt);
		List<Plan> plans = planMapper.findBeforeAndNotOerdue(time);
		

		List<Level> vls = levelMapper.findAll();
		
		for(int i=0;i<plans.size();i++) {
			plans.get(i).setOverdue(true);
			planMapper.updateOverdue(plans.get(i));
			
			//更新order_表使已经支付的订单state变成已经完成，这里遍历gaiplan的seatprice
			Long pid = plans.get(i).getId();
			List<Seatprice> sps = seatpriceMapper.findByPlanid(pid);
			for(int j=0;j<sps.size();j++) {
				if(sps.get(j).getOrderid()!=null) {
					Long orderid = sps.get(j).getOrderid();
					Order order = orderMapper.findByOrderid(orderid);
					if(order.getState().equals("paid")) {
						order.setState("finished");
						orderMapper.update(order);
						
						//持有该订单的用户获得经验和积分
						User user = userMapper.findById(order.getUserid());
						user.setPoints(user.getPoints()+(int)order.getMoney());
						
						int oldexp=user.getExp();
						int lv=user.getLevel();
						for(int r=0;r<vls.size();r++) {
							if(vls.get(r).getLevel_num()==lv) {
								if(vls.get(r).getMaxexp()!=-1) {
									int newexp = oldexp+(int)order.getMoney();
									
									//假如连续升级
									int y=r;
									int l=user.getLevel();
									while(newexp>=vls.get(y).getMaxexp()&& vls.get(y).getMaxexp()!=-1) {
										l++;
										newexp=newexp-vls.get(y).getMaxexp();
										y++;
									}
									user.setLevel(l);
									user.setExp(newexp);
								}
								break;
							}
						}
						userMapper.update(user);
						

						//发布者获得钱
						Promulgator promulgator = promulgatorMapper.findById(plans.get(i).getPromulgatorid());
						promulgator.setMoney(promulgator.getMoney()+order.getRmoney());
						promulgatorMapper.update(promulgator);
						
						//发送系统消息
						Notice notice = new Notice();
						notice.setUserid(order.getUserid());
					    Date dt_n = new Date();
					    String time_n = sdf.format(dt_n);
						notice.setTime(time_n);
						notice.setTitle("您的订单已经完成");
						notice.setContent("您于"+order.getTime().substring(0, 19)+"下的订单已经完成！");
						notice.setRead(false);
						noticeMapper.save(notice);
					}
				}
			}
			
			
			//更新order_表使已经支付的订单state变成已经完成，这里遍历gaiplan的goods
			List<Goods> goodses = goodsMapper.findByPlanid(pid);
			for(int j=0;j<goodses.size();j++) {
				if(goodses.get(j).getOrderid()!=null) {
					Long orderid = goodses.get(j).getOrderid();
					Order order = orderMapper.findByOrderid(orderid);
					if(order.getState().equals("paid")) {
						order.setState("finished");
						orderMapper.update(order);
						
						//持有该订单的用户获得经验和积分
						User user = userMapper.findById(order.getUserid());
						user.setPoints(user.getPoints()+(int)order.getMoney());
						
						int oldexp=user.getExp();
						int lv=user.getLevel();
						for(int r=0;r<vls.size();r++) {
							if(vls.get(r).getLevel_num()==lv) {
								if(vls.get(r).getMaxexp()!=-1) {
									int newexp = oldexp+(int)order.getMoney();
									
									//假如连续升级
									int y=r;
									int l=user.getLevel();
									while(newexp>=vls.get(y).getMaxexp()&& vls.get(y).getMaxexp()!=-1) {
										l++;
										newexp=newexp-vls.get(y).getMaxexp();
										y++;
									}
									user.setLevel(l);
									user.setExp(newexp);
								}
								break;
							}
						}
						userMapper.update(user);
						

						//发布者获得钱
						Promulgator promulgator = promulgatorMapper.findById(plans.get(i).getPromulgatorid());
						promulgator.setMoney(promulgator.getMoney()+order.getRmoney());
						promulgatorMapper.update(promulgator);
						
						//发送系统消息
						Notice notice = new Notice();
						notice.setUserid(order.getUserid());
					    Date dt_n = new Date();
					    String time_n = sdf.format(dt_n);
						notice.setTime(time_n);
						notice.setTitle("您的订单已经完成");
						notice.setContent("您于"+order.getTime().substring(0, 19)+"下的订单已经完成！");
						notice.setRead(false);
						noticeMapper.save(notice);
					}
				}
			}
			
			
		}
	}
	
	/**
	 * 每15分钟执行一次
	 * 将15分钟内未支付的订单删除
	 */
	@Scheduled(cron = "0 0/15 * * * ?")
	public void test2() {
		logger.info("job2 开始执行，将超过15分钟未支付的order自动取消。");
		Date dt = new Date();
		dt.setTime(dt.getTime() - 15*60*1000);
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
	    String time = sdf.format(dt);
		List<Order> os = orderMapper.findUnpaidOrdersBefore(time);
		for(Order o:os) {
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
			if(o.getPoints_cost()!=0) {
				User user = userMapper.findById(o.getUserid());
				int p = user.getPoints();
				user.setPoints( p + o.getPoints_cost() );
				userMapper.update(user);
			}
			
			//发送系统消息
			Notice notice = new Notice();
			notice.setUserid(o.getUserid());
		    Date dt_n = new Date();
		    String time_n = sdf.format(dt_n);
			notice.setTime(time_n);
			notice.setTitle("您的订单已经取消");
			notice.setContent("您于"+o.getTime().substring(0, 19)+"下的订单已经取消！");
			notice.setRead(false);
			noticeMapper.save(notice);
		}
	}
	
}
