-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: db1
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `enabled` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(60) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('prashant','iamrobin',1,'prashant','7488448126',23,'patna','rt@gmail.com'),('raja','iamraja',1,'raja baidyo','8986590300',20,'patna','vk@gmail.com'),('raja123','raja123',1,'raja','8984478374',10,'arunachal','raja@gmail.com'),('robin','tgrs2@tgrs',1,'robin','8986590300',15,'patna','vkrobin10@gmail.com'),('shikha','teacher@123',1,'shikha saxena','7488448126',20,'patna','vkshikha@gmail.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL,
  KEY `user` (`user`),
  CONSTRAINT `users_roles_ibfk_1` FOREIGN KEY (`user`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES ('robin','ROLE_ADMIN'),('raja','ROLE_USER'),('shikha','ROLE_TEACHER'),('prashant','ROLE_TEACHER'),('raja123','ROLE_TEACHER');
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `courseName` varchar(30) NOT NULL,
  `batchYear` varchar(5) NOT NULL,
  PRIMARY KEY (`courseName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('10th','2019'),('11th','2019'),('8th','2019'),('9th','2019');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `subjectName` varchar(30) NOT NULL,
  `courseName` varchar(30) NOT NULL,
  `timetable` varchar(200) NOT NULL,
  PRIMARY KEY (`subjectName`),
  KEY `courseName` (`courseName`),
  CONSTRAINT `subject_ibfk_2` FOREIGN KEY (`courseName`) REFERENCES `course` (`courseName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES ('biology','8th','10AM monday,wednesday'),('physics','10th','7AM monday-friday');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;





--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `blogId` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(200) NOT NULL,
  `subjectName` varchar(30) NOT NULL,
  `date` varchar(15) NOT NULL,
  PRIMARY KEY (`blogId`),
  KEY `subjectName` (`subjectName`),
  CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`subjectName`) REFERENCES `subject` (`subjectName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (1,'tommorrow is the last day of physics assignment submission','physics','24-10-2019'),(2,'submit assignments','physics','24-10-2019');
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blogcomments`
--

DROP TABLE IF EXISTS `blogcomments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blogcomments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(200) NOT NULL,
  `blogId` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `blogId` (`blogId`),
  KEY `username` (`username`),
  CONSTRAINT `blogcomments_ibfk_1` FOREIGN KEY (`blogId`) REFERENCES `blog` (`blogId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `blogcomments_ibfk_2` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blogcomments`
--

LOCK TABLES `blogcomments` WRITE;
/*!40000 ALTER TABLE `blogcomments` DISABLE KEYS */;
INSERT INTO `blogcomments` VALUES (1,'ok sir',1,'raja');
/*!40000 ALTER TABLE `blogcomments` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
  `examId` int(11) NOT NULL AUTO_INCREMENT,
  `venue` varchar(50) NOT NULL,
  `subjectName` varchar(30) NOT NULL,
  `examDate` varchar(30) NOT NULL,
  `time` varchar(15) NOT NULL,
  PRIMARY KEY (`examId`),
  KEY `subjectName` (`subjectName`),
  CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`subjectName`) REFERENCES `subject` (`subjectName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,'lt theatre','biology','25-11-2019','6PM'),(2,'swatantrata bhawan','physics','23-10-2019','6pm');
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examresult`
--

DROP TABLE IF EXISTS `examresult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examresult` (
  `totalmarks` int(11) NOT NULL,
  `marksObtained` int(11) NOT NULL,
  `percentile` int(11) NOT NULL,
  `resultId` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  PRIMARY KEY (`resultId`),
  KEY `examId` (`examId`),
  KEY `username` (`username`),
  CONSTRAINT `examresult_ibfk_1` FOREIGN KEY (`examId`) REFERENCES `exam` (`examId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `examresult_ibfk_2` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examresult`
--

LOCK TABLES `examresult` WRITE;
/*!40000 ALTER TABLE `examresult` DISABLE KEYS */;
INSERT INTO `examresult` VALUES (100,99,100,1,1,'raja');
/*!40000 ALTER TABLE `examresult` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(200) NOT NULL,
  `teacher` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher` (`teacher`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`teacher`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'great communication skills of teacher','shikha','17-10-2019');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guardian`
--

DROP TABLE IF EXISTS `guardian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guardian` (
  `guardianId` int(11) NOT NULL AUTO_INCREMENT,
  `relation` varchar(30) NOT NULL,
  `contactInfo` varchar(15) NOT NULL,
  `username` varchar(30) NOT NULL,
  `guardianname` varchar(30) NOT NULL,
  PRIMARY KEY (`guardianId`),
  KEY `username` (`username`),
  CONSTRAINT `guardian_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guardian`
--

LOCK TABLES `guardian` WRITE;
/*!40000 ALTER TABLE `guardian` DISABLE KEYS */;
INSERT INTO `guardian` VALUES (4,'friend','7488448126','raja','dhruva');
/*!40000 ALTER TABLE `guardian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentenroll`
--

DROP TABLE IF EXISTS `studentenroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentenroll` (
  `enrollId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `courseName` varchar(30) NOT NULL,
  `admissionDate` varchar(30) NOT NULL,
  PRIMARY KEY (`enrollId`),
  KEY `username` (`username`),
  KEY `courseName` (`courseName`),
  CONSTRAINT `studentenroll_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `studentenroll_ibfk_2` FOREIGN KEY (`courseName`) REFERENCES `course` (`courseName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentenroll`
--

LOCK TABLES `studentenroll` WRITE;
/*!40000 ALTER TABLE `studentenroll` DISABLE KEYS */;
INSERT INTO `studentenroll` VALUES (3,'raja','10th','24-10-2019');
/*!40000 ALTER TABLE `studentenroll` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `teaching`
--

DROP TABLE IF EXISTS `teaching`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teaching` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher` varchar(30) NOT NULL,
  `subjectName` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher` (`teacher`),
  KEY `subjectName` (`subjectName`),
  CONSTRAINT `teaching_ibfk_1` FOREIGN KEY (`teacher`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teaching_ibfk_2` FOREIGN KEY (`subjectName`) REFERENCES `subject` (`subjectName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teaching`
--

LOCK TABLES `teaching` WRITE;
/*!40000 ALTER TABLE `teaching` DISABLE KEYS */;
INSERT INTO `teaching` VALUES (1,'shikha','physics'),(2,'prashant','biology'),(3,'raja123','biology');
/*!40000 ALTER TABLE `teaching` ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-17 13:14:52
