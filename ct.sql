DROP DATABASE IF EXISTS concerttickets ;
CREATE DATABASE concerttickets default charset=utf8 ;
USE concerttickets;

#tqy
CREATE TABLE user(
   userid			INT(11)			PRIMARY KEY		AUTO_INCREMENT,
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
   orderid			INT(20)			PRIMARY KEY		AUTO_INCREMENT,
   userid			INT(11)			NOT NULL,
   time				datetime		NOT NULL,
   money			double			NOT NULL,	#原价
   points_cost		INT(11)			NOT NULL,	#花费的积分
   perc				double			NOT NULL,	#折扣
   rmoney			double			NOT NULL,	#真实价格
   state			VARCHAR(14)		NOT NULL	#unpaid,paid,finished，分别可取消、可退订、不可操作
) ;
INSERT INTO `user` (`userid`, `email`, `password`, `nickname`, `interest`, `face`, `level`, `exp`, `points`, `money`) VALUES
(1, '123@qq.com', '123', 'jack', '流行-古典', '123_qq.jpg', 1, 0, 0, 9999),
(2, '124@qq.com', '124', 'bob', '流行-古典-摇滚', '124_qq.jpg', 2, 0, 0, 9999);


#chenfei
CREATE TABLE `venue` (
   `id`			INT(11)			PRIMARY KEY		AUTO_INCREMENT,
   `city`		varchar(20)		NOT NULL,
   `address`		varchar(60)		NOT NULL,
   `name`		varchar(20)		NOT NULL
) ;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (1, "南京", "玄武区洪武北路123号苏苑大厦15-16层", "江苏省歌舞剧院") ;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (2, "南京", "秦淮区延龄巷5号", "江南剧院") ;
CREATE TABLE `seat` (
   `id`			INT(11)			PRIMARY KEY		AUTO_INCREMENT,
   `venueid`		INT(11)			NOT NULL,
   `x`			int(11)			NOT NULL,
   `y`			int(11)			NOT NULL
) ;




#wanglei

CREATE TABLE IF NOT EXISTS `promulgator` (
   `id`			INT(11)			PRIMARY KEY		AUTO_INCREMENT,
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
   `id`			INT(11)			PRIMARY KEY		AUTO_INCREMENT,
   `name`		varchar(60)		NOT NULL,
   `starttime`		datetime		NOT NULL,
   `endtime`		datetime		NOT NULL,
   `introduction`	varchar(900)		NOT NULL,
   `cover`		varchar(20)		NOT NULL,
   `location`		varchar(20)		NOT NULL,
   `venueid`		int(11)			NOT NULL,
   `overdue`		tinyint(1)		NOT NULL	DEFAULT '0',
   `isrecommend`	tinyint(1)		NOT NULL	DEFAULT '0',
   `type`		varchar(20)		NOT NULL,
   `scheme`		varchar(20)		NOT NULL
) ;

CREATE TABLE `seatprice` (
   `id`			INT(11)			PRIMARY KEY		AUTO_INCREMENT,
  `planid` int(11) NOT NULL,
  `orderid` int(11) DEFAULT NULL,
  `seatid` int(11) NOT NULL,
  `venueid` int(11) NOT NULL,
  `price` double NOT NULL,
  `avail` tinyint(1) NOT NULL DEFAULT '1'
);

CREATE TABLE IF NOT EXISTS `goods` (
   `id`			INT(11)			PRIMARY KEY		AUTO_INCREMENT,
  `planid` int(11) NOT NULL,
  `goodsname` varchar(20) NOT NULL,
  `desc` varchar(400) NOT NULL,
  `pic` varchar(30) NOT NULL,
  `price` double NOT NULL,
  `orderid` int(20)
);
INSERT INTO `goods` (`id`, `planid`, `goodsname`, `desc`, `pic`, `price`, `orderid`)
 VALUES (1, 1, "玉石挂坠", "古人讲佩玉为美，黄金有价玉无价。玉埋藏地下几千年或是上亿年，玉中含有大量矿物元素，所以人们常说人养玉玉养人，如果人的身体好长期佩玉可以滋润玉，玉的水头也就是折光度会越来越好，越来越亮。", "1.jpg", 79.5, null) ;
INSERT INTO `goods` (`id`, `planid`, `goodsname`, `desc`, `pic`, `price`, `orderid`)
 VALUES (2, 1, "玉石挂坠", "古人讲佩玉为美，黄金有价玉无价。玉埋藏地下几千年或是上亿年，玉中含有大量矿物元素，所以人们常说人养玉玉养人，如果人的身体好长期佩玉可以滋润玉，玉的水头也就是折光度会越来越好，越来越亮。", "2.jpg", 79.5, null) ;
INSERT INTO `goods` (`id`, `planid`, `goodsname`, `desc`, `pic`, `price`, `orderid`)
 VALUES (3, 1, "玉石挂坠", "古人讲佩玉为美，黄金有价玉无价。玉埋藏地下几千年或是上亿年，玉中含有大量矿物元素，所以人们常说人养玉玉养人，如果人的身体好长期佩玉可以滋润玉，玉的水头也就是折光度会越来越好，越来越亮。", "3.jpg", 79.5, null) ;








