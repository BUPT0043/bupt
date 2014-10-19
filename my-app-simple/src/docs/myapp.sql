/*
MySQL Data Transfer
Source Host: localhost
Source Database: myapp
Target Host: localhost
Target Database: myapp
Date: 2014/9/22 12:30:58
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for res_category
-- ----------------------------
CREATE TABLE `res_category` (
  `id` int(20) unsigned NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for res_category_item
-- ----------------------------
CREATE TABLE `res_category_item` (
  `id` int(20) unsigned NOT NULL,
  `categoryid` int(20) unsigned NOT NULL,
  `description` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `data` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `refer` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`categoryid`),
  CONSTRAINT `category_id` FOREIGN KEY (`categoryid`) REFERENCES `res_category` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for role
-- ----------------------------
CREATE TABLE `role` (
  `id` int(20) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `pwd` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `res_category` VALUES ('1', 'divorce', 'DivorceTest');
INSERT INTO `res_category` VALUES ('2', 'traffic', 'TrafficTest');
INSERT INTO `res_category_item` VALUES ('1', '1', 'DivorceTest', 'DataTest1', 'ReferTest1');
INSERT INTO `res_category_item` VALUES ('2', '1', 'DivorceTest', 'DataTest2', 'ReferTest2');
INSERT INTO `res_category_item` VALUES ('3', '2', 'TrafficTest', 'DataTest1', 'ReferTest1');
INSERT INTO `role` VALUES ('1', 'admin', '123456');
INSERT INTO `role` VALUES ('2', 'user_1', '123456');
