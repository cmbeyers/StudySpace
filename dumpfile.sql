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
INSERT INTO `Floors` VALUES ('Shapiro','Basement',0,219),('Shapiro','First',15,404),('Shapiro','Fourth',0,228),('Shapiro','Second',0,342),('Shapiro','Third',0,206);
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
INSERT INTO `Hour_Average` VALUES ('Basement','Shapiro',0,0),('Basement','Shapiro',1,0),('Basement','Shapiro',2,0),('Basement','Shapiro',3,0),('Basement','Shapiro',4,0),('Basement','Shapiro',5,0),('Basement','Shapiro',6,0),('Basement','Shapiro',7,0),('Basement','Shapiro',8,0),('Basement','Shapiro',9,0),('Basement','Shapiro',10,0),('Basement','Shapiro',11,0),('Basement','Shapiro',12,0),('Basement','Shapiro',13,0),('Basement','Shapiro',14,0),('Basement','Shapiro',15,0),('Basement','Shapiro',16,0),('Basement','Shapiro',17,0),('Basement','Shapiro',18,0),('Basement','Shapiro',19,0),('Basement','Shapiro',20,0),('Basement','Shapiro',21,0),('Basement','Shapiro',22,0),('Basement','Shapiro',23,0),('First','Shapiro',0,0),('First','Shapiro',1,0),('First','Shapiro',2,0),('First','Shapiro',3,0),('First','Shapiro',4,0),('First','Shapiro',5,0),('First','Shapiro',6,0),('First','Shapiro',7,0),('First','Shapiro',8,0),('First','Shapiro',9,0),('First','Shapiro',10,0),('First','Shapiro',11,0),('First','Shapiro',12,0),('First','Shapiro',13,0),('First','Shapiro',14,0),('First','Shapiro',15,0),('First','Shapiro',16,0),('First','Shapiro',17,0),('First','Shapiro',18,0),('First','Shapiro',19,0),('First','Shapiro',20,0),('First','Shapiro',21,0),('First','Shapiro',22,0),('First','Shapiro',23,0),('Fourth','Shapiro',0,0),('Fourth','Shapiro',1,0),('Fourth','Shapiro',2,0),('Fourth','Shapiro',3,0),('Fourth','Shapiro',4,0),('Fourth','Shapiro',5,0),('Fourth','Shapiro',6,0),('Fourth','Shapiro',7,0),('Fourth','Shapiro',8,0),('Fourth','Shapiro',9,0),('Fourth','Shapiro',10,0),('Fourth','Shapiro',11,0),('Fourth','Shapiro',12,0),('Fourth','Shapiro',13,0),('Fourth','Shapiro',14,0),('Fourth','Shapiro',15,0),('Fourth','Shapiro',16,0),('Fourth','Shapiro',17,0),('Fourth','Shapiro',18,0),('Fourth','Shapiro',19,0),('Fourth','Shapiro',20,0),('Fourth','Shapiro',21,0),('Fourth','Shapiro',22,0),('Fourth','Shapiro',23,0),('Second','Shapiro',0,0),('Second','Shapiro',1,0),('Second','Shapiro',2,0),('Second','Shapiro',3,0),('Second','Shapiro',4,0),('Second','Shapiro',5,0),('Second','Shapiro',6,0),('Second','Shapiro',7,0),('Second','Shapiro',8,0),('Second','Shapiro',9,0),('Second','Shapiro',10,0),('Second','Shapiro',11,0),('Second','Shapiro',12,0),('Second','Shapiro',13,0),('Second','Shapiro',14,0),('Second','Shapiro',15,0),('Second','Shapiro',16,0),('Second','Shapiro',17,0),('Second','Shapiro',18,0),('Second','Shapiro',19,0),('Second','Shapiro',20,0),('Second','Shapiro',21,0),('Second','Shapiro',22,0),('Second','Shapiro',23,0),('Third','Shapiro',0,0),('Third','Shapiro',1,0),('Third','Shapiro',2,0),('Third','Shapiro',3,0),('Third','Shapiro',4,0),('Third','Shapiro',5,0),('Third','Shapiro',6,0),('Third','Shapiro',7,0),('Third','Shapiro',8,0),('Third','Shapiro',9,0),('Third','Shapiro',10,0),('Third','Shapiro',11,0),('Third','Shapiro',12,0),('Third','Shapiro',13,0),('Third','Shapiro',14,0),('Third','Shapiro',15,0),('Third','Shapiro',16,0),('Third','Shapiro',17,0),('Third','Shapiro',18,0),('Third','Shapiro',19,0),('Third','Shapiro',20,0),('Third','Shapiro',21,0),('Third','Shapiro',22,0),('Third','Shapiro',23,0);
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
INSERT INTO `Libraries` VALUES ('Shapiro',15,1400);
/*!40000 ALTER TABLE `Libraries` ENABLE KEYS */;
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
INSERT INTO `Regions` VALUES ('Center','Basement','Shapiro',0,110),('Center','First','Shapiro',0,158),('Center','Fourth','Shapiro',0,79),('Center','Second','Shapiro',0,138),('North','Basement','Shapiro',0,59),('North','First','Shapiro',0,156),('North','Fourth','Shapiro',0,74),('North','Second','Shapiro',0,79),('North','Third','Shapiro',0,139),('South','Basement','Shapiro',0,49),('South','First','Shapiro',0,90),('South','Fourth','Shapiro',0,75),('South','Second','Shapiro',0,125),('South','Third','Shapiro',0,67);
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

-- Dump completed on 2015-11-04 22:04:37
