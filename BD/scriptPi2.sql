DROP DATABASE IF EXISTS  deltaBus ;
CREATE DATABASE  IF NOT EXISTS `deltabus2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `deltabus2`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: deltabus2
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `Nome` varchar(255) NOT NULL,
  `numeroTelefone` varchar(14) NOT NULL,
  `email` varchar(45) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `cnpj` bigint NOT NULL,
  `endereco_cep` bigint NOT NULL,
  PRIMARY KEY (`cnpj`),
  KEY `endereco_cep` (`endereco_cep`),
  CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`endereco_cep`) REFERENCES `endereco` (`cep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('bruna','5','brunar@gmail.com','1596857837',6666666666,21346560),('5255','           ','55555','55555555555',55555555555555,55555555);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `cep` bigint NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `UF` varchar(45) NOT NULL,
  PRIMARY KEY (`cep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (21346560,'Blumenau','Progresso','Rua Ernestine Ehrhardt','SC'),(55555555,'São José','5','55','SP');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionarios` (
  `cpf` double NOT NULL,
  `nome` varchar(255) NOT NULL,
  `dataNascimento` varchar(45) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `numerotelefone` bigint NOT NULL,
  `email` varchar(35) NOT NULL,
  `Usuario_idUsuario` int NOT NULL,
  `endereco_cep` bigint NOT NULL,
  PRIMARY KEY (`cpf`),
  KEY `Usuario_idUsuario` (`Usuario_idUsuario`),
  KEY `endereco_cep` (`endereco_cep`),
  CONSTRAINT `funcionarios_ibfk_1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `funcionarios_ibfk_2` FOREIGN KEY (`endereco_cep`) REFERENCES `endereco` (`cep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` VALUES (14058566,'Agatha Cristine Onofre Ribeiro','2004-01-19','Feminino',987654325,'agatha@gmail.com',1,21346560);
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id_pedidos` int NOT NULL AUTO_INCREMENT,
  `dataCompra` date NOT NULL,
  `quantidade` int NOT NULL,
  `valorPago` double NOT NULL,
  `tipoPagamento` varchar(45) NOT NULL,
  `Cnpj` bigint NOT NULL,
  `idVeiculo` bigint NOT NULL,
  PRIMARY KEY (`id_pedidos`),
  KEY `fk_pedidoCliente_idx` (`Cnpj`),
  KEY `fk_pedidoVeiculo_idx` (`idVeiculo`),
  CONSTRAINT `fk_pedidoCliente` FOREIGN KEY (`Cnpj`) REFERENCES `clientes` (`cnpj`),
  CONSTRAINT `fk_pedidoVeiculo` FOREIGN KEY (`idVeiculo`) REFERENCES `veiculo` (`idVeiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (2,'2023-09-16',2,150000,'Cartão',6666666666,1),(3,'2000-01-01',6,555.55,'Cartão',55555555555555,1);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `senha` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `cargo` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO deltabus2.usuario (senha, email, cargo) VALUES ('abc123', 'bruna@gmail.com', 'funcionario');
INSERT INTO deltabus2.usuario (senha, email, cargo) VALUES ('abc1234', 'maria@gmail.com', 'administrador');

-- INSERT INTO `usuario` VALUES (1,'1312','bruna@gmail.com','administrador'),(2,'1234','maria@gmail.com','funcionario');







DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veiculo` (
  `idVeiculo` bigint NOT NULL AUTO_INCREMENT,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `preco` double NOT NULL,
  `ano` int NOT NULL,
  `acessorios` varchar(45) NOT NULL,
  `lotacao` int NOT NULL,
  `cor` varchar(45) NOT NULL,
  `tipoFrota` varchar(45) NOT NULL,
  `tipoCombustivel` varchar(45) NOT NULL,
  `placa` varchar(45) NOT NULL,
  `renavam` varchar(45) NOT NULL,
  `situacao` varchar(45) NOT NULL,
  PRIMARY KEY (`idVeiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--


INSERT INTO `veiculo` VALUES (1,'Marcopolo','Paradiso G8 1050',100000000,2023,'Ar condicionado, GPS',5,'Azul','Passeio','diesel','ABC123','123456784','Disponivel');
INSERT INTO `veiculo` VALUES (2,'Scania','AGRALE/MASCA GRANMIDI O',134567.999,2023,'Banheiro',40,'Verde','Turismo','GNC','ABC222','987654321','Novo');

-- IMPLEMENTAÇÂO DE NOVAS UNCIONALIDADES --




