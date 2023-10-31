 DROP DATABASE  IF EXISTS deltabus2;

CREATE SCHEMA IF NOT EXISTS `deltaBus2` ;
USE deltabus2;

-- -----------------------------------------------------
-- Table `deltaBus`.`Veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Veiculo` (
  `idVeiculo` BIGINT(45) NOT NULL auto_increment,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `preco` DOUBLE NOT NULL,
  `ano` INT NOT NULL,
  `acessorios` VARCHAR(45) NOT NULL,
  `lotacao` INT NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `tipoFrota` VARCHAR(45) NOT NULL,
  `tipoCombustivel` VARCHAR(45) NOT NULL,
   `placa` VARCHAR(45) NOT NULL,
  `renavam` VARCHAR(45) NOT NULL,
  `situacao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idVeiculo`));
ALTER TABLE Veiculo MODIFY COLUMN situacao VARCHAR(45) NOT NULL;

-- -----------------------------------------------------
-- Table `deltaBus`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `endereco` (
  `cep` INT NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `UF` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cep`));

-- -----------------------------------------------------
-- Table `deltaBus`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clientes` (
  `Nome`  VARCHAR(255) NOT NULL,
  `numeroTelefone` BIGINT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `cpf` DOUBLE NOT NULL,
  `cnpj` VARCHAR(30) NOT NULL,
  `endereco_cep` INT NOT NULL,
  PRIMARY KEY (`cnpj`),
    FOREIGN KEY (`endereco_cep`)
    REFERENCES `endereco` (`cep`));


-- -----------------------------------------------------
-- Table `deltaBus`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pedido` (
  `id_pedidos` int not null auto_increment,
  `dataCompra` DATE NOT NULL,
   `quantidade` int not null,
  `valorPago` DOUBLE NOT NULL,
  `tipoPagamento` VARCHAR(45) NOT NULL,
  `Cnpj` VARCHAR(30) NOT NULL,
  `renavam` VARCHAR(45) NOT NULL,
  `nomeCliente` VARCHAR(45) NOT NULL,
 PRIMARY KEY (`id_pedidos`));
 
  
-- -----------------------------------------------------
-- Table `deltaBus`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Usuario` (
  `idUsuario` int NOT NULL auto_increment,
  `senha` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`));

-- ----------------------------------------------------
-- Table `deltaBus`.`funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS funcionarios (
  `cpf` DOUBLE NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `dataNascimento` VARCHAR(45) NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  `numerotelefone` BIGINT NOT NULL,
  `email` VARCHAR(35) NOT NULL,
  `Usuario_idUsuario` int NOT NULL,
  `endereco_cep` INT NOT NULL,
  PRIMARY KEY (`cpf`),

    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `Usuario` (`idUsuario`),
 
    FOREIGN KEY (`endereco_cep`)
    REFERENCES `endereco` (`cep`));
    
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

-- INSERT Veiculo --
-- NAO VAI ID 
INSERT INTO Veiculo (marca, modelo, preco, ano, acessorios, lotacao, cor, tipoFrota, tipoCombustivel, placa, renavam, situacao) 
VALUES ('Marcopolo', 'Paradiso G8 1050', 100000000.00, '2023', 'Ar condicionado, GPS', 5, 'Azul', 'Passeio', 'diesel', 'ABC123', '123456784','Disponivel');

-- INSERT endereco --
-- NAO PODE CEP REPETIDO 
INSERT INTO endereco (cep, cidade, bairro, rua,UF)
VALUES ('21346562', 'Blumenau', 'Progresso', 'Rua Ernestine Ehrhardt', 'SC');


-- INSERT  Clientes--
-- NAO PODE CPF REPETIDO 
INSERT INTO Clientes (Nome, numeroTelefone, email, cpf,cnpj, endereco_cep) 
VALUES ("Gisele" , '1234567892', 'gisele@gmail.com', 4545545441,464646546468437, 21346562);


-- INSERT Pedido --
-- NAO COLOCA ID, O proprio banco COLOCA
INSERT INTO Pedido (dataCompra, quantidade, valorPago, tipoPagamento, renavam, Cnpj, nomeCliente) 
VALUES ('2023-08-16', 5, 15000.00, 'Cartao',123456784,464646546468437, "Laura" );

--  INSERT Usuario --
INSERT INTO Usuario ( senha, email, cargo)
VALUES ( '1312', 'bruna@gmail.com', 'administrador');

INSERT INTO Usuario ( senha, email, cargo)
VALUES ( '1234', 'maria@gmail.com', 'funcionario');

-- INSERT administrador--
-- INSERT INTO adiministrador ( idEmail, senha) VALUES ('agatha.c2009@gmail.com','Agatha')--

-- INSERT Funcionario --
INSERT INTO funcionarios (cpf, nome, dataNascimento, genero, numerotelefone,email, Usuario_idUsuario, endereco_cep) 
VALUES ('14058568', 'Agatha Cristine Onofre Ribeiro','2004-01-19','Feminino', 987654325,'agatha@gmail.com','1',21346562);