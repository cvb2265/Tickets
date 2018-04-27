DROP DATABASE IF EXISTS concerttickets ;
CREATE DATABASE concerttickets default charset=utf8 ;
USE concerttickets;

#tqy
CREATE TABLE user(
   userid			bigint			PRIMARY KEY		AUTO_INCREMENT,
   email			VARCHAR(20)	NOT NULL	unique,
   password			VARCHAR(20)	NOT NULL,
   nickname			VARCHAR(20)	NOT NULL,
   interest			VARCHAR(60)	NOT NULL,
   face				VARCHAR(60)	NOT NULL,		#头像地址
   level			INT(11)			NOT NULL,	#会员等级
   exp				INT(11)			NOT NULL,	#当前等级经验
   points			INT(11)			NOT NULL,	#会员积分
   money			double			NOT NULL	#当前账号余额
) ;
CREATE TABLE order_(
   orderid			bigint			PRIMARY KEY		AUTO_INCREMENT,
   userid			bigint			NOT NULL,
   time				datetime		NOT NULL,
   money			double			NOT NULL,	#原价
   points_cost		INT(11)			NOT NULL,	#花费的积分
   perc				double			NOT NULL,	#折扣
   rmoney			double			NOT NULL,	#真实价格
   state			VARCHAR(14)		NOT NULL	#unpaid,paid,finished，分别可取消、可退订、不可操作
) ;
INSERT INTO `user` (`userid`, `email`, `password`, `nickname`, `interest`, `face`, `level`, `exp`, `points`, `money`) VALUES
(1, '123@qq.com', '123', 'jack', '流行-古典', '1.jpg', 1, 0, 0, 9999),
(2, '124@qq.com', '124', 'bob', '流行-古典-摇滚', '2.jpg', 2, 0, 0, 9999);

INSERT INTO `order_` VALUES
(1, 1, "2018-04-26 12:12:21", 100, 0, 1, 100, "paid"),
(2, 1, "2018-04-26 12:12:22", 100, 0, 1, 100, "paid");


#chenfei
CREATE TABLE `venue` (
   `id`			bigint			PRIMARY KEY		AUTO_INCREMENT,
   `city`		varchar(20)		NOT NULL,
   `address`		varchar(60)		NOT NULL,
   `name`		varchar(20)		NOT NULL
) ;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (1, "南京", "玄武区洪武北路123号苏苑大厦15-16层", "江苏省歌舞剧院") ;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (2, "北京", "海淀区复兴路69号", "凯迪拉克中心") ;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (3, "上海", "静安区延安中路1000号2164室", "上海展览中心") ;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (4, "广州", "越秀区人民北路696号", "广州友谊剧院") ;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (5, "深圳", "龙岗区龙翔大道3001号", "深圳大运中心体育馆") ;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (6, "杭州", "江干区钱潮路12号", "江干体育中心") ;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (7, "武汉", "汉阳区知音大道7号", "武汉琴台大剧院") ;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (8, "长沙", "开福区会展路1号", "湖南国际会展中心") ;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (9, "大连", "甘井子区岚岭路699号", "大连体育中心体育场") ;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (10, "宁波", "鄞州区中山东路1999号", "宁波文化广场万人广场") ;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (11, "青岛", "市南区太平路9号", "青岛市人民会堂") ;
CREATE TABLE `seat` (
   `id`			bigint			PRIMARY KEY		AUTO_INCREMENT,
   `venueid`		INT(11)			NOT NULL,
   `x`			int(11)			NOT NULL,
   `y`			int(11)			NOT NULL
) ;
CREATE TABLE level(
   id			bigint			PRIMARY KEY		AUTO_INCREMENT,
   level_num			INT(11)			NOT NULL	unique,
   maxexp			INT(11)			NOT NULL,			#升级所需经验
   discount			double			NOT NULL			#折扣
) ;
INSERT INTO level VALUES (1, 1, 50, 1.00) ;
INSERT INTO level VALUES (2, 2, 200,  0.99) ;
INSERT INTO level VALUES (3, 3, 350,  0.98) ;
INSERT INTO level VALUES (4, 4, 500,  0.97) ;
INSERT INTO level VALUES (5, 5, 650,  0.96) ;
INSERT INTO level VALUES (6, 6, 800,  0.95) ;
INSERT INTO level VALUES (7, 7, 950,  0.93) ;
INSERT INTO level VALUES (8, 8, 1100,  0.9) ;
CREATE TABLE `notice`(
   `id`			bigint		PRIMARY KEY		AUTO_INCREMENT,
   `userid`		bigint			NOT NULL,
   `time`		datetime		NOT NULL,
   `title`		varchar(80)		NOT NULL,
   `content`		varchar(900)		NOT NULL,
   `read`		boolean			NOT NULL	#是否已读
) ;
INSERT INTO `notice` VALUES (1, 1, "2018-04-26 12:12:12", "欢迎注册Tickets账号", "Tickets欢迎您！", false) ;
INSERT INTO `notice` VALUES (2, 1, "2018-04-26 12:12:13", "欢迎注册Tickets账号", "Tickets欢迎您！", false) ;
INSERT INTO `notice` VALUES (3, 1, "2018-04-26 12:12:14", "欢迎注册Tickets账号", "Tickets欢迎您！", false) ;
INSERT INTO `notice` VALUES (4, 1, "2018-04-26 12:12:15", "欢迎注册Tickets账号", "Tickets欢迎您！", false) ;
INSERT INTO `notice` VALUES (5, 1, "2018-04-26 12:12:16", "欢迎注册Tickets账号", "Tickets欢迎您！", false) ;
INSERT INTO `notice` VALUES (6, 1, "2018-04-26 12:12:17", "欢迎注册Tickets账号", "Tickets欢迎您！", false) ;
INSERT INTO `notice` VALUES (7, 1, "2018-04-26 12:12:18", "欢迎注册Tickets账号", "Tickets欢迎您！", false) ;
INSERT INTO `notice` VALUES (8, 1, "2018-04-26 12:12:19", "欢迎注册Tickets账号", "Tickets欢迎您！", false) ;
INSERT INTO `notice` VALUES (9, 1, "2018-04-26 12:12:20", "欢迎注册Tickets账号", "Tickets欢迎您！", false) ;
INSERT INTO `notice` VALUES (10, 1, "2018-04-26 12:12:21", "欢迎注册Tickets账号", "Tickets欢迎您！", false) ;
INSERT INTO `notice` VALUES (11, 1, "2018-04-26 12:12:22", "欢迎注册Tickets账号", "Tickets欢迎您！", false) ;




#wanglei

CREATE TABLE IF NOT EXISTS `promulgator` (
   `id`			bigint			PRIMARY KEY		AUTO_INCREMENT,
  `email` varchar(20) NOT NULL		UNIQUE,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `balance` int(11) NOT NULL DEFAULT '0',
  `power` tinyint(1) NOT NULL DEFAULT '0',
  `head` varchar(20) NOT NULL
);
INSERT INTO `promulgator` (`id`, `email`, `password`, `name`, `balance`, `power`, `head`)
   VALUES (1, "125@qq.com", "125", "南京市城管大队", 333, false, "1.jpg") ;

CREATE TABLE `plan` (
   `id`			bigint			PRIMARY KEY		AUTO_INCREMENT,
   `name`		varchar(60)		NOT NULL,
   `starttime`		datetime		NOT NULL,
   `endtime`		datetime		NOT NULL,
   `introduction`	varchar(900)		NOT NULL,
   `cover`		varchar(20)		NOT NULL,
   `location`		varchar(20)		NOT NULL,
   `venueid`		bigint			NOT NULL,
   `overdue`		tinyint(1)		NOT NULL	DEFAULT '0',
   `isrecommend`	tinyint(1)		NOT NULL	DEFAULT '0',
   `type`		varchar(20)		NOT NULL,
   `scheme`		varchar(20)		NOT NULL
) ;

CREATE TABLE `seatprice` (
   `id`			bigint			PRIMARY KEY		AUTO_INCREMENT,
  `planid` bigint NOT NULL,
  `orderid` bigint DEFAULT NULL,
  `seatid` bigint NOT NULL,
  `venueid` bigint NOT NULL,
   `x`			int(11)			NOT NULL,
   `y`			int(11)			NOT NULL,
  `price` double NOT NULL,
  `avail` tinyint(1) NOT NULL DEFAULT '1'
);

CREATE TABLE IF NOT EXISTS `goods` (
   `id`			bigint			PRIMARY KEY		AUTO_INCREMENT,
  `planid` bigint NOT NULL,
  `goodsname` varchar(20) NOT NULL,
  `introduction` varchar(400) NOT NULL,
  `pic` varchar(30) NOT NULL,
  `price` double NOT NULL,
  `orderid` bigint DEFAULT NULL
);






