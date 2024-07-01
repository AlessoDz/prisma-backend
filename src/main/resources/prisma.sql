CREATE DATABASE  IF NOT EXISTS `prisma` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `prisma`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: prisma
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
                         `id_admin` varchar(10) NOT NULL,
                         `password` varchar(255) DEFAULT NULL,
                         `profile` varchar(255) DEFAULT NULL,
                         `id_user` bigint DEFAULT NULL,
                         PRIMARY KEY (`id_admin`),
                         UNIQUE KEY `UK9vm4uu4nvcv1lgmgrqdo5vlrg` (`id_user`),
                         CONSTRAINT `FK4ert0ej65rd0y5e7b7ukmi82t` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicant`
--

DROP TABLE IF EXISTS `applicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applicant` (
                             `id_applicant` varchar(10) NOT NULL,
                             `id_user` bigint DEFAULT NULL,
                             PRIMARY KEY (`id_applicant`),
                             UNIQUE KEY `UKtgp7gqvjotvbt6879jyvlxbdn` (`id_user`),
                             CONSTRAINT `FKmn0pw9ch0kalw4qs306gux9uy` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant`
--

LOCK TABLES `applicant` WRITE;
/*!40000 ALTER TABLE `applicant` DISABLE KEYS */;
/*!40000 ALTER TABLE `applicant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
                         `id_class` bigint NOT NULL AUTO_INCREMENT,
                         `day` varchar(255) DEFAULT NULL,
                         `end_time` time(6) DEFAULT NULL,
                         `start_time` time(6) DEFAULT NULL,
                         `id_classroom` bigint DEFAULT NULL,
                         `id_course` bigint DEFAULT NULL,
                         `id_teacher` varchar(10) DEFAULT NULL,
                         PRIMARY KEY (`id_class`),
                         KEY `FK45omcp4kjjfm2rk43cccqbvv3` (`id_classroom`),
                         KEY `FKmgykbnc31e15wbwnms085l9tv` (`id_course`),
                         KEY `FKgt2pwx13so4rdtnjxh2wvtwhk` (`id_teacher`),
                         CONSTRAINT `FK45omcp4kjjfm2rk43cccqbvv3` FOREIGN KEY (`id_classroom`) REFERENCES `classroom` (`id_classroom`),
                         CONSTRAINT `FKgt2pwx13so4rdtnjxh2wvtwhk` FOREIGN KEY (`id_teacher`) REFERENCES `teacher` (`id_teacher`),
                         CONSTRAINT `FKmgykbnc31e15wbwnms085l9tv` FOREIGN KEY (`id_course`) REFERENCES `course` (`id_course`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classroom`
--

DROP TABLE IF EXISTS `classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classroom` (
                             `id_classroom` bigint NOT NULL AUTO_INCREMENT,
                             `code` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id_classroom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
                          `id_course` bigint NOT NULL AUTO_INCREMENT,
                          `name` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id_course`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
                           `id_message` bigint NOT NULL AUTO_INCREMENT,
                           `content` varchar(255) DEFAULT NULL,
                           `message_type` varchar(255) DEFAULT NULL,
                           `revised` bit(1) NOT NULL,
                           `sent_date` datetime(6) DEFAULT NULL,
                           `title` varchar(255) DEFAULT NULL,
                           `id_receiver` bigint DEFAULT NULL,
                           `id_sender` bigint DEFAULT NULL,
                           PRIMARY KEY (`id_message`),
                           KEY `FKqyxddlqh59ce3gqls6qu9w3lq` (`id_receiver`),
                           KEY `FK249t1hnaxlacjng5xtud18fi` (`id_sender`),
                           CONSTRAINT `FK249t1hnaxlacjng5xtud18fi` FOREIGN KEY (`id_sender`) REFERENCES `user` (`id_user`),
                           CONSTRAINT `FKqyxddlqh59ce3gqls6qu9w3lq` FOREIGN KEY (`id_receiver`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
                                `id_notification` bigint NOT NULL AUTO_INCREMENT,
                                `creation_date` datetime(6) DEFAULT NULL,
                                `message` varchar(255) DEFAULT NULL,
                                `revised` bit(1) NOT NULL,
                                `title` varchar(255) DEFAULT NULL,
                                `id_user` bigint DEFAULT NULL,
                                PRIMARY KEY (`id_notification`),
                                KEY `FKjsqpq32j3cp7sbi81on7xo3jg` (`id_user`),
                                CONSTRAINT `FKjsqpq32j3cp7sbi81on7xo3jg` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qualification`
--

DROP TABLE IF EXISTS `qualification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qualification` (
                                 `id_qualification` bigint NOT NULL AUTO_INCREMENT,
                                 `bimester` int NOT NULL,
                                 `value` int NOT NULL,
                                 `id_class` bigint DEFAULT NULL,
                                 `course_id` bigint DEFAULT NULL,
                                 `id_student` varchar(10) DEFAULT NULL,
                                 PRIMARY KEY (`id_qualification`),
                                 KEY `FKke6larhanwcl5b7n7k6a7pqkr` (`id_class`),
                                 KEY `FK2jhml8esj4v5p3b6s1nrv2uhr` (`course_id`),
                                 KEY `FKmo0i63p3w514m60wmrap2uwvo` (`id_student`),
                                 CONSTRAINT `FK2jhml8esj4v5p3b6s1nrv2uhr` FOREIGN KEY (`course_id`) REFERENCES `class` (`id_class`),
                                 CONSTRAINT `FKke6larhanwcl5b7n7k6a7pqkr` FOREIGN KEY (`id_class`) REFERENCES `class` (`id_class`),
                                 CONSTRAINT `FKmo0i63p3w514m60wmrap2uwvo` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qualification`
--

LOCK TABLES `qualification` WRITE;
/*!40000 ALTER TABLE `qualification` DISABLE KEYS */;
/*!40000 ALTER TABLE `qualification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registration` (
                                `id_registration` bigint NOT NULL AUTO_INCREMENT,
                                `registration_date` datetime(6) DEFAULT NULL,
                                `status` varchar(255) DEFAULT NULL,
                                `id_user` bigint DEFAULT NULL,
                                PRIMARY KEY (`id_registration`),
                                KEY `FKfa8d7ap6efm32cn7kh5nu7gtk` (`id_user`),
                                CONSTRAINT `FKfa8d7ap6efm32cn7kh5nu7gtk` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `speciality`
--

DROP TABLE IF EXISTS `speciality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `speciality` (
                              `id_speciality` bigint NOT NULL AUTO_INCREMENT,
                              `name` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`id_speciality`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `speciality`
--

LOCK TABLES `speciality` WRITE;
/*!40000 ALTER TABLE `speciality` DISABLE KEYS */;
/*!40000 ALTER TABLE `speciality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
                           `id_student` varchar(10) NOT NULL,
                           `entry_date` datetime(6) DEFAULT NULL,
                           `grade` bigint DEFAULT NULL,
                           `password` varchar(255) DEFAULT NULL,
                           `payment_status` bit(1) NOT NULL,
                           `profile` varchar(255) DEFAULT NULL,
                           `section` varchar(255) DEFAULT NULL,
                           `shift` varchar(255) DEFAULT NULL,
                           `study_level` varchar(255) DEFAULT NULL,
                           `id_user` bigint DEFAULT NULL,
                           PRIMARY KEY (`id_student`),
                           UNIQUE KEY `UKgk5vu6ga9cu8ho09qs12cq91l` (`id_user`),
                           CONSTRAINT `FKb4lfwbonj876jqkfv3syhp06o` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_class_assignment`
--

DROP TABLE IF EXISTS `student_class_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_class_assignment` (
                                            `id_assignment` int NOT NULL AUTO_INCREMENT,
                                            `id_class` bigint NOT NULL,
                                            `id_student` varchar(10) NOT NULL,
                                            PRIMARY KEY (`id_assignment`),
                                            KEY `FKk4w7fkoa893w6qs4phoai8a4w` (`id_class`),
                                            KEY `FKomft8if286nf1v5daapt5isqq` (`id_student`),
                                            CONSTRAINT `FKk4w7fkoa893w6qs4phoai8a4w` FOREIGN KEY (`id_class`) REFERENCES `class` (`id_class`),
                                            CONSTRAINT `FKomft8if286nf1v5daapt5isqq` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_class_assignment`
--

LOCK TABLES `student_class_assignment` WRITE;
/*!40000 ALTER TABLE `student_class_assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_class_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
                           `id_teacher` varchar(10) NOT NULL,
                           `password` varchar(255) DEFAULT NULL,
                           `profile` varchar(255) DEFAULT NULL,
                           `id_speciality` bigint DEFAULT NULL,
                           `id_user` bigint DEFAULT NULL,
                           PRIMARY KEY (`id_teacher`),
                           UNIQUE KEY `UK1giqscy9vr0y3b2anvkyadcxe` (`id_user`),
                           KEY `FKmlud55bajemvfwr2rwqswgl5r` (`id_speciality`),
                           CONSTRAINT `FK1j8r4d0olybhmcj1r9bn3shuu` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
                           CONSTRAINT `FKmlud55bajemvfwr2rwqswgl5r` FOREIGN KEY (`id_speciality`) REFERENCES `speciality` (`id_speciality`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `id_user` bigint NOT NULL AUTO_INCREMENT,
                        `active` bit(1) NOT NULL,
                        `birth_date` datetime(6) DEFAULT NULL,
                        `dni` varchar(255) DEFAULT NULL,
                        `email` varchar(255) DEFAULT NULL,
                        `last_name` varchar(255) DEFAULT NULL,
                        `name` varchar(255) DEFAULT NULL,
                        `phone` varchar(255) DEFAULT NULL,
                        `type` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--
--
-- Dumping events for database 'prisma'
--

--
-- Dumping routines for database 'prisma'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_find_admin_by_full_name` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_find_admin_by_full_name`(IN name VARCHAR(255))
BEGIN
    SET @namePattern = CONCAT('%', name, '%');
    SELECT a.*
    FROM admin a
    WHERE EXISTS (
        SELECT 1
        FROM user u
        WHERE u.id_user = a.id_user
          AND (u.name LIKE @namePattern OR u.last_name LIKE @namePattern)
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_find_last_admin_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_find_last_admin_id`()
BEGIN
    SELECT MAX(id_admin) AS last_id
    FROM admin;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_find_last_student_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_find_last_student_id`()
BEGIN
    SELECT MAX(id_student) AS last_id FROM student;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_find_student_by_full_name` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_find_student_by_full_name`(IN name VARCHAR(255))
BEGIN
    SET @namePattern = CONCAT('%', name, '%');
    SELECT s.*
    FROM student s
    WHERE EXISTS (
        SELECT 1
        FROM user u
        WHERE u.id_user = u.id_user
          AND (u.name LIKE @namePattern OR u.last_name LIKE @namePattern)
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_find_student_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_find_student_by_id`(
    IN p_id VARCHAR(10)
)
BEGIN
    SELECT * FROM student WHERE id_student = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_find_user_by_dni` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_find_user_by_dni`(
    IN p_dni VARCHAR(20)
)
BEGIN
    SELECT * FROM user WHERE dni = p_dni;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_find_teacher_by_full_name` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
DELIMITER ;;

-- Procedimiento para buscar profesores por nombre completo
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_find_teacher_by_full_name`(IN name VARCHAR(255))
BEGIN
    SET @namePattern = CONCAT('%', name, '%');
    SELECT s.*
    FROM teacher t
    WHERE EXISTS (
        SELECT 1
        FROM user u
        WHERE u.id_user = u.id_user
          AND (u.name LIKE @namePattern OR u.last_name LIKE @namePattern)
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_find_teacher_by_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_find_teacher_by_id`(
    IN p_id VARCHAR(10)
)
BEGIN
    SELECT * FROM teacher WHERE id_teacher = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_find_user_by_email` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
DELIMITER ;;

-- Procedimiento para obtener el último ID de profesor
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_find_last_teacher_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_find_last_teacher_id`()
BEGIN
    SELECT MAX(id_teacher) AS last_id FROM teacher;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_find_user_by_email` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_find_user_by_email`(
    IN p_email VARCHAR(255)
)
BEGIN
    SELECT * FROM user WHERE email = p_email;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-21 15:49:07
