
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








delete from `goods`;
INSERT INTO `goods` (`id`, `planid`, `goodsname`, `desc`, `pic`, `price`, `orderid`)
 VALUES (1, 1, "玉石挂坠", "古人讲佩玉为美，黄金有价玉无价。玉埋藏地下几千年或是上亿年，玉中含有大量矿物元素，所以人们常说人养玉玉养人，如果人的身体好长期佩玉可以滋润玉，玉的水头也就是折光度会越来越好，越来越亮。", "1.jpg", 79.5, null) ;
INSERT INTO `goods` (`id`, `planid`, `goodsname`, `desc`, `pic`, `price`, `orderid`)
 VALUES (2, 1, "玉石挂坠", "古人讲佩玉为美，黄金有价玉无价。玉埋藏地下几千年或是上亿年，玉中含有大量矿物元素，所以人们常说人养玉玉养人，如果人的身体好长期佩玉可以滋润玉，玉的水头也就是折光度会越来越好，越来越亮。", "2.jpg", 79.5, null) ;
INSERT INTO `goods` (`id`, `planid`, `goodsname`, `desc`, `pic`, `price`, `orderid`)
 VALUES (3, 1, "玉石挂坠", "古人讲佩玉为美，黄金有价玉无价。玉埋藏地下几千年或是上亿年，玉中含有大量矿物元素，所以人们常说人养玉玉养人，如果人的身体好长期佩玉可以滋润玉，玉的水头也就是折光度会越来越好，越来越亮。", "3.jpg", 79.5, null) ;



