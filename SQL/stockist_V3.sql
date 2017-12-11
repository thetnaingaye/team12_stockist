CREATE DATABASE  IF NOT EXISTS `stockist` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `stockist`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: stockist
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `damagerecords`
--

DROP TABLE IF EXISTS `damagerecords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `damagerecords` (
  `RMAID` int(11) NOT NULL AUTO_INCREMENT,
  `Products_PartID` int(11) NOT NULL,
  `Qty` int(11) DEFAULT NULL,
  `DateRecorded` datetime DEFAULT NULL,
  `Remarks` longtext,
  PRIMARY KEY (`RMAID`),
  KEY `fk_DamageRecords_Products1_idx` (`Products_PartID`),
  CONSTRAINT `fk_DamageRecords_Products1` FOREIGN KEY (`Products_PartID`) REFERENCES `products` (`PartID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `damagerecords`
--

LOCK TABLES `damagerecords` WRITE;
/*!40000 ALTER TABLE `damagerecords` DISABLE KEYS */;
INSERT INTO `damagerecords` VALUES (1,123,3,'2017-12-03 00:00:00','light fuse break'),(2,234,3,'2017-11-25 00:00:00',NULL),(3,3456,2,'2017-11-30 00:00:00',NULL),(4,4564,2,'2017-12-02 00:00:00',NULL),(5,9342,1,'2017-12-03 00:00:00',NULL);
/*!40000 ALTER TABLE `damagerecords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `PartID` int(11) NOT NULL,
  `Description` longtext,
  `UnitPrice` decimal(18,2) DEFAULT NULL,
  `Color` longtext,
  `Dimension` longtext,
  `Manufacturer` longtext,
  `ReorderLevel` int(11) DEFAULT NULL,
  `MinReorderQty` int(11) DEFAULT NULL,
  `ShelfLocation` varchar(45) DEFAULT NULL,
  `SupplierID` varchar(45) NOT NULL,
  `UnitsInStock` int(11) DEFAULT NULL,
  `UnitsOnOrder` int(11) DEFAULT NULL,
  `Discontinued` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`PartID`),
  KEY `fk_Products_Suppliers1_idx` (`SupplierID`),
  CONSTRAINT `fk_Products_Suppliers1` FOREIGN KEY (`SupplierID`) REFERENCES `suppliers` (`SupplierID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (123,'light bulb',1.23,'white','2cm','toyota',20,1,'1A','S1',123,1,0),(234,'Steelmate TPMS TP-S3E',255.00,'Black','NULL','Toyota',50,25,'4C','S1',56,5,0),(1876,'Low Beam H7 12V',0.99,'White','NULL','Honda',60,30,'2B','S1',145,9,0),(2346,'Pair Tie Rod Ball Joint ',10.55,'Silver','81mm','Honda',45,20,'2C','S1',290,0,0),(2593,'Mercedes Benz Steering Gear',45.34,'Black','NULL','Merzedez Benz',35,10,'2C','S1',75,0,0),(2786,'Iridium Tough Spark Plug - VK20',31.56,'Silver','NULL','Toyota',40,25,'2A','S1',65,30,0),(3265,'GM Rear Liftgate Hands Closing Module',75.90,'Silver','NULL','General Motors',30,10,'9F','S1',10,1,0),(3456,'Cellink B3 battery pack',254.00,'Black','NULL','Toyota',20,5,'5D','S1',98,0,0),(4564,'Thinkware X550-2CH',743.33,'Silver','2.7 LCD\"','Toyota',5,0,'1A','S1',12,0,0),(9342,'Plasmacluster Ion Generator ',98.50,'Gold','5cm (h) x 6.5cm (base) x 7.6cm (top)','Toyota',25,3,'4C','S1',67,0,0);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suppliers` (
  `SupplierID` varchar(45) NOT NULL,
  `CompanyName` longtext NOT NULL,
  `ContactNumber` varchar(45) DEFAULT NULL,
  `Address` longtext,
  PRIMARY KEY (`SupplierID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES ('S1','Borneo','66668888','Queenstown'),('S10','Zion Auto Gallery Pte Ltd','64876627','Blk 105, Gangsa Road, #02-103, Singapore 2367'),('S11','Think One Automobile','61337446','Blk 671, Woodlands Dr 71 #04-51, Singapore 0512'),('S12','Zenith Automobile','60627330','Blk 56, #08-161 Telok Blangah Heights, Singapore 0410'),('S13','Wunder Auto Pte Ltd','66396294','Blk 267 Sembawang Drive #08-349 Singapore 2369'),('S2','Global Carz Pte Ltd','62788944','Blk 99, Balestier Road, #12-168, Singapore 1232'),('S3','Hoe Beng Auto Trading','61378791','Blk 20, Eunos Crescent, #04-2965, Singapore 1400'),('S4','Hong Seh Motors Pte Ltd','61772299','Blk 61, Upper Paya Lebar Road, Singapore 1953'),('S5','Index Credit Pte Ltd','63353246','Blk 89, Zion Road, #16-137, Singapore 0316'),('S6','Kao Lian Enterprise','67134432','Block 88 Demsey Road #01-01, Singapore 1234'),('S7','Karz Automobile Pte Ltd','64521637','Blk 749, Pasir Ris St 71, #09-66, Singapore 1651'),('S8','Ken Jie Cars','66248675','Blk 12, Dover Close East, #08-208, Singapore 1027'),('S9','HTS Motor','67347064','Blk 27, Marine Crescent, #05-05, Singapore 2345');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usagerecorddetails`
--

DROP TABLE IF EXISTS `usagerecorddetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usagerecorddetails` (
  `TransDetailID` int(11) NOT NULL AUTO_INCREMENT,
  `TransID` varchar(255) NOT NULL,
  `Products_PartID` int(11) NOT NULL,
  `UsedQty` int(11) NOT NULL,
  PRIMARY KEY (`TransDetailID`),
  KEY `fk_UsageRecordDetails_Products1_idx` (`Products_PartID`),
  KEY `fk_usagerecorddetails_usagerecords1_idx` (`TransID`),
  CONSTRAINT `fk_UsageRecordDetails_Products1` FOREIGN KEY (`Products_PartID`) REFERENCES `products` (`PartID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usagerecorddetails_usagerecords1` FOREIGN KEY (`TransID`) REFERENCES `usagerecords` (`TransID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usagerecorddetails`
--

LOCK TABLES `usagerecorddetails` WRITE;
/*!40000 ALTER TABLE `usagerecorddetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `usagerecorddetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usagerecords`
--

DROP TABLE IF EXISTS `usagerecords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usagerecords` (
  `TransID` varchar(255) NOT NULL,
  `CustomerName` longtext,
  `DateUsed` datetime DEFAULT NULL,
  `UserID` int(11) DEFAULT NULL,
  PRIMARY KEY (`TransID`),
  KEY `fk_usagerecords_users1_idx` (`UserID`),
  CONSTRAINT `fk_usagerecords_users1` FOREIGN KEY (`UserID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usagerecords`
--

LOCK TABLES `usagerecords` WRITE;
/*!40000 ALTER TABLE `usagerecords` DISABLE KEYS */;
/*!40000 ALTER TABLE `usagerecords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `UserRole` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UserName_UNIQUE` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Jason','1234','mechanic'),(2,'Naing','1234','mechanic'),(3,'Sum','1234','mechanic'),(4,'ChangSiang','1234','mechanic'),(5,'Alice','1234','admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-10 18:30:12
