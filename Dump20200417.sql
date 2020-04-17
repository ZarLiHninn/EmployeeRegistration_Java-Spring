-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: employee_data
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'IT'),(2,'HR'),(3,'SALES');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `entry_date` date DEFAULT NULL,
  `leave_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `department_id_idx` (`department_id`),
  CONSTRAINT `department_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Zar Li Hnin',32,3,'FEMALE','2020-02-29','2020-04-01'),(2,'Thet Mhue',20,3,'FEMALE','2020-03-02','2020-05-20'),(3,'Aye Aye Myo',35,1,'FEMALE','2020-02-23','2020-03-24'),(5,'Khaing Wutt Mhone',24,3,'FEMALE','2020-01-24','2020-03-29'),(6,'Nyi Nyi Khinn',45,2,'MALE','2020-01-31','2020-04-02'),(7,'Thue Htet Pyae',19,2,'MALE','2019-02-04','2020-04-02'),(8,'Khin Yadanar',24,2,'FEMALE','2020-04-14','2020-04-17'),(9,'Thet Thet Aung',40,1,'FEMALE','2020-02-29','2020-03-10'),(10,'Zaw Zaw Aung',36,1,'MALE','2020-03-01','2020-03-18'),(11,'Kyaw Nanda',45,2,'MALE','2020-04-04','2020-04-23'),(12,'Khaing Thu Zar',33,1,'FEMALE','2020-03-03','2020-04-04'),(13,'Zar Li Hnin',30,2,'FEMALE','2020-03-03','2020-04-04'),(14,'Zar Li Hnin',33,3,'FEMALE','2020-04-04','2020-04-25'),(15,'非検査例外発生',35,3,'FEMALE','2020-04-23','2020-03-20'),(16,'Khin Myint Oo',22,NULL,'FEMALE','2020-03-03','2020-05-22'),(18,'Kyaw Wai Lwin',30,1,'MALE','2020-03-03','2020-05-22'),(19,'Aung Aung ',33,2,'MALE','2020-03-03','2020-03-13'),(20,'Khin Zaw',44,1,'MALE','2020-04-04','2020-04-25'),(22,'Kyar Nyo Thin',33,1,'FEMALE','2020-03-04','2020-04-04'),(23,'Nwe Nwe Oo',33,2,'FEMALE','2020-04-04','2020-03-30'),(24,'Soe Moe',44,3,'MALE','2020-04-03','2020-04-25'),(25,'Tin Tin Nyo',40,3,'FEMALE','2020-03-03','2020-05-22'),(26,'Litwak John',34,3,'MALE','2020-03-03','2020-03-26'),(27,'Aung Naing Khin',45,2,'MALE','2020-03-03','2020-04-25'),(28,'Kyaw Ye Aung',44,3,'MALE','2020-03-03','2020-04-25'),(29,'Khaing Mon Mon Aung',33,1,'FEMALE','2020-03-03','2020-04-25'),(30,'Tin Aung Moe',40,2,'MALE','2020-02-03','2020-04-14'),(31,'Thet Mhue ',20,3,'FEMALE','2020-03-03','2020-05-21'),(32,'Myo Naing Win',44,2,'MALE','2020-03-11','2020-03-13'),(33,'Myo Naing Win',44,2,'MALE','2020-03-11','2020-03-13'),(34,'sadfasfsad',32,2,'MALE','2020-03-03','2020-04-18'),(35,'Khin Maung Win',40,2,'MALE','2020-04-03','2020-04-24'),(36,'Yu Ya Naing',30,1,'FEMALE','2020-02-02','2020-04-03'),(37,'Soe Yan Min',33,2,'MALE','2020-03-02','2020-04-23'),(39,'Thet Naing',34,3,'MALE','2020-04-03','2020-04-18'),(40,'Khin Sann Yu',33,1,'FEMALE','2020-03-02','2020-03-29'),(41,'Zaw Min Oo',40,2,'MALE','2020-04-22','2020-05-21'),(42,'Khaing Moe',44,3,'FEMALE','2020-04-03','2020-04-24');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-17 19:17:34
