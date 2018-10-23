-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- 主機: 127.0.0.1:3307
-- 產生時間： 2018-10-23 05:47:14
-- 伺服器版本: 10.2.14-MariaDB
-- PHP 版本： 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `baspost`
--

-- --------------------------------------------------------

--
-- 資料表結構 `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` text COLLATE utf8_unicode_ci NOT NULL COMMENT '帳號',
  `password` text COLLATE utf8_unicode_ci NOT NULL COMMENT '密碼',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 資料表的匯出資料 `account`
--

INSERT INTO `account` (`id`, `account`, `password`) VALUES
(1, 'baspost', 'baspost');

-- --------------------------------------------------------

--
-- 資料表結構 `personal data`
--

DROP TABLE IF EXISTS `personal data`;
CREATE TABLE IF NOT EXISTS `personal data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text COLLATE utf8_unicode_ci NOT NULL COMMENT '姓名',
  `gender` text COLLATE utf8_unicode_ci NOT NULL COMMENT '性別',
  `age` int(11) NOT NULL COMMENT '年齡',
  `ball_age` int(11) NOT NULL COMMENT '球齡',
  `email` text COLLATE utf8_unicode_ci NOT NULL COMMENT '電子郵件',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 資料表的匯出資料 `personal data`
--

INSERT INTO `personal data` (`id`, `name`, `gender`, `age`, `ball_age`, `email`) VALUES
(1, 'baspost', 'female', 20, 5, '');

-- --------------------------------------------------------

--
-- 資料表結構 `posture`
--

DROP TABLE IF EXISTS `posture`;
CREATE TABLE IF NOT EXISTS `posture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `posture_zh` text COLLATE utf8_unicode_ci NOT NULL,
  `posture_en` text COLLATE utf8_unicode_ci NOT NULL,
  `ability` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
