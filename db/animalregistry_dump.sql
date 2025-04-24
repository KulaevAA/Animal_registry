-- MySQL dump 10.13  Distrib 5.7.40, for Win32 (AMD64)
--
-- Host: localhost    Database: animalregistry
-- ------------------------------------------------------
-- Server version	5.7.40-log

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
-- Table structure for table `allanimals`
--

DROP TABLE IF EXISTS `allanimals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `allanimals` (
  `ID` int(11) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Type` varchar(50) DEFAULT NULL,
  `BirthDate` date DEFAULT NULL,
  `Commands` text,
  `SourceTable` varchar(20) DEFAULT NULL,
  `AgeInMonths` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allanimals`
--

LOCK TABLES `allanimals` WRITE;
/*!40000 ALTER TABLE `allanimals` DISABLE KEYS */;
INSERT INTO `allanimals` VALUES (1,'Murka','Cat','2023-05-15','Sit, Jump','Pets',23),(2,'Buddy','Dog','2018-12-10','Sit, Stand','Pets',76),(3,'Homa','Hamster','2021-03-10','Roll, Hide','Pets',49),(4,'Whiskers','Cat','2020-06-30','Meow, Jump','Pets',57),(1,'Thunder','Horse','2023-05-15','Trot, Canter, Gallop','PackAnimals',23),(3,'Burro','Donkey','2017-09-18','Walk, Carry Load, Sit','PackAnimals',91),(1,'Murka','Cat','2023-05-15','Sit, Jump','YoungAnimals',23),(1,'Thunder','Horse','2023-05-15','Trot, Canter, Gallop','YoungAnimals',23);
/*!40000 ALTER TABLE `allanimals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horsesanddonkeys`
--

DROP TABLE IF EXISTS `horsesanddonkeys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horsesanddonkeys` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `Name` varchar(50) DEFAULT NULL,
  `Type` enum('Horse','Camel','Donkey') DEFAULT NULL,
  `BirthDate` date DEFAULT NULL,
  `Commands` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horsesanddonkeys`
--

LOCK TABLES `horsesanddonkeys` WRITE;
/*!40000 ALTER TABLE `horsesanddonkeys` DISABLE KEYS */;
INSERT INTO `horsesanddonkeys` VALUES (1,'Thunder','Horse','2015-07-21','Trot, Canter, Gallop'),(3,'Burro','Donkey','2017-09-18','Walk, Carry Load, Sit');
/*!40000 ALTER TABLE `horsesanddonkeys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packanimals`
--

DROP TABLE IF EXISTS `packanimals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `packanimals` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `Type` enum('Horse','Camel','Donkey') DEFAULT NULL,
  `BirthDate` date DEFAULT NULL,
  `Commands` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packanimals`
--

LOCK TABLES `packanimals` WRITE;
/*!40000 ALTER TABLE `packanimals` DISABLE KEYS */;
INSERT INTO `packanimals` VALUES (1,'Thunder','Horse','2023-05-15','Trot, Canter, Gallop'),(3,'Burro','Donkey','2017-09-18','Walk, Carry Load, Sit');
/*!40000 ALTER TABLE `packanimals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pets`
--

DROP TABLE IF EXISTS `pets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pets` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `Type` enum('Dog','Cat','Hamster') DEFAULT NULL,
  `BirthDate` date DEFAULT NULL,
  `Commands` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pets`
--

LOCK TABLES `pets` WRITE;
/*!40000 ALTER TABLE `pets` DISABLE KEYS */;
INSERT INTO `pets` VALUES (1,'Murka','Cat','2023-05-15','Sit, Jump'),(2,'Buddy','Dog','2018-12-10','Sit, Stand'),(3,'Homa','Hamster','2021-03-10','Roll, Hide'),(4,'Whiskers','Cat','2020-06-30','Meow, Jump');
/*!40000 ALTER TABLE `pets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `younganimals`
--

DROP TABLE IF EXISTS `younganimals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `younganimals` (
  `ID` int(11) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Type` varchar(50) DEFAULT NULL,
  `BirthDate` date DEFAULT NULL,
  `Commands` text,
  `AgeInMonths` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `younganimals`
--

LOCK TABLES `younganimals` WRITE;
/*!40000 ALTER TABLE `younganimals` DISABLE KEYS */;
INSERT INTO `younganimals` VALUES (1,'Murka','Cat','2023-05-15','Sit, Jump',23),(1,'Thunder','Horse','2023-05-15','Trot, Canter, Gallop',23);
/*!40000 ALTER TABLE `younganimals` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-24 20:00:28
