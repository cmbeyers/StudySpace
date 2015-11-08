-- MySQL dump 10.13  Distrib 5.5.46, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: miStudySpace
-- ------------------------------------------------------
-- Server version	5.5.46-0ubuntu0.14.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Access_Points`
--

DROP TABLE IF EXISTS `Access_Points`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Access_Points` (
  `ap_name` varchar(20) NOT NULL,
  `current_clients` int(11) DEFAULT NULL,
  PRIMARY KEY (`ap_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Access_Points`
--

LOCK TABLES `Access_Points` WRITE;
/*!40000 ALTER TABLE `Access_Points` DISABLE KEYS */;
/*!40000 ALTER TABLE `Access_Points` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Floors`
--

DROP TABLE IF EXISTS `Floors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Floors` (
  `library_name` varchar(40) NOT NULL,
  `floor_name` varchar(40) NOT NULL DEFAULT '',
  `floor_index` int(11) DEFAULT NULL,
  `current_occupancy` int(11) DEFAULT NULL,
  `max_occupancy` int(11) DEFAULT NULL,
  PRIMARY KEY (`library_name`,`floor_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Floors`
--

LOCK TABLES `Floors` WRITE;
/*!40000 ALTER TABLE `Floors` DISABLE KEYS */;
INSERT INTO `Floors` VALUES ('Shapiro','Basement',0,167,219),('Shapiro','First',1,323,404),('Shapiro','Fourth',4,166,228),('Shapiro','Second',2,233,342),('Shapiro','Third',3,152,206);
/*!40000 ALTER TABLE `Floors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Hour_Average`
--

DROP TABLE IF EXISTS `Hour_Average`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Hour_Average` (
  `floor_name` varchar(40) NOT NULL DEFAULT '',
  `library_name` varchar(40) NOT NULL DEFAULT '',
  `hour` int(11) NOT NULL DEFAULT '0',
  `fill_average` float DEFAULT NULL,
  PRIMARY KEY (`floor_name`,`library_name`,`hour`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Hour_Average`
--

LOCK TABLES `Hour_Average` WRITE;
/*!40000 ALTER TABLE `Hour_Average` DISABLE KEYS */;
INSERT INTO `Hour_Average` VALUES ('Basement','Shapiro',0,0),('Basement','Shapiro',1,0),('Basement','Shapiro',2,0),('Basement','Shapiro',3,0),('Basement','Shapiro',4,0),('Basement','Shapiro',5,0),('Basement','Shapiro',6,0),('Basement','Shapiro',7,0),('Basement','Shapiro',8,0),('Basement','Shapiro',9,0),('Basement','Shapiro',10,0),('Basement','Shapiro',11,0),('Basement','Shapiro',12,0),('Basement','Shapiro',13,0),('Basement','Shapiro',14,0.732116),('Basement','Shapiro',15,0),('Basement','Shapiro',16,0),('Basement','Shapiro',17,0),('Basement','Shapiro',18,0),('Basement','Shapiro',19,0),('Basement','Shapiro',20,0),('Basement','Shapiro',21,0),('Basement','Shapiro',22,0),('Basement','Shapiro',23,0),('First','Shapiro',0,0),('First','Shapiro',1,0),('First','Shapiro',2,0),('First','Shapiro',3,0),('First','Shapiro',4,0),('First','Shapiro',5,0),('First','Shapiro',6,0),('First','Shapiro',7,0),('First','Shapiro',8,0),('First','Shapiro',9,0),('First','Shapiro',10,0),('First','Shapiro',11,0),('First','Shapiro',12,0),('First','Shapiro',13,0),('First','Shapiro',14,0.778878),('First','Shapiro',15,0),('First','Shapiro',16,0),('First','Shapiro',17,0),('First','Shapiro',18,0),('First','Shapiro',19,0),('First','Shapiro',20,0),('First','Shapiro',21,0),('First','Shapiro',22,0),('First','Shapiro',23,0),('Fourth','Shapiro',0,0),('Fourth','Shapiro',1,0),('Fourth','Shapiro',2,0),('Fourth','Shapiro',3,0),('Fourth','Shapiro',4,0),('Fourth','Shapiro',5,0),('Fourth','Shapiro',6,0),('Fourth','Shapiro',7,0),('Fourth','Shapiro',8,0),('Fourth','Shapiro',9,0),('Fourth','Shapiro',10,0),('Fourth','Shapiro',11,0),('Fourth','Shapiro',12,0),('Fourth','Shapiro',13,0),('Fourth','Shapiro',14,0.75),('Fourth','Shapiro',15,0),('Fourth','Shapiro',16,0),('Fourth','Shapiro',17,0),('Fourth','Shapiro',18,0),('Fourth','Shapiro',19,0),('Fourth','Shapiro',20,0),('Fourth','Shapiro',21,0),('Fourth','Shapiro',22,0),('Fourth','Shapiro',23,0),('Second','Shapiro',0,0),('Second','Shapiro',1,0),('Second','Shapiro',2,0),('Second','Shapiro',3,0),('Second','Shapiro',4,0),('Second','Shapiro',5,0),('Second','Shapiro',6,0),('Second','Shapiro',7,0),('Second','Shapiro',8,0),('Second','Shapiro',9,0),('Second','Shapiro',10,0),('Second','Shapiro',11,0),('Second','Shapiro',12,0),('Second','Shapiro',13,0),('Second','Shapiro',14,0.684211),('Second','Shapiro',15,0),('Second','Shapiro',16,0),('Second','Shapiro',17,0),('Second','Shapiro',18,0),('Second','Shapiro',19,0),('Second','Shapiro',20,0),('Second','Shapiro',21,0),('Second','Shapiro',22,0),('Second','Shapiro',23,0),('Third','Shapiro',0,0),('Third','Shapiro',1,0),('Third','Shapiro',2,0),('Third','Shapiro',3,0),('Third','Shapiro',4,0),('Third','Shapiro',5,0),('Third','Shapiro',6,0),('Third','Shapiro',7,0),('Third','Shapiro',8,0),('Third','Shapiro',9,0),('Third','Shapiro',10,0),('Third','Shapiro',11,0),('Third','Shapiro',12,0),('Third','Shapiro',13,0),('Third','Shapiro',14,0.750809),('Third','Shapiro',15,0),('Third','Shapiro',16,0),('Third','Shapiro',17,0),('Third','Shapiro',18,0),('Third','Shapiro',19,0),('Third','Shapiro',20,0),('Third','Shapiro',21,0),('Third','Shapiro',22,0),('Third','Shapiro',23,0);
/*!40000 ALTER TABLE `Hour_Average` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Libraries`
--

DROP TABLE IF EXISTS `Libraries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Libraries` (
  `library_name` varchar(40) NOT NULL,
  `current_occupancy` int(11) DEFAULT NULL,
  `max_occupancy` int(11) DEFAULT NULL,
  PRIMARY KEY (`library_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libraries`
--

LOCK TABLES `Libraries` WRITE;
/*!40000 ALTER TABLE `Libraries` DISABLE KEYS */;
INSERT INTO `Libraries` VALUES ('Shapiro',1091,1400);
/*!40000 ALTER TABLE `Libraries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Library_Hour_Average`
--

DROP TABLE IF EXISTS `Library_Hour_Average`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Library_Hour_Average` (
  `library_name` varchar(40) NOT NULL,
  `hour` int(11) NOT NULL DEFAULT '0',
  `fill_average` float DEFAULT NULL,
  PRIMARY KEY (`library_name`,`hour`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Library_Hour_Average`
--

LOCK TABLES `Library_Hour_Average` WRITE;
/*!40000 ALTER TABLE `Library_Hour_Average` DISABLE KEYS */;
INSERT INTO `Library_Hour_Average` VALUES ('Shapiro',0,0),('Shapiro',1,0),('Shapiro',2,0),('Shapiro',3,0),('Shapiro',4,0),('Shapiro',5,0),('Shapiro',6,0),('Shapiro',7,0),('Shapiro',8,0),('Shapiro',9,0),('Shapiro',10,0),('Shapiro',11,0),('Shapiro',12,0),('Shapiro',13,0),('Shapiro',14,0.735278),('Shapiro',15,0),('Shapiro',16,0),('Shapiro',17,0),('Shapiro',18,0),('Shapiro',19,0),('Shapiro',20,0),('Shapiro',21,0),('Shapiro',22,0),('Shapiro',23,0);
/*!40000 ALTER TABLE `Library_Hour_Average` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Regions`
--

DROP TABLE IF EXISTS `Regions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Regions` (
  `region_name` varchar(40) NOT NULL,
  `floor_name` varchar(40) NOT NULL DEFAULT '',
  `library_name` varchar(40) NOT NULL DEFAULT '',
  `region_index` int(11) DEFAULT NULL,
  `current_occupancy` int(11) DEFAULT NULL,
  `max_occupancy` int(11) DEFAULT NULL,
  PRIMARY KEY (`region_name`,`floor_name`,`library_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Regions`
--

LOCK TABLES `Regions` WRITE;
/*!40000 ALTER TABLE `Regions` DISABLE KEYS */;
INSERT INTO `Regions` VALUES ('Center','Basement','Shapiro',1,69,110),('Center','First','Shapiro',1,89,158),('Center','Fourth','Shapiro',1,47,79),('Center','Second','Shapiro',1,101,138),('North','Basement','Shapiro',0,44,59),('North','First','Shapiro',0,108,156),('North','Fourth','Shapiro',0,89,74),('North','Second','Shapiro',0,35,79),('North','Third','Shapiro',0,86,139),('South','Basement','Shapiro',2,54,49),('South','First','Shapiro',2,126,90),('South','Fourth','Shapiro',2,30,75),('South','Second','Shapiro',2,97,125),('South','Third','Shapiro',1,60,67);
/*!40000 ALTER TABLE `Regions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-08 14:58:22
