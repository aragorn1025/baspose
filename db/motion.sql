-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- 主機: 127.0.0.1:3307
-- 產生時間： 2018 年 10 月 23 日 02:43
-- 伺服器版本: 10.3.9-MariaDB
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
-- 資料庫： `motion`
--

-- --------------------------------------------------------

--
-- 資料表結構 `dribbling`
--

DROP TABLE IF EXISTS `dribbling`;
CREATE TABLE IF NOT EXISTS `dribbling` (
  `Posture` char(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '能夠不看球/需要看球' COMMENT '姿勢',
  `Ability` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '只會原地運球/會原地作變換' COMMENT '預備能力'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 資料表結構 `layup`
--

DROP TABLE IF EXISTS `layup`;
CREATE TABLE IF NOT EXISTS `layup` (
  `Posture` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '兩步上籃/三步上籃' COMMENT '姿勢',
  `Ability` char(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '左右手皆可上籃/只能單手上籃' COMMENT '預備能力'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 資料表結構 `shooting`
--

DROP TABLE IF EXISTS `shooting`;
CREATE TABLE IF NOT EXISTS `shooting` (
  `Posture` char(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '高中生以上/國中生以下' COMMENT '姿勢',
  `Ability` char(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '雙手投籃/單手投籃' COMMENT '預備能力'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
