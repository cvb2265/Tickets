
USE concerttickets;


delete from `user`;
INSERT INTO `user` (`userid`, `email`, `password`, `nickname`, `interest`, `face`, `level`, `exp`, `points`, `money`) VALUES
(1, '123@qq.com', '123', 'jack', '流行-古典', '123_qq.jpg', 1, 0, 0, 9999),
(2, '124@qq.com', '124', 'bob', '流行-古典-摇滚', '124_qq.jpg', 2, 0, 0, 9999);



-- balance意义尚不明确
delete from `promulgator`;
INSERT INTO `promulgator` (`id`, `email`, `password`, `name`, `balance`, `power`, `head`)
   VALUES (1, "125@qq.com", "125", "南京市城管大队", 333, false, "1.jpg") ;



delete from `venue`;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (1, "南京", "玄武区洪武北路123号苏苑大厦15-16层", "江苏省歌舞剧院") ;
INSERT INTO `venue` (`id`, `city`, `address`, `name`) VALUES (2, "南京", "秦淮区延龄巷5号", "江南剧院") ;




DROP TABLE IF EXISTS `seat` ;
CREATE TABLE `seat` (
   `id`			INT(11)			PRIMARY KEY		AUTO_INCREMENT,
   `venueid`		INT(11)			NOT NULL,
   `x`			int(11)			NOT NULL,
   `y`			int(11)			NOT NULL
) ;
delete from `seat`;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 1, 1) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 1, 2) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 1, 3) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 1, 4) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 1, 5) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 1, 6) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 1, 7) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 1, 8) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 1, 9) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 1, 10) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 2, 1) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 2, 2) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 2, 3) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 2, 4) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 2, 5) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 2, 6) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 2, 7) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 2, 8) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 2, 9) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 2, 10) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 3, 1) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 3, 2) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 3, 3) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 3, 4) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 3, 5) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 3, 6) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 3, 7) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 3, 8) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 3, 9) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (1, 3, 10) ;

INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 1, 1) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 1, 2) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 1, 3) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 1, 4) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 1, 5) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 1, 6) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 1, 7) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 1, 8) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 1, 9) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 1, 10) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 2, 1) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 2, 2) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 2, 3) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 2, 4) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 2, 5) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 2, 6) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 2, 7) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 2, 8) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 2, 9) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 2, 10) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 3, 1) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 3, 2) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 3, 3) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 3, 4) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 3, 5) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 3, 6) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 3, 7) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 3, 8) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 3, 9) ;
INSERT INTO `seat` (`venueid`, `x`, `y`) VALUES (2, 3, 10) ;



DROP TABLE IF EXISTS `plan` ;
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
-- scheme意义尚不明确
delete from `plan`;
INSERT INTO `plan` (`name`, `starttime`, `endtime`, `introduction`, `cover`, `location`, `venueid`,
          `overdue`, `isrecommend`, `type`, `scheme`) 
	VALUES ("罗志祥2018 疯狂世界巡回演唱会南京站", "2018-05-30 19:00:00", "2018-05-30 23:00:00", "2016年，罗志祥带着第11张个人大碟《真人秀》震撼歌坛；综艺节目《极限挑战》“极限三精”之一形象深入人心，收视率不断高涨；参演的电影《美人鱼》创华语片票房记录。音乐、影视、综艺圈多栖发展，遍地开花。音乐、舞蹈是初心，Crazy World疯狂世界携#精舞门#震撼来袭;罗志祥全新个唱《Crazy World疯狂世界》带着满满诚意，耗斥大量人力、物力和心血震撼来袭！值得一提的是，此次演唱会，罗志祥亲自上阵担当副导演一职。或许是受与周星驰星爷共事拍电影的影响，小猪罗志祥立志向星爷看齐，首先将自己的导演梦植入到了最爱的音乐巡演中",
	"1.jpg", "南京", 1, false, true, "流行", "aaa") ;
INSERT INTO `plan` (`name`, `starttime`, `endtime`, `introduction`, `cover`, `location`, `venueid`,
          `overdue`, `isrecommend`, `type`, `scheme`) 
	VALUES ("罗志祥2018 疯狂世界巡回演唱会南京站", "2018-05-30 19:00:00", "2018-05-30 23:00:00", "2016年，罗志祥带着第11张个人大碟《真人秀》震撼歌坛；综艺节目《极限挑战》“极限三精”之一形象深入人心，收视率不断高涨；参演的电影《美人鱼》创华语片票房记录。音乐、影视、综艺圈多栖发展，遍地开花。音乐、舞蹈是初心，Crazy World疯狂世界携#精舞门#震撼来袭;罗志祥全新个唱《Crazy World疯狂世界》带着满满诚意，耗斥大量人力、物力和心血震撼来袭！值得一提的是，此次演唱会，罗志祥亲自上阵担当副导演一职。或许是受与周星驰星爷共事拍电影的影响，小猪罗志祥立志向星爷看齐，首先将自己的导演梦植入到了最爱的音乐巡演中",
	"1.jpg", "南京", 1, false, true, "流行", "aaa") ;




delete from `goods`;
INSERT INTO `goods` (`id`, `planid`, `goodsname`, `desc`, `pic`, `price`, `orderid`)
 VALUES (1, 1, "玉石挂坠", "古人讲佩玉为美，黄金有价玉无价。玉埋藏地下几千年或是上亿年，玉中含有大量矿物元素，所以人们常说人养玉玉养人，如果人的身体好长期佩玉可以滋润玉，玉的水头也就是折光度会越来越好，越来越亮。", "1.jpg", 79.5, null) ;
INSERT INTO `goods` (`id`, `planid`, `goodsname`, `desc`, `pic`, `price`, `orderid`)
 VALUES (2, 1, "玉石挂坠", "古人讲佩玉为美，黄金有价玉无价。玉埋藏地下几千年或是上亿年，玉中含有大量矿物元素，所以人们常说人养玉玉养人，如果人的身体好长期佩玉可以滋润玉，玉的水头也就是折光度会越来越好，越来越亮。", "2.jpg", 79.5, null) ;
INSERT INTO `goods` (`id`, `planid`, `goodsname`, `desc`, `pic`, `price`, `orderid`)
 VALUES (3, 1, "玉石挂坠", "古人讲佩玉为美，黄金有价玉无价。玉埋藏地下几千年或是上亿年，玉中含有大量矿物元素，所以人们常说人养玉玉养人，如果人的身体好长期佩玉可以滋润玉，玉的水头也就是折光度会越来越好，越来越亮。", "3.jpg", 79.5, null) ;



