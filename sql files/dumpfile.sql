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
INSERT INTO `Floors` VALUES ('Shapiro','Basement',0,100,219),('Shapiro','First',1,237,404),('Shapiro','Fourth',4,101,228),('Shapiro','Second',2,109,342),('Shapiro','Third',3,67,206);
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
INSERT INTO `Hour_Average` VALUES ('Basement','Shapiro',0,0.407154),('Basement','Shapiro',1,0.211948),('Basement','Shapiro',2,0.146499),('Basement','Shapiro',3,0.116819),('Basement','Shapiro',4,0.113013),('Basement','Shapiro',5,0.114915),('Basement','Shapiro',6,0.112252),('Basement','Shapiro',7,0.10959),('Basement','Shapiro',8,0.114155),('Basement','Shapiro',9,0.159057),('Basement','Shapiro',10,0.328767),('Basement','Shapiro',11,0.43379),('Basement','Shapiro',12,0.490487),('Basement','Shapiro',13,0.539573),('Basement','Shapiro',14,0.555175),('Basement','Shapiro',15,0.71347),('Basement','Shapiro',16,0.800228),('Basement','Shapiro',17,0.797566),('Basement','Shapiro',18,0.826484),('Basement','Shapiro',19,0.98516),('Basement','Shapiro',20,1.00875),('Basement','Shapiro',21,1.00532),('Basement','Shapiro',22,0.854262),('Basement','Shapiro',23,0.647259),('First','Shapiro',0,0.381394),('First','Shapiro',1,0.211221),('First','Shapiro',2,0.133044),('First','Shapiro',3,0.0829209),('First','Shapiro',4,0.0591998),('First','Shapiro',5,0.0424918),('First','Shapiro',6,0.0334159),('First','Shapiro',7,0.0466172),('First','Shapiro',8,0.119224),('First','Shapiro',9,0.249381),('First','Shapiro',10,0.47298),('First','Shapiro',11,0.561056),('First','Shapiro',12,0.64047),('First','Shapiro',13,0.669967),('First','Shapiro',14,0.772277),('First','Shapiro',15,0.780116),('First','Shapiro',16,0.854167),('First','Shapiro',17,0.853341),('First','Shapiro',18,0.842615),('First','Shapiro',19,0.873556),('First','Shapiro',20,0.907383),('First','Shapiro',21,0.854372),('First','Shapiro',22,0.73453),('First','Shapiro',23,0.597978),('Fourth','Shapiro',0,0.395102),('Fourth','Shapiro',1,0.283991),('Fourth','Shapiro',2,0.187135),('Fourth','Shapiro',3,0.0833333),('Fourth','Shapiro',4,0.0449561),('Fourth','Shapiro',5,0.0391081),('Fourth','Shapiro',6,0.0354532),('Fourth','Shapiro',7,0.0347222),('Fourth','Shapiro',8,0.0683479),('Fourth','Shapiro',9,0.179459),('Fourth','Shapiro',10,0.247442),('Fourth','Shapiro',11,0.365497),('Fourth','Shapiro',12,0.551535),('Fourth','Shapiro',13,0.498904),('Fourth','Shapiro',14,0.602339),('Fourth','Shapiro',15,0.609649),('Fourth','Shapiro',16,0.629752),('Fourth','Shapiro',17,0.524123),('Fourth','Shapiro',18,0.497441),('Fourth','Shapiro',19,0.580044),('Fourth','Shapiro',20,0.677997),('Fourth','Shapiro',21,0.714547),('Fourth','Shapiro',22,0.654605),('Fourth','Shapiro',23,0.525951),('Second','Shapiro',0,0.391326),('Second','Shapiro',1,0.263159),('Second','Shapiro',2,0.187621),('Second','Shapiro',3,0.127192),('Second','Shapiro',4,0.0877193),('Second','Shapiro',5,0.0738305),('Second','Shapiro',6,0.0567739),('Second','Shapiro',7,0.0584795),('Second','Shapiro',8,0.0845517),('Second','Shapiro',9,0.157408),('Second','Shapiro',10,0.285088),('Second','Shapiro',11,0.2846),('Second','Shapiro',12,0.468324),('Second','Shapiro',13,0.56774),('Second','Shapiro',14,0.537036),('Second','Shapiro',15,0.57578),('Second','Shapiro',16,0.597222),('Second','Shapiro',17,0.591862),('Second','Shapiro',18,0.576267),('Second','Shapiro',19,0.707359),('Second','Shapiro',20,0.793616),('Second','Shapiro',21,0.754386),('Second','Shapiro',22,0.674464),('Second','Shapiro',23,0.545566),('Third','Shapiro',0,0.21157),('Third','Shapiro',1,0.236246),('Third','Shapiro',2,0.204288),('Third','Shapiro',3,0.139158),('Third','Shapiro',4,0.0687702),('Third','Shapiro',5,0.0469256),('Third','Shapiro',6,0.0299352),('Third','Shapiro',7,0.0554208),('Third','Shapiro',8,0.120954),('Third','Shapiro',9,0.237459),('Third','Shapiro',10,0.245551),('Third','Shapiro',11,0.283172),('Third','Shapiro',12,0.588188),('Third','Shapiro',13,0.730178),('Third','Shapiro',14,0.63309),('Third','Shapiro',15,0.722492),('Third','Shapiro',16,0.755664),('Third','Shapiro',17,0.618931),('Third','Shapiro',18,0.59911),('Third','Shapiro',19,0.706717),('Third','Shapiro',20,0.816747),('Third','Shapiro',21,0.810275),('Third','Shapiro',22,0.748383),('Third','Shapiro',23,0.546116);
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
INSERT INTO `Libraries` VALUES ('Shapiro',664,1400);
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
  `day_index` int(11) NOT NULL DEFAULT '0',
  `day_string` varchar(10) DEFAULT NULL,
  `fill_average` float DEFAULT NULL,
  PRIMARY KEY (`library_name`,`hour`,`day_index`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Library_Hour_Average`
--

LOCK TABLES `Library_Hour_Average` WRITE;
/*!40000 ALTER TABLE `Library_Hour_Average` DISABLE KEYS */;
INSERT INTO `Library_Hour_Average` VALUES ('Shapiro',0,1,'Monday',0.181369),('Shapiro',0,2,'Tuesday',0.254436),('Shapiro',0,3,'Wednesday',0.30326),('Shapiro',0,4,'Thursday',0.0211584),('Shapiro',0,5,'Friday',0.0205993),('Shapiro',0,6,'Saturday',0.0204631),('Shapiro',0,7,'Sunday',0.0210129),('Shapiro',1,1,'Monday',0.127223),('Shapiro',1,2,'Tuesday',0.184786),('Shapiro',1,3,'Wednesday',0.229413),('Shapiro',1,4,'Thursday',0.0201619),('Shapiro',1,5,'Friday',0.0199921),('Shapiro',1,6,'Saturday',0.0205889),('Shapiro',1,7,'Sunday',0.0208558),('Shapiro',2,1,'Monday',0.0870858),('Shapiro',2,2,'Tuesday',0.125245),('Shapiro',2,3,'Wednesday',0.147101),('Shapiro',2,4,'Thursday',0.0206825),('Shapiro',2,5,'Friday',0.0202501),('Shapiro',2,6,'Saturday',0.0206397),('Shapiro',2,7,'Sunday',0.0201927),('Shapiro',3,1,'Monday',0.0568254),('Shapiro',3,2,'Tuesday',0.0847266),('Shapiro',3,3,'Wednesday',0.0958111),('Shapiro',3,4,'Thursday',0.0203118),('Shapiro',3,5,'Friday',0.0201175),('Shapiro',3,6,'Saturday',0.0206715),('Shapiro',3,7,'Sunday',0.0206027),('Shapiro',4,1,'Monday',0.0404252),('Shapiro',4,2,'Tuesday',0.0631),('Shapiro',4,3,'Wednesday',0.0655006),('Shapiro',4,4,'Thursday',0.0209172),('Shapiro',4,5,'Friday',0.0204296),('Shapiro',4,6,'Saturday',0.020598),('Shapiro',4,7,'Sunday',0.0209824),('Shapiro',5,1,'Monday',0.0355098),('Shapiro',5,2,'Tuesday',0.0530649),('Shapiro',5,3,'Wednesday',0.0577161),('Shapiro',5,4,'Thursday',0.0205322),('Shapiro',5,5,'Friday',0.020315),('Shapiro',5,6,'Saturday',0.0205939),('Shapiro',5,7,'Sunday',0.0206223),('Shapiro',6,1,'Monday',0.0325672),('Shapiro',6,2,'Tuesday',0.0424167),('Shapiro',6,3,'Wednesday',0.0492177),('Shapiro',6,4,'Thursday',0.0203845),('Shapiro',6,5,'Friday',0.0195558),('Shapiro',6,6,'Saturday',0.0210954),('Shapiro',6,7,'Sunday',0.0210334),('Shapiro',7,1,'Monday',0.0544646),('Shapiro',7,2,'Tuesday',0.0583766),('Shapiro',7,3,'Wednesday',0.0689012),('Shapiro',7,4,'Thursday',0.0208987),('Shapiro',7,5,'Friday',0.0198628),('Shapiro',7,6,'Saturday',0.0213515),('Shapiro',7,7,'Sunday',0.020381),('Shapiro',8,1,'Monday',0.0997033),('Shapiro',8,2,'Tuesday',0.118642),('Shapiro',8,3,'Wednesday',0.119657),('Shapiro',8,4,'Thursday',0.0208623),('Shapiro',8,5,'Friday',0.0202241),('Shapiro',8,6,'Saturday',0.0237648),('Shapiro',8,7,'Sunday',0.021816),('Shapiro',9,1,'Monday',0.209392),('Shapiro',9,2,'Tuesday',0.207658),('Shapiro',9,3,'Wednesday',0.212743),('Shapiro',9,4,'Thursday',0.0204366),('Shapiro',9,5,'Friday',0.0212225),('Shapiro',9,6,'Saturday',0.0248304),('Shapiro',9,7,'Sunday',0.0268518),('Shapiro',10,1,'Monday',0.299282),('Shapiro',10,2,'Tuesday',0.354357),('Shapiro',10,3,'Wednesday',0.327379),('Shapiro',10,4,'Thursday',0.0212228),('Shapiro',10,5,'Friday',0.0205476),('Shapiro',10,6,'Saturday',0.0479931),('Shapiro',10,7,'Sunday',0.154016),('Shapiro',11,1,'Monday',0.43357),('Shapiro',11,2,'Tuesday',0.492164),('Shapiro',11,3,'Wednesday',0.401743),('Shapiro',11,4,'Thursday',0.0210194),('Shapiro',11,5,'Friday',0.0213617),('Shapiro',11,6,'Saturday',0.0689428),('Shapiro',11,7,'Sunday',0.316638),('Shapiro',12,1,'Monday',0.494499),('Shapiro',12,2,'Tuesday',0.575443),('Shapiro',12,3,'Wednesday',0.162528),('Shapiro',12,4,'Thursday',0.0212425),('Shapiro',12,5,'Friday',0.0219708),('Shapiro',12,6,'Saturday',0.0708411),('Shapiro',12,7,'Sunday',0.483452),('Shapiro',13,1,'Monday',0.49401),('Shapiro',13,2,'Tuesday',0.595815),('Shapiro',13,3,'Wednesday',0.152795),('Shapiro',13,4,'Thursday',0.0221174),('Shapiro',13,5,'Friday',0.0222172),('Shapiro',13,6,'Saturday',0.0944654),('Shapiro',13,7,'Sunday',0.566503),('Shapiro',14,1,'Monday',0.592536),('Shapiro',14,2,'Tuesday',0.620899),('Shapiro',14,3,'Wednesday',0.157701),('Shapiro',14,4,'Thursday',0.0225224),('Shapiro',14,5,'Friday',0.0222245),('Shapiro',14,6,'Saturday',0.106031),('Shapiro',14,7,'Sunday',0.605109),('Shapiro',15,1,'Monday',0.660024),('Shapiro',15,2,'Tuesday',0.713127),('Shapiro',15,3,'Wednesday',0.0701754),('Shapiro',15,4,'Thursday',0.0208729),('Shapiro',15,5,'Friday',0.0210068),('Shapiro',15,6,'Saturday',0.141088),('Shapiro',15,7,'Sunday',0.623015),('Shapiro',16,1,'Monday',0.625991),('Shapiro',16,2,'Tuesday',0.703644),('Shapiro',16,3,'Wednesday',0.107012),('Shapiro',16,4,'Thursday',0.0204965),('Shapiro',16,5,'Friday',0.0216943),('Shapiro',16,6,'Saturday',0.164253),('Shapiro',16,7,'Sunday',0.621116),('Shapiro',17,1,'Monday',0.615405),('Shapiro',17,2,'Tuesday',0.638587),('Shapiro',17,3,'Wednesday',0.0929283),('Shapiro',17,4,'Thursday',0.0211571),('Shapiro',17,5,'Friday',0.022039),('Shapiro',17,6,'Saturday',0.161377),('Shapiro',17,7,'Sunday',0.518333),('Shapiro',18,1,'Monday',0.656049),('Shapiro',18,2,'Tuesday',0.668144),('Shapiro',18,3,'Wednesday',0.0772437),('Shapiro',18,4,'Thursday',0.0212269),('Shapiro',18,5,'Friday',0.0200888),('Shapiro',18,6,'Saturday',0.168992),('Shapiro',18,7,'Sunday',0.472319),('Shapiro',19,1,'Monday',0.699882),('Shapiro',19,2,'Tuesday',0.776584),('Shapiro',19,3,'Wednesday',0.0874223),('Shapiro',19,4,'Thursday',0.0210809),('Shapiro',19,5,'Friday',0.0217051),('Shapiro',19,6,'Saturday',0.190962),('Shapiro',19,7,'Sunday',0.513849),('Shapiro',20,1,'Monday',0.753008),('Shapiro',20,2,'Tuesday',0.824831),('Shapiro',20,3,'Wednesday',0.0877108),('Shapiro',20,4,'Thursday',0.0203988),('Shapiro',20,5,'Friday',0.0213396),('Shapiro',20,6,'Saturday',0.193245),('Shapiro',20,7,'Sunday',0.556915),('Shapiro',21,1,'Monday',0.706906),('Shapiro',21,2,'Tuesday',0.786995),('Shapiro',21,3,'Wednesday',0.0775135),('Shapiro',21,4,'Thursday',0.0206307),('Shapiro',21,5,'Friday',0.0216226),('Shapiro',21,6,'Saturday',0.186963),('Shapiro',21,7,'Sunday',0.511098),('Shapiro',22,1,'Monday',0.598219),('Shapiro',22,2,'Tuesday',0.682609),('Shapiro',22,3,'Wednesday',0.06823),('Shapiro',22,4,'Thursday',0.0198834),('Shapiro',22,5,'Friday',0.0214093),('Shapiro',22,6,'Saturday',0.148084),('Shapiro',22,7,'Sunday',0.360208),('Shapiro',23,1,'Monday',0.400004),('Shapiro',23,2,'Tuesday',0.483015),('Shapiro',23,3,'Wednesday',0.0359399),('Shapiro',23,4,'Thursday',0.0200785),('Shapiro',23,5,'Friday',0.0218693),('Shapiro',23,6,'Saturday',0.0755653),('Shapiro',23,7,'Sunday',0.259707);
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
INSERT INTO `Regions` VALUES ('Center','Basement','Shapiro',1,39,110),('Center','First','Shapiro',1,72,158),('Center','Fourth','Shapiro',1,12,79),('Center','Second','Shapiro',1,43,138),('North','Basement','Shapiro',0,20,59),('North','First','Shapiro',0,101,156),('North','Fourth','Shapiro',0,83,74),('North','Second','Shapiro',0,33,79),('North','Third','Shapiro',0,50,139),('South','Basement','Shapiro',2,41,49),('South','First','Shapiro',2,64,90),('South','Fourth','Shapiro',2,6,75),('South','Second','Shapiro',2,33,125),('South','Third','Shapiro',1,16,67);
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

-- Dump completed on 2015-12-04 22:23:43
