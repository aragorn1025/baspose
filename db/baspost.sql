-- phpMyAdmin SQL Dump
-- version 4.0.10deb1ubuntu0.1
-- http://www.phpmyadmin.net
--
-- 主機: localhost
-- 建立日期: 2019 年 07 月 11 日 10:01
-- 伺服器版本: 5.5.41-0ubuntu0.14.04.1
-- PHP 版本: 5.5.9-1ubuntu4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 資料庫: `baspost`
--

-- --------------------------------------------------------

--
-- 資料表結構 `error`
--

CREATE TABLE IF NOT EXISTS `error` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `error` int(11) NOT NULL,
  `filename` text CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=140 ;

--
-- 資料表的匯出資料 `error`
--

INSERT INTO `error` (`id`, `error`, `filename`) VALUES
(1, 1, 'VID_20190528_120605.mp4'),
(93, 0, 'V_20190528_093503_N0.mp4'),
(94, 1, 'V_20190528_093503_N0.mp4'),
(95, 1, 'V_20190528_093503_N0.mp4'),
(96, 0, 'in_1.mp4'),
(97, 0, 'in_1.mp4'),
(98, 1, 'V_20190528_093503_N0.mp4'),
(101, 1, 'V_20190528_093503_N0.mp4'),
(103, 1, 'V_20190611_114602_N0.mp4'),
(104, 1, 'V_20190611_115258_N0.mp4'),
(106, 1, 'V_20190611_115258_N0.mp4'),
(107, 1, 'V_20190611_115258_N0.mp4'),
(108, 1, 'V_20190611_115258_N0.mp4'),
(109, 1, 'in_1.mp4'),
(110, 0, 'in_1.mp4'),
(111, 1, 'V_20190528_093503_N0.mp4'),
(112, 0, 'in_1.mp4'),
(116, 0, 'in_1.mp4'),
(120, 0, 'in_1.mp4'),
(121, 0, 'in_1.mp4'),
(122, 0, 'in_1.mp4'),
(123, 0, 'less_90_1.mp4'),
(124, 0, 'less_90_1.mp4'),
(125, 0, 'stan.mp4'),
(127, 1, 'stan.mp4'),
(128, 1, 'stan.mp4'),
(129, 1, 'stan.mp4'),
(130, 1, 'stan.mp4'),
(131, 1, 'stan.mp4'),
(132, 1, 'stan.mp4'),
(133, 1, 'stan.mp4'),
(134, 0, 'stan.mp4'),
(135, 1, 'stan.mp4'),
(136, 1, 'stan.mp4'),
(137, 1, 'stan.mp4'),
(139, 0, 'stan.mp4');

-- --------------------------------------------------------

--
-- 資料表結構 `shootAfter`
--

CREATE TABLE IF NOT EXISTS `shootAfter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `angle` double NOT NULL,
  `judge` text CHARACTER SET utf8 NOT NULL,
  `comment` text CHARACTER SET utf8 NOT NULL,
  `filename` text CHARACTER SET utf8 NOT NULL,
  `wrist` tinyint(1) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=140 ;

--
-- 資料表的匯出資料 `shootAfter`
--

INSERT INTO `shootAfter` (`id`, `angle`, `judge`, `comment`, `filename`, `wrist`, `date`) VALUES
(1, 150.965, 'normal', 'You should extend your elbow.', 'VID_20190522_121453.mp4\r\n', 0, '2019-05-22'),
(30, 175.869278216299, 'perfect', 'Your posture was perfect', 'in_1.mp4', 0, '2019-05-26'),
(31, 166.374864600776, 'good', 'Your hand must remain straight when the ball break away from hand', 'less_90_1.mp4', 0, '2019-05-26'),
(32, 175.541229455811, 'perfect', 'Your posture was perfect', 'stan.mp4', 0, '2019-05-26'),
(33, 180.324, 'test', 'testtest', 'V_20190528_093503_N0.mp4', 1, '2019-05-28'),
(34, 150.965, 'test', 'test', 'V_20190528_112014_N0.mp4', 1, '2019-05-28'),
(69, 175.869278216299, 'perfect', 'Your posture was perfect', 'in_1.mp4', 0, '0000-00-00'),
(70, 76.2024229502114, 'terrible', 'Your hand must remain straight when the ball break away from hand', 'V_20190528_113657_N0.mp4', 0, '2019-05-28'),
(72, 76.2024229502114, 'terrible', 'Your hand must remain straight when the ball break away from hand', 'V_20190528_113657_N0.mp4', 0, '2019-05-28'),
(74, 180, 'terrible', 'Your hand must remain straight when the ball break away from hand', 'V_20190528_114853_N0.mp4', 0, '2019-05-28'),
(75, 142.280484766142, 'ok', 'Your hand must remain straight when the ball break away from hand', 'V_20190528_115113_N0.mp4', 0, '2019-05-28'),
(78, 0, 'terrible', 'Your hand must remain straight when the ball break away from hand', 'VID_20190528_120605.mp4', 0, '2019-05-28'),
(79, 0, 'terrible', 'Your hand must remain straight when the ball break away from hand', 'VID_20190528_120605.mp4', 0, '2019-05-28'),
(83, 175.869278216299, 'perfect', 'Your posture was perfect', 'in_1.mp4', 0, '2019-06-03'),
(84, 175.869278216299, 'perfect', 'Your posture was perfect', 'in_1.mp4', 0, '0000-00-00'),
(96, 175.869278216299, 'perfect', 'Your posture was perfect', 'in_1.mp4', 0, '2019-06-10'),
(97, 175.869278216299, 'perfect', 'Your posture was perfect', 'in_1.mp4', 0, '2019-06-10'),
(110, 175.869278216299, 'perfect', 'Your posture was perfect', 'in_1.mp4', 0, '2019-07-09'),
(112, 175.869278216299, 'perfect', 'Your posture was perfect', 'in_1.mp4', 0, '2019-07-09'),
(116, 175.869278216299, 'perfect', 'Your posture was perfect', 'in_1.mp4', 0, '2019-07-09'),
(120, 175.869278216299, 'perfect', 'Your posture was perfect', 'in_1.mp4', 0, '0000-00-00'),
(121, 175.869278216299, 'perfect', 'Your posture was perfect', 'in_1.mp4', 0, '2019-07-09'),
(122, 175.869278216299, 'perfect', 'Your posture was perfect', 'in_1.mp4', 0, '2019-07-09'),
(123, 166.374864600776, 'good', 'Your hand must remain straight when the ball break away from hand', 'less_90_1.mp4', 0, '2019-07-09'),
(124, 166.374864600776, 'good', 'Your hand must remain straight when the ball break away from hand', 'less_90_1.mp4', 0, '2019-07-09'),
(125, 175.541229455811, 'perfect', 'Your posture was perfect', 'stan.mp4', 0, '2019-07-09'),
(134, 175.541229455811, 'perfect', 'Your posture was perfect', 'stan.mp4', 0, '2019-07-11'),
(139, 175.541229455811, 'perfect', 'Your posture was perfect', 'stan.mp4', 0, '0000-00-00');

-- --------------------------------------------------------

--
-- 資料表結構 `shootBefore`
--

CREATE TABLE IF NOT EXISTS `shootBefore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `angle` double NOT NULL,
  `judge` text CHARACTER SET utf8 NOT NULL,
  `comment` text CHARACTER SET utf8 NOT NULL,
  `filename` text CHARACTER SET utf8 NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=140 ;

--
-- 資料表的匯出資料 `shootBefore`
--

INSERT INTO `shootBefore` (`id`, `angle`, `judge`, `comment`, `filename`, `date`) VALUES
(2, 60, 'normal', 'Your elbow needs to be square.', 'VID_20190522_121453.mp4', '2019-05-22'),
(30, 65.4025098471586, 'normal', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'in_1.mp4', '2019-05-26'),
(31, 50.7928838989959, 'bad', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'less_90_1.mp4', '2019-05-26'),
(32, 68.8998668668341, 'normal', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'stan.mp4', '2019-05-26'),
(33, 49.245, 'test', 'test', 'V_20190528_093503_N0.mp4', '2019-05-28'),
(34, 60, 'test', 'test', 'V_20190528_112014_N0.mp4', '2019-05-28'),
(69, 65.4025098471586, 'normal', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'in_1.mp4', '0000-00-00'),
(70, 79.479982986062, 'great', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'V_20190528_113657_N0.mp4', '2019-05-28'),
(72, 79.479982986062, 'great', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'V_20190528_113657_N0.mp4', '2019-05-28'),
(74, 180, 'bad', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'V_20190528_114853_N0.mp4', '2019-05-28'),
(75, 89.7827921716348, 'perfect', 'Your posture was perfect', 'V_20190528_115113_N0.mp4', '2019-05-28'),
(78, 0, 'bad', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'VID_20190528_120605.mp4', '2019-05-28'),
(79, 0, 'bad', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'VID_20190528_120605.mp4', '2019-05-28'),
(83, 65.4025098471586, 'normal', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'in_1.mp4', '2019-06-03'),
(84, 65.4025098471586, 'normal', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'in_1.mp4', '0000-00-00'),
(96, 65.4025098471586, 'normal', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'in_1.mp4', '2019-06-10'),
(97, 65.4025098471586, 'normal', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'in_1.mp4', '2019-06-10'),
(110, 65.4025098471586, 'normal', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'in_1.mp4', '2019-07-09'),
(112, 65.4025098471586, 'normal', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'in_1.mp4', '2019-07-09'),
(116, 65.4025098471586, 'normal', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'in_1.mp4', '2019-07-09'),
(120, 175.869278216299, 'bad', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'in_1.mp4', '0000-00-00'),
(121, 175.869278216299, 'bad', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'in_1.mp4', '2019-07-09'),
(122, 65.4025098471586, 'normal', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'in_1.mp4', '2019-07-09'),
(123, 50.7928838989959, 'bad', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'less_90_1.mp4', '2019-07-09'),
(124, 91.2927238645508, 'perfect', 'Your posture was perfect', 'less_90_1.mp4', '2019-07-09'),
(125, 65.3636919935559, 'normal', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'stan.mp4', '2019-07-09'),
(134, 65.3636919935559, 'normal', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'stan.mp4', '2019-07-11'),
(139, 65.3636919935559, 'normal', 'Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point', 'stan.mp4', '0000-00-00');

-- --------------------------------------------------------

--
-- 資料表結構 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `nickname` text NOT NULL,
  `email` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- 資料表的匯出資料 `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `email`) VALUES
(1, 'apple', 'apple', 'book', 'apple@gmail.com'),
(2, 'abc', '$2y$10$sFlw80ltPfLfEOXHu3.uLuZUI/xfGXG9EmhCDzViOdyxp4mLZGLAy', 'abc', 'abc@gmail.com'),
(3, 'ppp', '$2y$10$57uDCquoierld0GQuL13TebWqUnicTuPhZZW/lYJVVFH6wjOzR6Gy', 'ppp', 'ppp@gmail.com'),
(4, 'sss', '$2y$10$Du5SQO30jN6kNpe4nD.nsOGHXhpTNULyw4pOmlYKoMUD5yTcEsvYC', 'sss', 'sss@gmail.com'),
(5, 'aaa', 'aaa', 'aaa', 'aaa@gmail.com'),
(6, 'bbb', 'bbb', 'bbb', 'bbb@gmail.com');

-- --------------------------------------------------------

--
-- 資料表結構 `video`
--

CREATE TABLE IF NOT EXISTS `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` text CHARACTER SET utf8 NOT NULL,
  `date` text CHARACTER SET utf8 NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=142 ;

--
-- 資料表的匯出資料 `video`
--

INSERT INTO `video` (`id`, `path`, `date`, `type`) VALUES
(1, '/home/data/uploads/VID_20190518_085336.mp4', '', 0),
(2, '/home/data/uploads/VID_20190518_085336.mp4', '', 0),
(5, 'VID_20190522_121453.mp4', '', 0),
(6, 'VID_20190522_132050.mp4', '2019-05-22 13:21:55', 0),
(7, 'VID_20190522_132050.mp4', '2019-05-22 13:22:04', 0),
(8, 'VID_20190518_085336.mp4', '2019-05-22 14:25:07', 0),
(30, 'in_1.mp4', '2019/5/26', 0),
(31, 'less_90_1.mp4', '2019/5/26', 0),
(32, 'stan.mp4', '2019/5/26', 0),
(33, 'in_1.mp4', '2019/5/27', 0),
(36, 'less_90_1.mp4', '2019/5/27', 0),
(37, 'in_1.mp4', '2019/5/27', 0),
(38, 'in_1.mp4', '2019/5/27', 0),
(39, 'VID_20190527_203806.mp4', '2019-05-27 20:38:40', 0),
(40, 'VID_20190527_203806.mp4', '2019-05-27 20:39:35', 0),
(41, 'in_1.mp4', '2019/5/27', 0),
(42, 'VID_20190527_205202.mp4', '2019-05-27 20:52:36', 0),
(43, 'in_1.mp4', '2019/5/27', 0),
(44, 'in_1.mp4', '2019/5/27\r\n', 0),
(45, 'VID_20190527_212808.mp4', '2019-05-27 21:29:00', 0),
(46, 'VID_20190527_213150.mp4', '2019-05-27 21:32:23', 0),
(47, 'in_1.mp4', '2019/5/27', 0),
(48, 'VID_20190527_230122.mp4', '2019-05-27 23:01:58', 0),
(49, 'in_1.mp4', '2019/5/27', 0),
(50, 'V_20190528_074723_N0.mp4', '2019-05-28 07:48:20', 0),
(51, 'V_20190528_075630_N0.mp4', '2019-05-28 07:57:13', 0),
(52, 'V_20190528_082144_N0.mp4', '2019-05-28 08:22:38', 0),
(53, 'V_20190528_082528_N0.mp4', '2019-05-28 08:26:12', 0),
(54, 'in_1.mp4', '2019/5/28', 0),
(55, 'V_20190528_093503_N0.mp4', '2019-05-28 09:36:04', 0),
(56, 'V_20190528_093503_N0.mp4', '2019-05-28 09:44:18', 0),
(57, 'V_20190528_093503_N0.mp4', '2019-05-28 09:51:36', 0),
(58, 'in_1.mp4', '2019/5/28', 0),
(59, 'V_20190528_093503_N0.mp4', '2019-05-28 10:35:08', 0),
(60, 'in_1.mp4', '2019/5/28', 0),
(61, 'V_20190528_093503_N0.mp4', '2019-05-28 10:59:30', 0),
(62, 'V_20190528_093503_N0.mp4', '2019-05-28 11:06:39', 0),
(63, 'V_20190528_093503_N0.mp4', '2019-05-28 11:10:43', 0),
(64, 'V_20190528_111349_N0.mp4', '2019-05-28 11:14:15', 0),
(65, 'V_20190528_111349_N0.mp4', '2019-05-28 11:17:50', 0),
(66, 'V_20190528_112014_N0.mp4', '2019-05-28 11:20:40', 0),
(67, 'V_20190528_112014_N0.mp4', '2019-05-28 11:28:44', 0),
(68, 'in_1.py', '2019/5/28', 0),
(69, 'in_1.mp4', '123123', 0),
(70, 'V_20190528_113657_N0.mp4', '2019-05-28 11:37:26', 0),
(71, 'V_20190528_112014_N0.mp4', '2019-05-28 11:39:05', 0),
(72, 'V_20190528_113657_N0.mp4', '2019-05-28 11:45:21', 0),
(73, 'V_20190528_114552_N0.mp4', '2019-05-28 11:46:17', 0),
(74, 'V_20190528_114853_N0.mp4', '2019-05-28 11:49:22', 0),
(75, 'V_20190528_115113_N0.mp4', '2019-05-28 11:51:49', 0),
(76, 'V_20190528_115113_N0.mp4', '2019-05-28 11:59:05', 0),
(77, 'V_20190528_115113_N0.mp4', '2019-05-28 11:59:08', 0),
(78, 'VID_20190528_120605.mp4', '2019-05-28 12:06:56', 0),
(79, 'VID_20190528_120605.mp4', '2019-05-28 12:07:18', 0),
(80, 'in_1.mp4', '2019/6/3', 0),
(81, 'in_1.mp4', '2019/6/3', 0),
(82, 'in_1.mp4', '2019/6/3', 0),
(83, 'in_1.mp4', '2019/6/3', 0),
(84, 'in_1.mp4', '12321', 0),
(85, 'V_20190528_111349_N0.mp4', '2019/6/10', 0),
(86, 'V_20190528_093503_N0.mp4', '2019/6/10', 0),
(87, 'V_20190528_093503_N0.mp4', '2019/6/10', 0),
(88, 'V_20190528_093503_N0.mp4', '2019/6/10', 0),
(89, 'V_20190528_093503_N0.mp4', '2019/6/10', 0),
(90, 'V_20190528_093503_N0.mp4', '2019/6/10', 0),
(91, 'V_20190528_093503_N0.mp4', '2019/6/10', 0),
(92, 'V_20190528_093503_N0.mp4', '2019/6/10', 0),
(93, 'V_20190528_093503_N0.mp4', '2019/6/10\r\n', 0),
(94, 'V_20190528_093503_N0.mp4', '2019/6/10', 0),
(95, 'V_20190528_093503_N0.mp4', '2019/6/10\r\n', 0),
(96, 'in_1.mp4', '2019/6/10', 0),
(97, 'in_1.mp4', '2019/6/10', 0),
(98, 'V_20190528_093503_N0.mp4', '2019/6/10', 0),
(99, 'V_20190611_112511_N0.mp4', '2019-06-11 11:25:36', 0),
(100, 'V_20190611_112511_N0.mp4', '2019-06-11 11:36:45', 0),
(101, 'V_20190528_093503_N0.mp4', '123123', 0),
(102, 'V_20190611_112511_N0.mp4', '2019-06-11 11:44:43', 0),
(103, 'V_20190611_114602_N0.mp4', '2019-06-11 11:46:21', 0),
(104, 'V_20190611_115258_N0.mp4', '2019-06-11 11:53:20', 0),
(105, 'V_20190611_115509_N0.mp4', '2019-06-11 11:55:38', 0),
(106, 'V_20190611_115258_N0.mp4', '2019-06-11 11:56:28', 0),
(107, 'V_20190611_115258_N0.mp4', '2019-06-11 12:02:04', 0),
(108, 'V_20190611_115258_N0.mp4', '2019-06-11 12:07:56', 0),
(109, 'in_1.mp4', '2133ad', 0),
(110, 'in_1.mp4', '2019/7/9', 0),
(111, 'V_20190528_093503_N0.mp4', '2019/7/9', 0),
(112, 'in_1.mp4', '2019/7/9', 0),
(113, 'in_1.mp4', '2019/7/9', 0),
(114, 'in_1.mp4', '2019/7/9', 0),
(115, 'in_1.mp4', '2019/7/9', 0),
(116, 'in_1.mp4', '2019/7/9', 0),
(117, 'in_1.mp4', '2019/7/9', 0),
(118, 'in_1.mp4', '2019/7/9', 0),
(119, 'in_1.mp4', '2019/7/9\r\n', 0),
(120, 'in_1.mp4', '23134986', 0),
(121, 'in_1.mp4', '2019/7/9', 0),
(122, 'in_1.mp4', '2019/7/9', 0),
(123, 'less_90_1.mp4', '2019/7/9', 0),
(124, 'less_90_1.mp4', '2019/7/9', 0),
(125, 'stan.mp4', '2019/7/9', 0),
(126, 'stan.mp4', '2019/7/10', 0),
(127, 'stan.mp4', '2019/7/10', 0),
(128, 'stan.mp4', '2019/7/10', 0),
(129, 'stan.mp4', '2019/7/11', 0),
(130, 'stan.mp4', '2019/7/11', 0),
(131, 'stan.mp4', '2019/7/11', 0),
(132, 'stan.mp4', '2019/7/11', 0),
(133, 'stan.mp4', '2019/7/11', 0),
(134, 'stan.mp4', '2019/7/11', 0),
(135, 'stan.mp4', '2019/7/11', 0),
(136, 'stan.mp4', '21asdfasdf', 0),
(137, 'stan.mp4', '12asdf', 0),
(138, 'stan.mp4', 'asdasd', 0),
(139, 'stan.mp4', '2019', 0),
(140, 'stan.mp4', '1342134', 0),
(141, 'stan.mp4', 'asdasd', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
