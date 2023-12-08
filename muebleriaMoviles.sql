DROP DATABASE mobiliaria;
CREATE DATABASE  IF NOT EXISTS `mobiliaria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mobiliaria`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: mobiliaria
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
-- Table structure for table `tb_boleta`
--

DROP TABLE IF EXISTS `tb_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_boleta` (
  `num_bol` char(5) NOT NULL,
  `fch_bol` date DEFAULT NULL,
  `cod_cliente` int NOT NULL,
  PRIMARY KEY (`num_bol`),
  KEY `cod_cliente` (`cod_cliente`),
  CONSTRAINT `tb_boleta_ibfk_1` FOREIGN KEY (`cod_cliente`) REFERENCES `tb_clientes` (`cod_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_boleta`
--

LOCK TABLES `tb_boleta` WRITE;
/*!40000 ALTER TABLE `tb_boleta` DISABLE KEYS */;
INSERT INTO `tb_boleta` VALUES ('B0001','2022-05-20',202201),('B0002','2022-05-20',202202),('B0003','2023-06-24',202201),('B0004','2023-06-24',202201),('B0005','2023-06-24',202201),('B0006','2023-06-24',202201),('B0007','2023-06-24',202201),('B0008','2023-06-24',202201),('B0009','2023-06-24',202201),('B0010','2023-06-24',202201),('B0011','2023-06-24',202201);
/*!40000 ALTER TABLE `tb_boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_clientes`
--

DROP TABLE IF EXISTS `tb_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_clientes` (
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `cod_cliente` int NOT NULL,
  PRIMARY KEY (`cod_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_clientes`
--

LOCK TABLES `tb_clientes` WRITE;
/*!40000 ALTER TABLE `tb_clientes` DISABLE KEYS */;
INSERT INTO `tb_clientes` VALUES ('Javier','Gonzales',202201),('Luis','Navarrete',202202),('Daniel','Machuca',202203),('Marlon','Soria',202204),('Gian','Soria',202205),('alexander','Suarez',202210);
/*!40000 ALTER TABLE `tb_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_det_boleta`
--

DROP TABLE IF EXISTS `tb_det_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_det_boleta` (
  `num_bol` char(5) NOT NULL,
  `cod_prod` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  `preciovta` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`num_bol`,`cod_prod`),
  KEY `cod_prod` (`cod_prod`),
  CONSTRAINT `tb_det_boleta_ibfk_1` FOREIGN KEY (`num_bol`) REFERENCES `tb_boleta` (`num_bol`),
  CONSTRAINT `tb_det_boleta_ibfk_2` FOREIGN KEY (`cod_prod`) REFERENCES `tb_productos` (`cod_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_det_boleta`
--

LOCK TABLES `tb_det_boleta` WRITE;
/*!40000 ALTER TABLE `tb_det_boleta` DISABLE KEYS */;
INSERT INTO `tb_det_boleta` VALUES ('B0001',1001,1,450.50),('B0002',1002,2,200.50),('B0003',1003,2,30.46),('B0003',1004,3,45.69),('B0003',1005,1,15.23),('B0004',1003,2,30.46),('B0004',1004,3,45.69),('B0004',1005,1,15.23),('B0005',1003,2,30.46),('B0005',1004,3,45.69),('B0005',1005,1,15.23),('B0006',1003,2,30.46),('B0006',1004,3,45.69),('B0006',1005,1,15.23),('B0007',1003,2,30.46),('B0007',1004,3,45.69),('B0007',1005,1,15.23),('B0008',1003,2,30.46),('B0008',1004,3,45.69),('B0008',1005,1,15.23),('B0009',1003,2,30.46),('B0009',1004,3,45.69),('B0009',1005,1,15.23),('B0010',1003,2,30.46),('B0010',1004,3,45.69),('B0010',1005,1,15.23),('B0011',1003,2,30.46),('B0011',1004,3,45.69),('B0011',1005,1,15.23);
/*!40000 ALTER TABLE `tb_det_boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_empleados`
--

DROP TABLE IF EXISTS `tb_empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_empleados` (
  `codigo` int NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `puesto` int DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `puesto` (`puesto`),
  CONSTRAINT `tb_empleados_ibfk_1` FOREIGN KEY (`puesto`) REFERENCES `tb_puesto` (`id_puesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_empleados`
--

LOCK TABLES `tb_empleados` WRITE;
/*!40000 ALTER TABLE `tb_empleados` DISABLE KEYS */;
INSERT INTO `tb_empleados` VALUES (100,'Jose','Perez',1),(101,'Maria','Peralta',2),(102,'Luis','Sanchez',2),(103,'Pedro','Galvez',3),(104,'Carlos','Espinosa',4);
/*!40000 ALTER TABLE `tb_empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_productos`
--

DROP TABLE IF EXISTS `tb_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_productos` (
  `cod_prod` int NOT NULL,
  `cod_provee` int DEFAULT NULL,
  `des_prod` varchar(50) DEFAULT NULL,
  `idtipo` int DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `precio` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`cod_prod`),
  KEY `idtipo` (`idtipo`),
  KEY `cod_provee` (`cod_provee`),
  CONSTRAINT `tb_productos_ibfk_1` FOREIGN KEY (`idtipo`) REFERENCES `tb_tipo` (`idtipo`),
  CONSTRAINT `tb_productos_ibfk_2` FOREIGN KEY (`cod_provee`) REFERENCES `tb_proveedores` (`cod_provee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_productos`
--

LOCK TABLES `tb_productos` WRITE;
/*!40000 ALTER TABLE `tb_productos` DISABLE KEYS */;
INSERT INTO `tb_productos` VALUES (1001,1001,'Se actualizo',5,10,26.12),(1002,1002,'Cama niños',4,10,200.50),(1003,1002,'Sillon crema',2,5,300.00),(1004,1003,'Sillon blanco',2,5,300.00),(1005,1001,'Mesa comedor con juego de sillas',3,8,500.50),(1006,1001,'Sillas reclinables',5,30,90.50),(1007,1001,'La casita de papel',5,20,15.23),(1008,NULL,NULL,NULL,NULL,NULL),(1009,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedores`
--

DROP TABLE IF EXISTS `tb_proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_proveedores` (
  `raz_soc` varchar(30) DEFAULT NULL,
  `ruc` int DEFAULT NULL,
  `cod_provee` int NOT NULL,
  PRIMARY KEY (`cod_provee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedores`
--

LOCK TABLES `tb_proveedores` WRITE;
/*!40000 ALTER TABLE `tb_proveedores` DISABLE KEYS */;
INSERT INTO `tb_proveedores` VALUES ('Muebles Angel',123654789,1001),('Paraiso',233654739,1002),('Horizontes',212444478,1003),('Tigre',512365479,1004);
/*!40000 ALTER TABLE `tb_proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_puesto`
--

DROP TABLE IF EXISTS `tb_puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_puesto` (
  `id_puesto` int NOT NULL,
  `des_puesto` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_puesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_puesto`
--

LOCK TABLES `tb_puesto` WRITE;
/*!40000 ALTER TABLE `tb_puesto` DISABLE KEYS */;
INSERT INTO `tb_puesto` VALUES (1,'Supervisor'),(2,'Vendedor'),(3,'Almacen'),(4,'Despacho');
/*!40000 ALTER TABLE `tb_puesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo`
--

DROP TABLE IF EXISTS `tb_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipo` (
  `idtipo` int NOT NULL,
  `des_tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idtipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo`
--

LOCK TABLES `tb_tipo` WRITE;
/*!40000 ALTER TABLE `tb_tipo` DISABLE KEYS */;
INSERT INTO `tb_tipo` VALUES (1,'Juego Dormitorio'),(2,'Juego Sala'),(3,'Juego Comedor'),(4,'Juego Dormitorio Niños'),(5,'Juego Aire Libre');
/*!40000 ALTER TABLE `tb_tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipos`
--

DROP TABLE IF EXISTS `tb_tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipos` (
  `idtipo` int NOT NULL,
  `descripcion` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idtipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipos`
--

LOCK TABLES `tb_tipos` WRITE;
/*!40000 ALTER TABLE `tb_tipos` DISABLE KEYS */;
INSERT INTO `tb_tipos` VALUES (0,'Dios'),(1,'administrador'),(2,'empleado');
/*!40000 ALTER TABLE `tb_tipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuarios` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) DEFAULT NULL,
  `apellido` varchar(25) DEFAULT NULL,
  `usuario` char(45) NOT NULL,
  `clave` char(5) DEFAULT NULL,
  `fnacim` date DEFAULT NULL,
  `tipo` int DEFAULT '2',
  PRIMARY KEY (`codigo`),
  KEY `tipo` (`tipo`),
  CONSTRAINT `tb_usuarios_ibfk_1` FOREIGN KEY (`tipo`) REFERENCES `tb_tipos` (`idtipo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuarios`
--

LOCK TABLES `tb_usuarios` WRITE;
/*!40000 ALTER TABLE `tb_usuarios` DISABLE KEYS */;
INSERT INTO `tb_usuarios` VALUES (1,'Marlon','Soria','U001@gmail.com','00001','2023-06-16',1),(2,'Franco','Cerna','U002@gmail.com','00002','2023-06-16',1),(3,'Augusto','Lara','U003@gmail.com','00003','2023-06-16',2),(4,NULL,NULL,'enzito@gmail.com',NULL,NULL,2),(5,NULL,NULL,'enzito@gmail.com',NULL,NULL,2),(6,NULL,NULL,'enzito@gmail.com','123',NULL,2);
/*!40000 ALTER TABLE `tb_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mobiliaria'
--
/*!50003 DROP PROCEDURE IF EXISTS `MANTENIMIENTO_PRODUCTO` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MANTENIMIENTO_PRODUCTO`(
	IN pCODIGO_PRODUCTO INT,
    IN pCODIGO_PROVEEDOR INT,
    IN pDESCRIPCION_PRODUCTO VARCHAR(250),
    IN pID_TIPO INT,
    IN pSTOCK INT,
    IN pPRECIO DECIMAL(8,2),
    IN pACCION VARCHAR(30),
    OUT pEXITO VARCHAR(50)
)
BEGIN
	DECLARE pCOD_PRODUCTO INT;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
       SET pEXITO = 'NO';
    END;
	SET pEXITO = 'NO';
    IF pACCION = 'LISTAR' THEN
        SELECT 
            prod.cod_prod AS codigoProducto,
            prod.cod_provee AS codigoProveedor,
            prod.des_prod AS descripcionProducto,
            prod.idtipo AS idTipo,
            prod.stock AS stock,
            prod.precio AS precio
        FROM tb_productos prod;
        SET pEXITO = 'SI';
    ELSEIF pACCION = 'REGISTRAR' THEN
        SET pCOD_PRODUCTO = (SELECT MAX(cod_prod) FROM mobiliaria.tb_productos);
        INSERT INTO mobiliaria.tb_productos
            (cod_prod,
            cod_provee,
            des_prod,
            idtipo,
            stock,
            precio)
            VALUES
            (pCOD_PRODUCTO + 1,
            pCODIGO_PROVEEDOR,
            pDESCRIPCION_PRODUCTO,
            pID_TIPO,
            pSTOCK,
            pPRECIO);

        SET pEXITO = 'SI';
	 ELSEIF pACCION = 'ACTUALIZAR' THEN
        
        UPDATE mobiliaria.tb_productos
            SET 
            cod_provee = pCODIGO_PROVEEDOR,
            des_prod = pDESCRIPCION_PRODUCTO,
            idtipo = pID_TIPO,
            stock = pSTOCK,
            precio = pPRECIO
            WHERE cod_prod = pCODIGO_PRODUCTO;
        SET pEXITO = 'SI';
	ELSEIF pACCION = 'ELIMINAR' THEN
	
	DELETE FROM mobiliaria.tb_productos
		WHERE cod_prod = pCODIGO_PRODUCTO;
	SET pEXITO = 'SI';
    END IF;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_actualizar_client` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_actualizar_client`(
    IN p_nombre VARCHAR(30),
    IN p_apellido VARCHAR(30),
    IN p_cod_cliente INT
)
BEGIN
    UPDATE tb_clientes
    SET nombre = p_nombre,
        apellido = p_apellido
    WHERE cod_cliente = p_cod_cliente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_buscarEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_buscarEmpleado`(codigo_e int)
begin
select t.codigo , t.nombre , t.apellido , t.puesto , p.des_puesto from tb_empleados t 
join tb_puesto p 
on t.puesto = p.id_puesto 
where codigo = codigo_e;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_buscar_client` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_buscar_client`(
    IN p_cod_cliente INT,
    OUT p_nombre VARCHAR(30),
    OUT p_apellido VARCHAR(30)
)
BEGIN
    SELECT nombre, apellido INTO p_nombre, p_apellido
    FROM tb_clientes
    WHERE cod_cliente = p_cod_cliente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_crearClientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_crearClientes`(nombre_e	VARCHAR(30),	apellido_e	VARCHAR(30),	cod_cliente_e	int)
begin
insert into tb_clientes values (nombre_e , apellido_e , cod_cliente_e);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_crearEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_crearEmpleado`(codigo int, nombre VARCHAR(30),apellido	VARCHAR(30) ,puesto INT)
begin
insert into tb_empleados values (codigo , nombre , apellido , puesto);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_crearProductos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_crearProductos`(cod_prod_e	int , cod_provee_e  int, des_prod_e	VARCHAR(50), idtipo_e	int, stock_e	int, precio_e	decimal(8,2))
begin
insert into tb_productos values (cod_prod_e	 , cod_provee_e  , des_prod_e	, idtipo_e	, stock_e	, precio_e	);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_crearProveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_crearProveedor`(raz_soc_e VARCHAR(30),	ruc_e		int,	cod_provee_e int)
begin
insert into tb_proveedores values (raz_soc_e , ruc_e , cod_provee_e);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_CREAR_CABEZERA_BOLETA` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_CREAR_CABEZERA_BOLETA`(
	IN pCOD_CLIENTE INT,
    OUT pNUM_BOLETA CHAR(5)
)
BEGIN

	DECLARE pNUM_BOLETA_ULTIMO CHAR(5);
    SET pNUM_BOLETA_ULTIMO = (select CONCAT('B', LPAD(MAX(SUBSTRING(num_bol, 2)) + 1, 4, '0')) from tb_boleta);
    
    SET pNUM_BOLETA = pNUM_BOLETA_ULTIMO;
    INSERT INTO tb_boleta VALUES(pNUM_BOLETA_ULTIMO, NOW(), pCOD_CLIENTE);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_crear_client` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_crear_client`(
    IN p_nombre VARCHAR(30),
    IN p_apellido VARCHAR(30),
    IN p_cod_cliente INT
)
BEGIN
    INSERT INTO tb_clientes (nombre, apellido, cod_cliente)
    VALUES (p_nombre, p_apellido, p_cod_cliente);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_eliminarClientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_eliminarClientes`(cod_cliente_e	int)
begin
delete from tb_clientes where cod_cliente = cod_cliente_e ;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_eliminarEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_eliminarEmpleado`(codigo_e int)
begin
delete from tb_empleados where codigo = codigo_e ;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_eliminarProductos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_eliminarProductos`(cod_prod_e	int)
begin
delete from tb_productos where cod_prod = cod_prod_e ;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_eliminarProveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_eliminarProveedor`(cod_provee_e int)
begin
delete from tb_proveedores where cod_provee = cod_provee_e ;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_eliminar_client` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_eliminar_client`(
    IN p_cod_cliente INT
)
BEGIN
    DELETE FROM tb_clientes
    WHERE cod_cliente = p_cod_cliente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarProd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarProd`()
begin
select pr.cod_prod, pr.des_prod, pr.cod_provee, pv.raz_soc, pr.idtipo, ti.des_tipo, pr.stock, pr.precio FROM tb_productos as pr JOIN tb_proveedores as pv JOIN  tb_tipo as ti
ON pr.cod_provee = pv.cod_provee AND pr.idtipo = ti.idtipo; 
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_lista_client` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_lista_client`()
BEGIN
    SELECT nombre, apellido, cod_cliente
    FROM tb_clientes;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_lista_emp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_lista_emp`()
BEGIN
    SELECT codigo, nombre, apellido, puesto
    FROM tb_empleados;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_MANTENIMIENTO_CLIENTE` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_MANTENIMIENTO_CLIENTE`(
    IN accion VARCHAR(10),
    IN nombre VARCHAR(30),
    IN apellido VARCHAR(30),
    IN cod_cliente INT
)
BEGIN
    IF accion = 'REGISTRO' THEN
        -- Insertar un nuevo registro en la tabla tb_cliente
        INSERT INTO tb_clientes (nombre, apellido, cod_cliente)
        VALUES (nombre, apellido, cod_cliente);
    ELSEIF accion = 'EDICION' THEN
        -- Actualizar un registro existente en la tabla tb_cliente
        UPDATE tb_clientes
        SET nombre = nombre, apellido = apellido
        WHERE cod_cliente = cod_cliente;
    ELSEIF accion = 'ELIMINACION' THEN
        -- Eliminar un registro de la tabla tb_cliente
        DELETE FROM tb_clientes
        WHERE cod_cliente = cod_cliente;
    ELSEIF accion = 'LISTADO' THEN
        -- Obtener todos los registros de la tabla tb_cliente
        SELECT * FROM tb_clientes;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_MANTENIMIENTO_PRODUCTO` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_MANTENIMIENTO_PRODUCTO`(
	IN pCODIGO_PRODUCTO INT,
    IN pCODIGO_PROVEEDOR INT,
    IN pDESCRIPCION_PRODUCTO VARCHAR(250),
    IN pID_TIPO INT,
    IN pSTOCK INT,
    IN pPRECIO DECIMAL(8,2),
    IN pACCION VARCHAR(30),
    OUT pEXITO VARCHAR(50)
)
BEGIN
	DECLARE pCOD_PRODUCTO INT;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
       SET pEXITO = 'NO';
    END;
	SET pEXITO = 'NO';
    IF pACCION = 'LISTAR' THEN
        SELECT 
            prod.cod_prod AS codigoProducto,
            prod.cod_provee AS codigoProveedor,
            prod.des_prod AS descripcionProducto,
            prod.idtipo AS idTipo,
            prod.stock AS stock,
            prod.precio AS precio
        FROM tb_productos prod;
        SET pEXITO = 'SI';
    ELSEIF pACCION = 'REGISTRAR' THEN
        SET pCOD_PRODUCTO = (SELECT MAX(cod_prod) FROM mobiliaria.tb_productos);
        INSERT INTO mobiliaria.tb_productos
            (cod_prod,
            cod_provee,
            des_prod,
            idtipo,
            stock,
            precio)
            VALUES
            (pCOD_PRODUCTO + 1,
            pCODIGO_PROVEEDOR,
            pDESCRIPCION_PRODUCTO,
            pID_TIPO,
            pSTOCK,
            pPRECIO);

        SET pEXITO = 'SI';
	 ELSEIF pACCION = 'ACTUALIZAR' THEN
        
        UPDATE mobiliaria.tb_productos
            SET 
            cod_provee = pCODIGO_PROVEEDOR,
            des_prod = pDESCRIPCION_PRODUCTO,
            idtipo = pID_TIPO,
            stock = pSTOCK,
            precio = pPRECIO
            WHERE cod_prod = pCODIGO_PRODUCTO;
        SET pEXITO = 'SI';
	ELSEIF pACCION = 'ELIMINAR' THEN
	
	DELETE FROM mobiliaria.tb_productos
		WHERE cod_prod = pCODIGO_PRODUCTO;
	SET pEXITO = 'SI';
    END IF;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_MANTENIMIENTO_USUARIO` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_MANTENIMIENTO_USUARIO`(
	IN pCODIGO_USUARIO INT,
    IN pUSUARIO VARCHAR(250),
    IN pCLAVE VARCHAR(250),
    IN pACCION VARCHAR(30),
    OUT pEXITO VARCHAR(50)
)
BEGIN
	DECLARE pCOD_PRODUCTO INT;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
       SET pEXITO = 'NO';
    END;
	SET pEXITO = 'NO';
    IF pACCION = 'REGISTRAR' THEN
		INSERT INTO `mobiliaria`.`tb_usuarios`
		(
		`usuario`,
		`clave`,
		`tipo`)
		VALUES
		(
		pUSUARIO,
		pCLAVE,
		2);
		SET pEXITO = 'SI';
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_modificarClientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_modificarClientes`(nombre_e	VARCHAR(30),	apellido_e	VARCHAR(30),	cod_cliente_e	int)
begin
update tb_clientes set nombre = nombre_e ,  apellido  = apellido_e  where cod_cliente = cod_cliente_e;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_modificarEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_modificarEmpleado`(codigo_e int, nombre_e VARCHAR(30),apellido_e	VARCHAR(30) ,puesto_e INT)
begin
update tb_empleados set nombre = nombre_e ,  apellido  = apellido_e , puesto = puesto_e where codigo = codigo_e;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_modificarProductos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_modificarProductos`(cod_prod_e	int , cod_provee_e  int, des_prod_e	VARCHAR(50), idtipo_e	int, stock_e	int, precio_e	decimal(8,2))
begin
update tb_productos set stock = stock_e ,  cod_provee  = cod_provee_e  ,    des_prod    = des_prod_e ,idtipo  = idtipo_e,precio = precio_e where cod_prod = cod_prod_e;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_modificarProveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_modificarProveedor`(raz_soc_e VARCHAR(30),	ruc_e		int,	cod_provee_e int)
begin
update tb_proveedores set raz_soc = raz_soc_e ,  ruc  = ruc_e  where cod_provee = cod_provee_e;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_REGISTRAR_DETALLE_BOLETA` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_REGISTRAR_DETALLE_BOLETA`(
	IN pNUM_BOLETA CHAR(5),
    IN pCODIGO_PRODUCTO INT,
    IN pCANTIDAD INT,
    IN pPRECIO_TOTAL DOUBLE,
    OUT pEXITO VARCHAR(5)
)
BEGIN
	DECLARE pCOD_PRODUCTO INT;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
       SET pEXITO = 'NO';
    END;
	SET pEXITO = 'NO';
	INSERT INTO tb_det_boleta VALUES(pNUM_BOLETA, pCODIGO_PRODUCTO, pCANTIDAD, pPRECIO_TOTAL);
    SET pEXITO = 'SI';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_reporte` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_reporte`(num_bol_e	char(5))
begin
select b.cod_prod , p.precio , b.cantidad , p.des_prod , b.preciovta  from tb_det_boleta b
join  tb_productos p
on b.cod_prod = p.cod_prod
where b.num_bol = num_bol_e ;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_validaAcceso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_validaAcceso`(usr char(45), pas char(5))
begin
select * from tb_usuarios where usuario = usr and clave = pas;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_VALIDAR_ACCESO` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_VALIDAR_ACCESO`(
IN pUSUARIO char(45), 
IN pCONTRASENIA char(5),
OUT pEXITO VARCHAR(50)
)
BEGIN
	DECLARE iVALIDAR_ACCESO INT;
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
		SELECT 'SE CAYO AQUI';
       SET pEXITO = 'NO';
    END;
    
    SET pEXITO = 'NO';
    
	SET iVALIDAR_ACCESO = (select COUNT(*) from tb_usuarios where usuario = pUSUARIO and clave = pCONTRASENIA);
    IF iVALIDAR_ACCESO = 1 THEN
		SET pEXITO = 'SI';
    END IF;
    
END ;;
DELIMITER ;

DELIMiTER $$
CREATE PROCEDURE usp_lista_prov()
begin
    SELECT raz_soc, ruc, cod_provee
    FROM tb_proveedores;
end$$
DELIMiTER ;


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

-- Dump completed on 2023-06-24  0:57:33
