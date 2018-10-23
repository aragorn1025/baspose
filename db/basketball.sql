-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- 主機: 127.0.0.1:3306
-- 產生時間： 2018 年 10 月 23 日 03:32
-- 伺服器版本: 5.7.23
-- PHP 版本： 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `basketball`
--

-- --------------------------------------------------------

--
-- 資料表結構 `posture`
--

DROP TABLE IF EXISTS `posture`;
CREATE TABLE IF NOT EXISTS `posture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `posture_zh` text NOT NULL,
  `posture_en` text NOT NULL,
  `ability` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `posture`
--

INSERT INTO `posture` (`id`, `posture_zh`, `posture_en`, `ability`) VALUES
(1, '投球', 'shooting', ''),
(2, '運球', 'dribbling', ''),
(3, '上籃', 'layup', 'dribbling');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
