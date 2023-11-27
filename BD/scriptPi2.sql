DROP DATABASE IF EXISTS deltabus2;
CREATE DATABASE  IF NOT EXISTS `deltabus2`;
USE `deltabus2`;

CREATE TABLE `clientes` (
  `Nome` varchar(255) NOT NULL,
  `numeroTelefone` varchar(14) NOT NULL,
  `email` varchar(45) NOT NULL,
  `cnpj` bigint NOT NULL,
  `endereco_cep` bigint NOT NULL,
  PRIMARY KEY (`cnpj`)
) ;

INSERT INTO `clientes` VALUES ('bruna','57412567854','brunar@gmail.com',66666666666666,21346560);

CREATE TABLE `endereco` (
  `cep` bigint NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `UF` varchar(45) NOT NULL,
  PRIMARY KEY (`cep`)
);

INSERT INTO `endereco` VALUES (21346560,'Blumenau','Progresso','Rua Ernestine Ehrhardt','SC'),(55555555,'São José','5','55','SP');


CREATE TABLE `funcionarios` (
  `cpf` bigint NOT NULL,
  `nome` varchar(255) NOT NULL,
  `dataNascimento` varchar(45) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `numerotelefone` bigint NOT NULL,
  `email` varchar(35) NOT NULL,
  `Usuario_idUsuario` int NOT NULL,
  `endereco_cep` bigint NOT NULL,
  PRIMARY KEY (`cpf`)
);


INSERT INTO `funcionarios` VALUES (14058566,'Agatha Cristine Onofre Ribeiro','2004-01-19','Feminino',987654325,'agatha@gmail.com',1,21346560);


CREATE TABLE `pedido` (
  `id_pedidos` int NOT NULL AUTO_INCREMENT,
  `dataCompra` date NOT NULL,
  `quantidade` int NOT NULL,
  `valorPago` double NOT NULL,
  `tipoPagamento` varchar(45) NOT NULL,
  `Cnpj` bigint NOT NULL,
  `idVeiculo` bigint NOT NULL,
  PRIMARY KEY (`id_pedidos`)
);

INSERT INTO `pedido` VALUES (2,'2023-09-16',2,150000,'Cartão',6666666666,1),(3,'2000-01-01',6,555.55,'Cartão',55555555555555,1);

CREATE TABLE `usuario` (
   `idUsuario` int NOT NULL AUTO_INCREMENT,
   `senha` varchar(45) NOT NULL,
   `email` varchar(45) NOT NULL,
   `cargo` varchar(45) NOT NULL,
   `imagem` MEDIUMBLOB null,
   PRIMARY KEY (`idUsuario`)
);

INSERT INTO usuario (senha, email, cargo) VALUES ('abc123', 'bruna@gmail.com', 'funcionario');
INSERT INTO usuario (senha, email, cargo) VALUES ('abc1234', 'maria@gmail.com', 'administrador');
INSERT INTO usuario (senha, email, cargo) VALUES ('abc12345', 'aguida@gmail.com', 'funcionario');


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
);
INSERT INTO `veiculo` VALUES (1,'Marcopolo','Paradiso G8 1050',100000000,2023,'Ar condicionado, GPS',5,'Azul','Passeio','diesel','ABC123','123456784','Disponivel');
INSERT INTO `veiculo` VALUES (2,'Scania','AGRALE/MASCA GRANMIDI O',134567.999,2023,'Banheiro',40,'Verde','Turismo','GNC','ABC222','987654321','Novo');

  -- SELECTS--

-- Select Veiculo --
SELECT COUNT(*) FROM Veiculo;
SELECT * FROM Veiculo ORDER By idVeiculo ASC;

-- Select endereco --
SELECT COUNT(*) FROM endereco;
SELECT * FROM endereco ORDER BY cep ASC;

-- Selects Clientes -- 
SELECT COUNT(*) FROM Clientes; 
SELECT * FROM Clientes ORDER BY cnpj ASC;

-- Select pedido --
SELECT count(*) FROM Pedido;
SELECT * FROM Pedido ORDER BY id_pedidos ASC;

-- Selects Usuario -- 
SELECT COUNT(*) FROM Usuario;
SELECT * FROM Usuario  ORDER BY idUsuario ASC;

-- Select funcionarios -- 
SELECT COUNT(*) FROM funcionarios;
SELECT * FROM funcionarios ORDER BY cpf ASC;