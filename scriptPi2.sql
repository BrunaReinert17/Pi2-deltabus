-- DROP DATABASES deltaBus IF EXISTS --
CREATE SCHEMA IF NOT EXISTS `deltaBus` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `deltaBus` ;

-- -----------------------------------------------------
-- Table `deltaBus`.`Veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deltaBus`.`Veiculo` (
  `idVeiculo` BIGINT(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `preco` DOUBLE NOT NULL,
  `ano` DATE NOT NULL,
  `acessorios` VARCHAR(45) NOT NULL,
  `lotacao` INT NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `tipoFrota` VARCHAR(45) NOT NULL,
  `tipoCombustivel` VARCHAR(45) NOT NULL,
  `consultarEstoque_Codigoveiculo` INT NOT NULL,
  `placa` VARCHAR(45) NOT NULL,
  `renavam` VARCHAR(45) NOT NULL,
  `situacao` TINYINT NOT NULL,
  PRIMARY KEY (`idVeiculo`));

-- -----------------------------------------------------
-- Table `deltaBus`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deltaBus`.`endereco` (
  `cep` INT NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `UF` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cep`));


-- -----------------------------------------------------
-- Table `deltaBus`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deltaBus`.`Clientes` (
  `Nome` INT NOT NULL AUTO_INCREMENT,
  `numeroTelefone` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `cpf` DOUBLE NOT NULL,
  `cnpj` INT NOT NULL,
  `endereco_cep` INT NOT NULL,
  PRIMARY KEY (`cnpj`),
  INDEX `fk_cadastrarClientes_endereco1_idx` (`endereco_cep` ASC) VISIBLE,
  CONSTRAINT `fk_cadastrarClientes_endereco1`
    FOREIGN KEY (`endereco_cep`)
    REFERENCES `deltaBus`.`endereco` (`cep`));

-- -----------------------------------------------------
-- Table `deltaBus`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deltaBus`.`Pedido` (
  `dataCompra` DATE NOT NULL,
  `valorPago` DOUBLE NOT NULL,
  `tipoPagamento` VARCHAR(45) NOT NULL,
  `pedidoIs` VARCHAR(45) NOT NULL,
  `Veiculo_idVeiculo` BIGINT(45) NOT NULL,
  `Clientes_cnpj` DOUBLE NOT NULL,
  PRIMARY KEY (`pedidoIs`),
  INDEX `fk_Pedido_Veiculo_idx` (`Veiculo_idVeiculo` ASC) VISIBLE,
  INDEX `fk_Pedido_Clientes1_idx` (`Clientes_cnpj` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_Veiculo`
    FOREIGN KEY (`Veiculo_idVeiculo`)
    REFERENCES `deltaBus`.`Veiculo` (`idVeiculo`),
  CONSTRAINT `fk_Pedido_Clientes1`
    FOREIGN KEY (`Clientes_cnpj`)
    REFERENCES `deltaBus`.`Clientes` (`cnpj`));


-- -----------------------------------------------------
-- Table `deltaBus`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deltaBus`.`Usuario` (
  `idUsuario` VARCHAR(25) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`));

-- ----------------------------------------------------
-- Table `deltaBus`.`funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deltaBus`.`funcionarios` (
  `cpf` DOUBLE NOT NULL,
  `nome` VARCHAR(25) NOT NULL,
  `dataNascimento` VARCHAR(45) NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  `numerotelefone` INT NOT NULL,
  `email` VARCHAR(35) NOT NULL,
  `Usuario_idUsuario` VARCHAR(25) NOT NULL,
  `endereco_cep` INT NOT NULL,
  PRIMARY KEY (`cpf`),
  INDEX `fk_funcionarios_Usuario1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  INDEX `fk_funcionarios_endereco1_idx` (`endereco_cep` ASC) VISIBLE,
  CONSTRAINT `fk_funcionarios_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `deltaBus`.`Usuario` (`idUsuario`),
  CONSTRAINT `fk_funcionarios_endereco1`
    FOREIGN KEY (`endereco_cep`)
    REFERENCES `deltaBus`.`endereco` (`cep`));

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

-- Select Pedido --
SELECT COUNT(*) FROM Pedido;
SELECT * FROM Pedido ORDER BY pedidoIs ASC;

-- Selects Usuario -- 
SELECT COUNT(*) FROM Usuario;
SELECT * FROM Usuario  ORDER BY idUsuario ASC;

-- Select funcionarios -- 
SELECT COUNT(*) FROM funcionarios;
SELECT * FROM funcionarios ORDER BY cpf ASC;