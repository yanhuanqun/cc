/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001
*/

DROP TABLE IF EXISTS user;

CREATE TABLE user (
	userId INT(11) NOT NULL AUTO_INCREMENT,
	username VARCHAR(16),
	password VARCHAR(16),
	phone INT(11),
	PRIMARY KEY(userId)
);

DROP TABLE IF EXISTS parking;

CREATE TABLE parking (
  parkingId INT(11) NOT NULL AUTO_INCREMENT,
  parkingName VARCHAR(16),
  totalSpace INT(11),
  spareSpace INT(11),
  longitude decimal(10,7),
  latitude decimal(10,7),
  PRIMARY KEY(parkingId)
);

DROP TABLE IF EXISTS t_order;

CREATE TABLE t_order (
  orderId INT(11) NOT NULL AUTO_INCREMENT,
  userId INT(11),
  parkingId INT(11),
  startTime timestamp,
  endTime timestamp,
  useTime timestamp,
  money float,
  pay int(1),
  PRIMARY KEY(orderId)
);
