DROP DATABASE IF EXISTS concerttickets ;
CREATE DATABASE concerttickets default charset=utf8 ;
USE concerttickets;
-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2018-03-26 08:52:05
-- 服务器版本： 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `concerttickets`
--

-- --------------------------------------------------------

--
-- 表的结构 `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `planid` int(11) NOT NULL COMMENT '所属演出id',
  `userid` int(11) NOT NULL COMMENT '评论者id',
  `parentid` int(11) NOT NULL DEFAULT '0' COMMENT '母评论id（第一级评论默认设置为0）',
  `comment_time` datetime NOT NULL COMMENT '评论时间',
  `content` varchar(60) NOT NULL COMMENT '评论内容',
  `rate` int(11) NOT NULL COMMENT '星级',
  `type` int(11) NOT NULL COMMENT '类型（预期为0，评论为1）',
  `deleteflag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标志（删除为1，未删除为0）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `level`
--

CREATE TABLE `level` (
  `id` int(11) NOT NULL,
  `level` int(11) NOT NULL COMMENT '当前等级',
  `maxxp` int(11) NOT NULL COMMENT '当前等级升级所需经验',
  `discount` double NOT NULL COMMENT '当前等级享受的折扣'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `notice`
--

CREATE TABLE `notice` (
  `id` int(11) NOT NULL,
  `targetid` int(11) NOT NULL COMMENT '接收消息的购票者id',
  `orderid` int(11) NOT NULL COMMENT '被取消的订单id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `order_`
--

CREATE TABLE `order_` (
  `orderid` int(20) NOT NULL,
  `userid` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `money` double NOT NULL,
  `points_cost` int(11) NOT NULL,
  `perc` double NOT NULL,
  `rmoney` double NOT NULL,
  `state` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `promulgator`
--

CREATE TABLE `promulgator` (
  `id` int(11) NOT NULL,
  `email` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `balance` int(11) NOT NULL DEFAULT '0',
  `power` int(11) NOT NULL DEFAULT '0' COMMENT '是否有管理员权限',
  `head` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '头像'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `seat`
--

CREATE TABLE `seat` (
  `id` int(11) NOT NULL,
  `venueid` int(11) NOT NULL COMMENT '所属场馆id',
  `x` int(11) NOT NULL COMMENT 'x坐标',
  `y` int(11) NOT NULL COMMENT 'y坐标'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `interest` varchar(60) NOT NULL,
  `face` varchar(60) NOT NULL,
  `level` int(11) NOT NULL,
  `exp` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  `money` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

-- --------------------------------------------------------

--
-- 表的结构 `userinfo`
--

CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `truename` varchar(20) NOT NULL COMMENT '真实姓名',
  `sex` varchar(20) NOT NULL COMMENT '性别',
  `birthdate` date NOT NULL COMMENT '生日',
  `marital_status` varchar(20) NOT NULL COMMENT '婚姻状况',
  `education` varchar(20) NOT NULL COMMENT '教育情况',
  `job` varchar(20) NOT NULL COMMENT '职业',
  `address` varchar(60) NOT NULL COMMENT '住址',
  `idnumber` int(11) NOT NULL COMMENT '身份证号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `venue`
--

CREATE TABLE `venue` (
  `id` int(11) NOT NULL,
  `city` varchar(20) NOT NULL,
  `address` varchar(60) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `level`
--
ALTER TABLE `level`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notice`
--
ALTER TABLE `notice`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_`
--
ALTER TABLE `order_`
  ADD PRIMARY KEY (`orderid`);

--
-- Indexes for table `promulgator`
--
ALTER TABLE `promulgator`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`id`);


--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `userinfo`
--
ALTER TABLE `userinfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venue`
--
ALTER TABLE `venue`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `order_`
--
ALTER TABLE `order_`
  MODIFY `orderid` int(20) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;





-- wanglei


-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2018-03-29 09:55:41
-- 服务器版本： 5.6.21-log
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `concert_tickets`
--

-- --------------------------------------------------------

--
-- 表的结构 `goods`
--

CREATE TABLE IF NOT EXISTS `goods` (
  `id` int(11) NOT NULL,
  `planid` int(11) NOT NULL,
  `goodsname` varchar(20) NOT NULL,
  `desc` varchar(400) NOT NULL,
  `pic` varchar(30) NOT NULL,
  `price` double NOT NULL,
  `orderid` int(20),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `plan`
--

CREATE TABLE IF NOT EXISTS `plan` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `starttime` datetime NOT NULL,
  `endtime` datetime NOT NULL,
  `introduction` varchar(80) NOT NULL,
  `cover` varchar(20) NOT NULL,
  `loction` varchar(20) NOT NULL,
  `venueid` int(11) NOT NULL,
  `overdue` tinyint(1) NOT NULL DEFAULT '0',
  `isrecommend` tinyint(1) NOT NULL DEFAULT '0',
  `type` varchar(20) NOT NULL,
  `scheme` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `promulgator`
--

CREATE TABLE IF NOT EXISTS `promulgator` (
  `id` int(11) NOT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `balance` int(11) NOT NULL DEFAULT '0',
  `power` tinyint(1) NOT NULL DEFAULT '0',
  `head` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `seatprice`
--

CREATE TABLE IF NOT EXISTS `seatprice` (
  `id` int(11) NOT NULL,
  `planid` int(11) NOT NULL,
  `orderid` int(11) DEFAULT NULL,
  `seatid` int(11) NOT NULL,
  `venueid` int(11) NOT NULL,
  `price` double NOT NULL,
  `avail` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;




