-- MySQL dump 10.13  Distrib 5.7.15, for Linux (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.12-0ubuntu1

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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autor` (
  `ID_AUTOR` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) DEFAULT NULL,
  `NomeFantasia` varchar(45) DEFAULT NULL,
  `Nacionalidade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_AUTOR`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'João','Paulo','Brasileirio'),(2,'Renato','Russo','Portugues'),(6,'Valeria','Bet','Uruguaia'),(7,'Yango','KAi','Portoriquenho');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria_item_acervo`
--

DROP TABLE IF EXISTS `categoria_item_acervo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria_item_acervo` (
  `ID_CAT` int(11) NOT NULL AUTO_INCREMENT,
  `NomeCategoria` varchar(45) DEFAULT NULL,
  `Descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_CAT`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria_item_acervo`
--

LOCK TABLES `categoria_item_acervo` WRITE;
/*!40000 ALTER TABLE `categoria_item_acervo` DISABLE KEYS */;
INSERT INTO `categoria_item_acervo` VALUES (1,'Comedias','Macarena'),(3,'nelsom','mandela'),(4,'dasgasgd','gsadgdasg'),(7,' dadad',' fsdf'),(8,'Terror','24234'),(9,' Drama','Não e ação');
/*!40000 ALTER TABLE `categoria_item_acervo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emprestimo`
--

DROP TABLE IF EXISTS `emprestimo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emprestimo` (
  `ID_EMP` int(11) NOT NULL AUTO_INCREMENT,
  `DataEmprestimo` date DEFAULT NULL,
  `DataPrevDevolucao` date DEFAULT NULL,
  `DataDevolucao` date DEFAULT NULL,
  `ValorMulta` decimal(10,0) DEFAULT NULL,
  `Situacao` enum('Aberto','Fechado','Em Andamento','Reserva','Atrasado','Cancelado') NOT NULL,
  `Reserva` tinyint(1) DEFAULT '0',
  `FK_Funcionario` int(11) NOT NULL,
  `FK_USU` int(11) NOT NULL,
  PRIMARY KEY (`ID_EMP`,`FK_Funcionario`,`FK_USU`),
  KEY `fk_Emprestimo_Usuario1_idx` (`FK_Funcionario`),
  KEY `fk_Emprestimo_Usuario2_idx` (`FK_USU`),
  CONSTRAINT `fk_Emprestimo_Usuario2` FOREIGN KEY (`FK_USU`) REFERENCES `usuario` (`ID_USU`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emprestimo`
--

LOCK TABLES `emprestimo` WRITE;
/*!40000 ALTER TABLE `emprestimo` DISABLE KEYS */;
INSERT INTO `emprestimo` VALUES (8,'2016-12-04','2016-12-07','2016-12-04',0,'Fechado',0,0,1),(9,'2016-12-04','2016-12-07','2016-12-04',0,'Fechado',0,0,1);
/*!40000 ALTER TABLE `emprestimo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exemplar`
--

DROP TABLE IF EXISTS `exemplar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exemplar` (
  `ID_EXE` int(11) NOT NULL AUTO_INCREMENT,
  `LiberadoParaEmprestimo` tinyint(1) DEFAULT '1',
  `Duracao` varchar(45) DEFAULT NULL,
  `QuantidadePaginas` varchar(45) DEFAULT NULL,
  `FK_TITULO` int(11) NOT NULL,
  PRIMARY KEY (`ID_EXE`,`FK_TITULO`),
  KEY `fk_Exemplar_Titulo1_idx` (`FK_TITULO`),
  CONSTRAINT `fk_Exemplar_Titulo1` FOREIGN KEY (`FK_TITULO`) REFERENCES `titulo` (`ID_TITU`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exemplar`
--

LOCK TABLES `exemplar` WRITE;
/*!40000 ALTER TABLE `exemplar` DISABLE KEYS */;
INSERT INTO `exemplar` VALUES (1,1,'0','200',1),(2,0,'0','200',1),(3,0,'0','2',1),(4,1,'0','500',2);
/*!40000 ALTER TABLE `exemplar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exemplar_contem_emprestimo`
--

DROP TABLE IF EXISTS `exemplar_contem_emprestimo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exemplar_contem_emprestimo` (
  `FK_exemplar_ID_EXE` int(11) NOT NULL,
  `FK_emprestimo_ID_EMP` int(11) NOT NULL,
  `status_exemplar` enum('Devolvido','A devolver','Cancelado','Em Reserva') DEFAULT 'A devolver',
  `cont` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cont`),
  KEY `fk_exemplar_has_emprestimo_emprestimo1_idx` (`FK_emprestimo_ID_EMP`),
  KEY `fk_exemplar_has_emprestimo_exemplar1_idx` (`FK_exemplar_ID_EXE`),
  CONSTRAINT `fk_exemplar_has_emprestimo_emprestimo1` FOREIGN KEY (`FK_emprestimo_ID_EMP`) REFERENCES `emprestimo` (`ID_EMP`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_exemplar_has_emprestimo_exemplar1` FOREIGN KEY (`FK_exemplar_ID_EXE`) REFERENCES `exemplar` (`ID_EXE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exemplar_contem_emprestimo`
--

LOCK TABLES `exemplar_contem_emprestimo` WRITE;
/*!40000 ALTER TABLE `exemplar_contem_emprestimo` DISABLE KEYS */;
INSERT INTO `exemplar_contem_emprestimo` VALUES (1,8,'Devolvido',1),(4,8,'Devolvido',2),(1,9,'Devolvido',3),(4,9,'Devolvido',4);
/*!40000 ALTER TABLE `exemplar_contem_emprestimo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtoraconteudo`
--

DROP TABLE IF EXISTS `produtoraconteudo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtoraconteudo` (
  `ID_PDC` int(11) NOT NULL AUTO_INCREMENT,
  `Nome_Produtora` varchar(45) DEFAULT NULL,
  `Descricao` varchar(45) DEFAULT NULL,
  `CNPJ` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_PDC`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtoraconteudo`
--

LOCK TABLES `produtoraconteudo` WRITE;
/*!40000 ALTER TABLE `produtoraconteudo` DISABLE KEYS */;
INSERT INTO `produtoraconteudo` VALUES (1,'Casseta','Planeta','000000000000'),(2,'seloohro','eoq','6354646546'),(4,'SBT','Tem celso','avvsasvsdffg'),(5,'Record','Nada bom','0000000000');
/*!40000 ALTER TABLE `produtoraconteudo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `titulo`
--

DROP TABLE IF EXISTS `titulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `titulo` (
  `ID_TITU` int(11) NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(45) DEFAULT NULL,
  `ISSN` varchar(45) DEFAULT NULL,
  `obra` varchar(45) DEFAULT NULL,
  `Descricao` varchar(45) DEFAULT NULL,
  `DataDePublicacao` date DEFAULT NULL,
  `CidadePublicacao` varchar(45) DEFAULT NULL,
  `EstadoPublicacao` varchar(45) DEFAULT NULL,
  `Edicao` varchar(45) DEFAULT NULL,
  `Idioma` varchar(45) DEFAULT NULL,
  `Traducao` varchar(45) DEFAULT NULL,
  `Capa` varchar(45) DEFAULT NULL,
  `FK_ITEM_PDC` int(11) NOT NULL,
  `FK_CAT_ARCE` int(11) NOT NULL,
  `tipoDeObra` enum('Livro','Vídeo','Artigo','Revista') NOT NULL,
  `duracao` float NOT NULL,
  `volume` varchar(10) NOT NULL,
  `quatidadepaginas` int(10) NOT NULL,
  PRIMARY KEY (`ID_TITU`,`FK_ITEM_PDC`,`FK_CAT_ARCE`),
  KEY `fk_Titulo_ProdutoraConteudo1_idx` (`FK_ITEM_PDC`),
  KEY `fk_Titulo_Categoria_item_acervo1_idx` (`FK_CAT_ARCE`),
  CONSTRAINT `fk_Titulo_Categoria_item_acervo1` FOREIGN KEY (`FK_CAT_ARCE`) REFERENCES `categoria_item_acervo` (`ID_CAT`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Titulo_ProdutoraConteudo1` FOREIGN KEY (`FK_ITEM_PDC`) REFERENCES `produtoraconteudo` (`ID_PDC`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titulo`
--

LOCK TABLES `titulo` WRITE;
/*!40000 ALTER TABLE `titulo` DISABLE KEYS */;
INSERT INTO `titulo` VALUES (1,'0000493294230','','Tosco','Muito Tosco','2016-11-11','GYN','GO','1','PT-BR','CHINES','/files/imgs/tosco.png',1,1,'Livro',0,'',0),(2,'baby','dont','hurt','me','1969-12-31','HOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOW what','a','hell','is','going','on',2,1,'Livro',0,'',0),(3,'nao vamo','s','la','adv','2016-11-25','ola','q isso','nova','charmosa','cheia','mel',2,1,'Livro',0,'',0);
/*!40000 ALTER TABLE `titulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `titulo_tem_autor`
--

DROP TABLE IF EXISTS `titulo_tem_autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `titulo_tem_autor` (
  `Titulo_idTitulo` int(11) NOT NULL,
  `Autor_idAutor` int(11) NOT NULL,
  `TipoDeAutor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Titulo_idTitulo`,`Autor_idAutor`),
  KEY `fk_Titulo_has_Autor_Autor1_idx` (`Autor_idAutor`),
  KEY `fk_Titulo_has_Autor_Titulo1_idx` (`Titulo_idTitulo`),
  CONSTRAINT `fk_Titulo_has_Autor_Autor1` FOREIGN KEY (`Autor_idAutor`) REFERENCES `autor` (`ID_AUTOR`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Titulo_has_Autor_Titulo1` FOREIGN KEY (`Titulo_idTitulo`) REFERENCES `titulo` (`ID_TITU`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titulo_tem_autor`
--

LOCK TABLES `titulo_tem_autor` WRITE;
/*!40000 ALTER TABLE `titulo_tem_autor` DISABLE KEYS */;
/*!40000 ALTER TABLE `titulo_tem_autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID_USU` int(11) NOT NULL AUTO_INCREMENT,
  `Nivel_De_Acesso` enum('Adminstrador','Funcionario','Professor','Aluno') DEFAULT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  `CPF` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `NumeroResidencial` varchar(45) DEFAULT NULL,
  `NumeroCelular` varchar(45) DEFAULT NULL,
  `NumeroComercial` varchar(45) DEFAULT NULL,
  `MatriculaEducacional` varchar(45) DEFAULT NULL,
  `Senha` varchar(45) DEFAULT NULL,
  `endereco_Logadouro` varchar(45) DEFAULT NULL,
  `endereco_CEP` varchar(45) DEFAULT NULL,
  `endereco_Cidade` varchar(45) DEFAULT NULL,
  `endereco_Estado` varchar(45) DEFAULT NULL,
  `endereco_Pais` varchar(45) DEFAULT NULL,
  `StatusDoUsuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_USU`),
  UNIQUE KEY `CPF_UNIQUE` (`CPF`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `NumeroResidencial_UNIQUE` (`NumeroResidencial`),
  UNIQUE KEY `NumeroCelular_UNIQUE` (`NumeroCelular`),
  UNIQUE KEY `NumeroComercial_UNIQUE` (`NumeroComercial`),
  UNIQUE KEY `MatriculaEducacional_UNIQUE` (`MatriculaEducacional`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Funcionario','Administrador','333.333.333-33','robervalda','rerere','afajgdadsds','5656566645','4554545453','fdhdhhh','24535323532532532','45445346644747','768875532552353','565466549769769676','5645689989','liberado'),(2,'Adminstrador','root','09886676','rubrivira','laialaia','alfajor','do','sertao','ee6b4548f10eadbac6e13fe798c4f831','laia','laie','97698798797','6546565','636463','liberado'),(3,'Professor',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'Aluno',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'Adminstrador','Administrador','356534635654','admin@admin.com','6654465546546546','456546465546456','456546456546546','465465465465546','21232f297a57a5a743894a0e4a801fc3','rua 665646546541','6465546546564','goiania','go','br','Pendente'),(6,'Professor','sdsdsad','diuhi','hiuhiuhiuh','oi','hoi','jo','ijo','7cef9fb42008ddb986b37c5e8859d176','ijo','ijoijoij','oijoij','oijoi','joijioj','Pendente');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-04 23:03:32
