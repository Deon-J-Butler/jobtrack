CREATE DATABASE IF NOT EXISTS `JobTrack`;
USE `JobTrack`;

DROP TABLE IF EXISTS `Job`;

CREATE TABLE `Job` (
  `File` int(5) NOT NULL AUTO_INCREMENT,
  `Company` varchar(30) DEFAULT NULL,
  `Position` varchar(50) DEFAULT NULL,
  `Date_Applied` date DEFAULT NULL,
  `Interview` char(1) DEFAULT NULL,
  `Interview_Date` date DEFAULT NULL,
  `Notes` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`File`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES `Job` WRITE;

UNLOCK TABLES;