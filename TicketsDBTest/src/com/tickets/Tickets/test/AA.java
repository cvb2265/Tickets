package com.tickets.Tickets.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class AA {

	public static void main(String[] args) {
		DBHelper dbHelper = new DBHelper();
		dbHelper.setDbdriver("com.mysql.jdbc.Driver");
		dbHelper.setDburl("jdbc:mysql://localhost:3306/concerttickets");
		dbHelper.setDbusername("root");
		dbHelper.setDbpassword("adf153");
		Connection conn = null;
		try {
			System.out.println("插入seat数据");
			conn = dbHelper.getConnection();
			f1(conn);
			
			System.out.println("插入plan数据");
			conn = dbHelper.getConnection();
			f2(conn,1,"罗志祥2018 疯狂世界巡回演唱会南京站", "2018-05-23 19:00:00", "2018-05-23 23:00:00", "2016年，罗志祥带着第11张个人大碟《真人秀》震撼歌坛；综艺节目《极限挑战》“极限三精”之一形象深入人心，收视率不断高涨；参演的电影《美人鱼》创华语片票房记录。音乐、影视、综艺圈多栖发展，遍地开花。音乐、舞蹈是初心，Crazy World疯狂世界携#精舞门#震撼来袭;罗志祥全新个唱《Crazy World疯狂世界》带着满满诚意，耗斥大量人力、物力和心血震撼来袭！值得一提的是，此次演唱会，罗志祥亲自上阵担当副导演一职。或许是受与周星驰星爷共事拍电影的影响，小猪罗志祥立志向星爷看齐，首先将自己的导演梦植入到了最爱的音乐巡演中",
					"1.jpg", "南京", 1, false, true, "流行", "aaa");
			conn = dbHelper.getConnection();
			f2(conn,2,"2018杨宗纬 “声声声声”VOCAL 巡唱PLUS南京站", "2018-05-24 19:00:00", "2018-05-24 23:00:00", "从2017年到2018年，杨宗纬不愧为华语乐坛OST之王的称号，他陆续发表了《三生三世十里桃花》的主题曲《凉凉》，《欢乐颂2》的插曲《天已黑》，以及近期大热上映的电影《闪光少女》的微光旗舰曲《生命被你照亮》，还有将周华健大哥的经典名作《难念的经》改编的国语版《天龙八部》等等。2018杨宗纬 “声声声声”VOCAL巡唱 PLUS全新启动，将会在本次巡演中演唱这些大热单曲，值得观众格外期待。",
					"2.jpg", "南京", 2, false, true, "流行", "aaa");
			conn = dbHelper.getConnection();
			f2(conn,3,"2018崔子格影视金曲演唱会南京站", "2018-05-25 19:00:00", "2018-05-25 23:00:00", "崔子格，6月25日出生于新疆，中国内地女歌手。2012年4月推出首张个人专辑《老婆最大》，7月推出EP专辑《好男人都死哪儿去了》；2013年1月《天字女一号》实体专辑全国首，7月25日发布单曲《小心小心》，7月25日发布毕业单曲《再见亲爱的》，10月20日发布同夏天Alex合唱的《不再联系》；2014年1月12日在壹空间举办\\\"独具一格\\\"崔子格和她的小伙伴们演唱会；2015年1月7日在北京专辑《爱情大师》发布会，1月31日参加电影《喜羊羊与灰太狼之羊年喜羊羊》并献唱主题曲；2016年1月6日发行电视剧《太子妃升职记》主题歌《可念不可说》，1月14日《卜卦》获得繁星盛典十大金曲奖，1月26日被邀电影《过年好》盛大首映典礼，1月28日《可念不可说》荣获最佳催泪主题曲奖。",
					"3.jpg", "南京", 1, false, true, "流行", "aaa");
			conn = dbHelper.getConnection();
			f2(conn,4,"久石让&宫崎骏动漫作品视听交响音乐会南京站", "2018-05-26 19:00:00", "2018-05-26 23:00:00", "倾听经典旋律，感受震撼原版，追忆永不磨灭的幸福快乐！久石让，电影配乐大师，获得日本电影金像奖最 佳音乐奖，被誉为“东方威廉姆斯”，他的音乐总是充满梦幻色彩，给听众充分的想象空间。宫崎骏，动画电影导演，奥斯卡终身成就奖，迪斯尼称其为“动画界的黑泽明”。数十首浪漫又气势磅礴的交响曲，搭配高清大屏的精彩电影画面，演绎完整的视听交响音乐会。",
					"4.jpg", "南京", 2, false, true, "流行", "aaa");
			conn = dbHelper.getConnection();
			f2(conn,5,"比利时钢琴家尼古拉斯·康德钢琴音乐会南京站", "2018-05-27 19:00:00", "2018-05-27 23:00:00", "尼古拉斯·康德出生于一个钢琴世家，在安特卫普音乐学院跟随他的父母海蒂·亨德克斯和莱万特·康德学习，随后他在阿姆斯特丹音乐学院师从于简·维京教授。此后他在慕尼黑音乐和表演艺术大学和菲耶索莱音乐学院随伊丽索·薇莎拉丝学习。同时，他曾受到德米特里·巴什基洛夫、阿尔多·奇科利尼、穆雷·帕拉希亚、德米特里·阿列克谢耶夫和拉杜·卢普等多位大师的指导。",
					"5.jpg", "南京", 1, false, true, "流行", "aaa");
			conn = dbHelper.getConnection();
			f2(conn,6,"千与千寻——久石让·宫崎骏经典作品视听音乐会南京站", "2018-05-28 19:00:00", "2018-05-28 23:00:00", "久石让，中国年轻一代的动漫迷们都不陌生，日本著名的作曲家，指挥家，钢琴演奏家，电影配乐大师。久石让的音乐，有一种能勾起心底最纯真的力量，被人们称为触动灵魂的乐者。宫崎骏，日本著名的动漫电影导演。宫崎骏创作的动漫电影正是由于久石让的配乐，才使得银幕上那一组组虚幻的视听空间，散发出迷人的光彩！",
					"6.jpg", "南京", 2, false, true, "流行", "aaa");
			/*f2(conn,2,"", "2018-05-30 19:00:00", "2018-05-30 23:00:00", "",
					"1.jpg", "南京", 1, false, true, "流行", "aaa");*/
			


			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void f1(Connection connection) {
		PreparedStatement pstmt = null;
		
		String sql = "INSERT into seat(id, venueid, x, y) VALUES (?,?,?,?)";
		

		try {
			int id=1;
			for(int venueid=1;venueid<3;venueid++) {
				for(int x=1;x<21;x++) {
					for(int y=1;y<21;y++) {
						pstmt = (PreparedStatement) connection.prepareStatement(sql);
						pstmt.setInt(1, id);
						pstmt.setInt(2, venueid);
						pstmt.setInt(3, x);
						pstmt.setInt(4, y);
						pstmt.executeUpdate();
						id++;
					}
				}
			}

			pstmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	public static void f2(Connection connection, int id, String name, String starttime, String endtime,
			String introduction, String cover, String location, int venueid,
			boolean overdue, boolean isrecommend, String type, String scheme) {
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO plan(id, name, starttime, endtime, introduction, cover, location, venueid,\r\n" + 
				"          overdue, isrecommend, type, scheme) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		

		try {
			pstmt = (PreparedStatement) connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, starttime);
			pstmt.setString(4, endtime);
			pstmt.setString(5, introduction);
			pstmt.setString(6, cover);
			pstmt.setString(7, location);
			pstmt.setInt(8, venueid);
			pstmt.setBoolean(9, overdue);
			pstmt.setBoolean(10, isrecommend);
			pstmt.setString(11, type);
			pstmt.setString(12, scheme);
			pstmt.executeUpdate();

			pstmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
