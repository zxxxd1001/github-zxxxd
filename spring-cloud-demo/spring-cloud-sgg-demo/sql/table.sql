/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : study

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-03-31 01:22:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `depts`;
CREATE TABLE `depts` (
  `dept_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(60) DEFAULT NULL,
  `db_source` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `depts` VALUES ('1', '开发部', '01');
INSERT INTO `depts` VALUES ('2', 'womende', 'study');
INSERT INTO `depts` VALUES ('4', '销售部', 'study');
INSERT INTO `depts` VALUES ('5', '网络部', 'study');


drop database if exists cloud02;
create database cloud02 character set utf8;
use cloud02;
CREATE TABLE `depts` (
  `dept_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(60) DEFAULT NULL,
  `db_source` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `depts` VALUES ('1', '开发部', database());
INSERT INTO `depts` VALUES ('2', 'womende', database());
INSERT INTO `depts` VALUES ('4', '销售部', database());
INSERT INTO `depts` VALUES ('5', '网络部', database());



drop database if exists cloud03;
create database cloud03 character set utf8;
use cloud03;
CREATE TABLE `depts` (
  `dept_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(60) DEFAULT NULL,
  `db_source` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `depts` VALUES ('1', '开发部', database());
INSERT INTO `depts` VALUES ('2', 'womende', database());
INSERT INTO `depts` VALUES ('4', '销售部', database());
INSERT INTO `depts` VALUES ('5', '网络部', database());