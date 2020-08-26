/*
Navicat MySQL Data Transfer

Source Server         : peanut
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-08-26 17:21:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `questionId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `optionA` varchar(20) DEFAULT NULL,
  `optionB` varchar(20) DEFAULT NULL,
  `optionC` varchar(20) DEFAULT NULL,
  `optionD` varchar(20) DEFAULT NULL,
  `answer` char(1) DEFAULT NULL,
  PRIMARY KEY (`questionId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('6', '1+1=?', '1', '2', '3', '4', 'B');
INSERT INTO `question` VALUES ('7', '2+2=?', '2', '3', '4', '5', 'C');
INSERT INTO `question` VALUES ('8', '55+45=?', '100', '200', '300', '400', 'A');
INSERT INTO `question` VALUES ('9', '6+6+6+6=?', '18', '24', '30', '36', 'B');
INSERT INTO `question` VALUES ('10', '55-5=?', '60', '50', '40', '30', 'B');
INSERT INTO `question` VALUES ('11', '66-56=?', '60', '30', '20', '10', 'D');
INSERT INTO `question` VALUES ('12', '1+5=?', '6', '7', '8', '9', 'A');
INSERT INTO `question` VALUES ('13', '99-9=?', '70', '80', '90', '100', 'C');
INSERT INTO `question` VALUES ('14', '55+55=?', '100', '110', '120', '130', 'B');
INSERT INTO `question` VALUES ('15', '77+7=?', '87', '86', '85', '84', 'D');
INSERT INTO `question` VALUES ('16', '44+33=?', '77', '88', '99', '66', 'A');
INSERT INTO `question` VALUES ('17', '22-11=?', '44', '33', '22', '11', 'D');
INSERT INTO `question` VALUES ('18', '11+99=?', '100', '110', '120', '130', 'B');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('12', 'jerry', '123', '女', 'jerry@163.com');
INSERT INTO `users` VALUES ('13', 'tom', '123', '男', 'tom@163.com');
INSERT INTO `users` VALUES ('14', 'fuyu', '123', '女', 'fuyu@163.com');
INSERT INTO `users` VALUES ('15', '施国伟', '123', '男', '1483548770@qq.com');
