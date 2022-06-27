-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: dscprojectbd_dev
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `ativos`
--

DROP TABLE IF EXISTS `ativos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ativos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(10) NOT NULL,
  `descricao` varchar(512) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ativos`
--

LOCK TABLES `ativos` WRITE;
/*!40000 ALTER TABLE `ativos` DISABLE KEYS */;
INSERT INTO `ativos` VALUES (1,'BTC','Criptomoeda Criada por Satoshi para ser descentralizada.','Bitcoin'),(2,'ADA','Criptomoeda Criada para auxiliar a Etiópia a encarar melhores opções financeiras.','Ada Cardano'),(3,'DOGE','Criptomoeda Criada como shitcoin para servir como piada ao bitcoin.','Dogecoin'),(4,'USDT','Moeda Theter, baseada no dolar americano.','Thether USD');
/*!40000 ALTER TABLE `ativos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidades`
--

DROP TABLE IF EXISTS `cidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidades` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ddd` varchar(50) NOT NULL,
  `id_ibge` varchar(120) NOT NULL,
  `nome` varchar(120) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `id_estado` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2v6yxmoyu4kcx5r48accn901h` (`id_estado`),
  CONSTRAINT `FK2v6yxmoyu4kcx5r48accn901h` FOREIGN KEY (`id_estado`) REFERENCES `estados` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidades`
--

LOCK TABLES `cidades` WRITE;
/*!40000 ALTER TABLE `cidades` DISABLE KEYS */;
INSERT INTO `cidades` VALUES (1,'85','000003','Bairro Remanso','CN',3),(2,'85','000001','Rio de janeiro','RJ',1),(3,'85','000002','Aparecida do Norte','SP',2),(4,'21','000001','Belford Roxo','RJ',1);
/*!40000 ALTER TABLE `cidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enderecos`
--

DROP TABLE IF EXISTS `enderecos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enderecos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cep` varchar(60) NOT NULL,
  `complemento` varchar(100) NOT NULL,
  `id_ibge_cidade` varchar(255) NOT NULL,
  `logradouro_com_numero` varchar(512) NOT NULL,
  `logradouro_sem_numero` varchar(512) NOT NULL,
  `nome_bairro_cidade` varchar(255) NOT NULL,
  `nome_cidade` varchar(255) NOT NULL,
  `origem_cadastro` varchar(1) NOT NULL,
  `tipo_logradouro` varchar(60) NOT NULL,
  `uf_cidade` varchar(2) NOT NULL,
  `id_cidade` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeqw5253jftwt3t476q1pc6j5j` (`id_cidade`),
  KEY `FK8iyf2el9web8486b3320kqmf0` (`id_usuario`),
  CONSTRAINT `FK8iyf2el9web8486b3320kqmf0` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKeqw5253jftwt3t476q1pc6j5j` FOREIGN KEY (`id_cidade`) REFERENCES `cidades` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enderecos`
--

LOCK TABLES `enderecos` WRITE;
/*!40000 ALTER TABLE `enderecos` DISABLE KEYS */;
INSERT INTO `enderecos` VALUES (1,'91180650','Bloco 1, Apartamento 404','000001','Ferreira de andrade, 136','Ferreira de andrade','Cachambi','Rio de janeiro','A','Rua','RJ',2,1),(2,'21965200','Casa 1','000001','Antônio Simões da costa, 22','Antônio Simões da costa','Jardim Bom Pastor','Belford Roxo','A','Avenida','RJ',4,2);
/*!40000 ALTER TABLE `enderecos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estados` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ddd` varchar(100) NOT NULL,
  `id_ibge` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `id_pais` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKijaicypnbtrgdhle2w53n47vl` (`id_pais`),
  CONSTRAINT `FKijaicypnbtrgdhle2w53n47vl` FOREIGN KEY (`id_pais`) REFERENCES `paises` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'21','000001','Rio de Janeiro','RJ',1),(2,'11','000002','São Paulo','SP',1),(3,'85','000003','SCanelones','CN',2);
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `investimentos`
--

DROP TABLE IF EXISTS `investimentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `investimentos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ind_status` varchar(1) NOT NULL,
  `valor_investido` decimal(19,2) NOT NULL,
  `id_tipo_invest` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnyj5eox6mxrhx0mij6wgxeip5` (`id_tipo_invest`),
  KEY `FK5ty55870cq2m8qenhg4kptjo` (`id_usuario`),
  CONSTRAINT `FK5ty55870cq2m8qenhg4kptjo` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKnyj5eox6mxrhx0mij6wgxeip5` FOREIGN KEY (`id_tipo_invest`) REFERENCES `tipo_investimento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investimentos`
--

LOCK TABLES `investimentos` WRITE;
/*!40000 ALTER TABLE `investimentos` DISABLE KEYS */;
INSERT INTO `investimentos` VALUES (1,'A',1000.00,1,1),(2,'A',2000.00,1,1),(3,'A',3000.00,1,1),(4,'A',4000.00,1,1),(5,'A',5000.00,1,1),(6,'A',6000.00,10,1),(7,'A',7000.00,10,1),(8,'A',8000.00,10,1),(9,'A',9000.00,10,1),(10,'A',10000.00,10,1),(11,'A',11000.00,10,1);
/*!40000 ALTER TABLE `investimentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operacoes`
--

DROP TABLE IF EXISTS `operacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operacoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_operacao` date DEFAULT NULL,
  `paridade` varchar(50) NOT NULL,
  `quantia_ativo` decimal(19,2) DEFAULT NULL,
  `taxa_operacao` decimal(19,2) DEFAULT NULL,
  `tipo_operacao` varchar(1) NOT NULL,
  `valor_cotacao_ativo` decimal(19,2) DEFAULT NULL,
  `valor_executado_operacao` decimal(19,2) DEFAULT NULL,
  `id_ativo` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo1u75tq1mhv7bh655im1u60w5` (`id_ativo`),
  KEY `FKdf0p7x6uf82l7kbmumhhr0m3w` (`id_usuario`),
  CONSTRAINT `FKdf0p7x6uf82l7kbmumhhr0m3w` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKo1u75tq1mhv7bh655im1u60w5` FOREIGN KEY (`id_ativo`) REFERENCES `ativos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operacoes`
--

LOCK TABLES `operacoes` WRITE;
/*!40000 ALTER TABLE `operacoes` DISABLE KEYS */;
INSERT INTO `operacoes` VALUES (1,'2021-08-11','BTCUSDT',0.02,1.00,'C',45802.12,1001.11,1,1),(2,'2021-08-11','BTCUSDT',0.03,1.00,'V',44802.12,1001.11,1,1),(3,'2021-08-11','BTCUSDT',0.03,1.00,'C',43802.12,1001.11,1,1),(4,'2021-08-11','BTCUSDT',0.03,1.00,'V',42802.12,1001.11,1,1),(5,'2021-08-11','BTCUSDT',0.03,1.00,'C',41802.12,1001.11,1,1),(6,'2021-08-11','BTCUSDT',0.03,1.00,'V',40802.12,1001.11,1,1),(7,'2021-08-11','BTCUSDT',0.03,1.00,'C',39802.12,1001.11,1,1);
/*!40000 ALTER TABLE `operacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paises` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bacen` int NOT NULL,
  `nome` varchar(100) NOT NULL,
  `nome_pt` varchar(100) NOT NULL,
  `sigla` varchar(2) NOT NULL,
  `url_bandeira` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
INSERT INTO `paises` VALUES (1,123456,'Brazil','Brasil','BR','https://www.google.com/url?sa=i&url=https%3A%2F%2Fimagepng.org%2Fbandeira-do-brasil%2F&psig=AOvVaw1pOEOLML5rciUW7cAajGHL&ust=1628223660477000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLjA-fiDmfICFQAAAAAdAAAAABAN'),(2,654321,'Uruguay','Uruguai','UY','https://www.google.com/url?sa=i&url=https%3A%2F%2Fpt.wikipedia.org%2Fwiki%2FBandeira_do_Uruguai&psig=AOvVaw1FH2PsKjmhWHuecdg6NZd9&ust=1628223826192000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCU-MeEmfICFQAAAAAdAAAAABAI');
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefones`
--

DROP TABLE IF EXISTS `telefones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ddd_telefone` varchar(5) NOT NULL,
  `ind_receber_msg_sms` varchar(1) NOT NULL,
  `ind_receber_msg_whatsapp` varchar(1) NOT NULL,
  `numero_telefone` varchar(9) NOT NULL,
  `operadora_telefone` varchar(1) NOT NULL,
  `tipo_telefone` varchar(1) NOT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2lh6jueasp1y8qn4cbmi9ejbt` (`id_usuario`),
  CONSTRAINT `FK2lh6jueasp1y8qn4cbmi9ejbt` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefones`
--

LOCK TABLES `telefones` WRITE;
/*!40000 ALTER TABLE `telefones` DISABLE KEYS */;
INSERT INTO `telefones` VALUES (1,'21','S','N','994674449','C','C',1),(2,'51','N','S','27538361','O','F',1);
/*!40000 ALTER TABLE `telefones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_investimento`
--

DROP TABLE IF EXISTS `tipo_investimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_investimento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(512) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `tipo_renda` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_investimento`
--

LOCK TABLES `tipo_investimento` WRITE;
/*!40000 ALTER TABLE `tipo_investimento` DISABLE KEYS */;
INSERT INTO `tipo_investimento` VALUES (1,'Descrição Caderneta de Poupança.','Caderneta de Poupança','F'),(2,'Descrição CDB.','CDB','F'),(3,'Descrição LCI/LCA.','LCI/LCA','F'),(4,'Descrição esouro Direto.','Tesouro Direto','F'),(5,'Descrição Debêntures.','Debêntures','F'),(6,'Descrição FII.','FII','V'),(7,'Descrição Ações nacionais.','Ações nacionais','V'),(8,'Descrição Ações internacionais.','Ações internacionais','V'),(9,'Descrição ETF.','ETF','V'),(10,'Descrição Criptomoedas.','Criptomoedas','V');
/*!40000 ALTER TABLE `tipo_investimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_cadastro` date DEFAULT NULL,
  `data_edicao` date DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usuario_criou` int DEFAULT NULL,
  `usuario_editou` int DEFAULT NULL,
  `usuario_excluiu` int DEFAULT NULL,
  `cpf` varchar(11) NOT NULL,
  `data_nascimento` date NOT NULL,
  `email` varchar(512) NOT NULL,
  `estado_civil` varchar(2) NOT NULL,
  `genero` varchar(1) NOT NULL,
  `ind_disponivel_mudar_cidade` varchar(1) NOT NULL,
  `ind_disponivel_viajar` varchar(1) NOT NULL,
  `ind_portador_deficiencia` varchar(1) NOT NULL,
  `ind_status` varchar(1) NOT NULL,
  `login` varchar(40) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `resumo_profissional` longtext NOT NULL,
  `senha` varchar(25) NOT NULL,
  `tipo_permissao` int NOT NULL,
  `url_blog_site` varchar(512) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2et2smpfrtsohr7w9fe1v8a5e` (`cpf`),
  UNIQUE KEY `UK_kfsp0s1tflm1cwlj8idhqsad0` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,'11754423728','1986-07-12','sgt.chacal.d@gmail.com','C','M','N','S','N','A','chacalsgt','Diego Dos Santos Cordeiro','Resumo Profissional','SenhaQueSeráCriptografada',2,'http://www.diegocordeiro.com.br'),(2,NULL,NULL,NULL,NULL,NULL,NULL,'11754423729','1986-07-12','claytonsantos13@gmail.com','C','M','N','S','N','A','chacalsgt','Clayton Santos Cordeiro','Resumo Profissional','SenhaQueSeráCriptografada',2,'http://www.diegocordeiro.com.br');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'dscprojectbd_dev'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-01  0:13:59
