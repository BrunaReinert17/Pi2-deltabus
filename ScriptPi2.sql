 --- drop database deltaBus IF EXISTS ----
 
CREATE SCHEMA IF NOT EXISTS `deltaBus` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `deltaBus` ;

-- -----------------------------------------------------
-- Table `deltaBus`.`adiministrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deltaBus`.`adiministrador` (
  `idEmail` VARCHAR(25) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEmail`));

-- -----------------------------------------------------
-- Table `deltaBus`.`funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deltaBus`.`funcionarios` (
  `id_nome` VARCHAR(25) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  `numerotelefone` INT NOT NULL,
  `email` VARCHAR(35) NOT NULL,
  `cpf` DOUBLE NOT NULL,
  `cep` INT NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `funcao` VARCHAR(45) NOT NULL,
  `adiministrador_idEmail` VARCHAR(25) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `UF` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_nome`),
  INDEX `fk_funcionarios_adiministrador_idx` (`adiministrador_idEmail` ASC),
  CONSTRAINT `fk_funcionarios_adiministrador`
    FOREIGN KEY (`adiministrador_idEmail`)
    REFERENCES `deltaBus`.`adiministrador` (`idEmail`));

-- -----------------------------------------------------
-- Table `deltaBus`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deltaBus`.`Pedido` (
  `codigoVeiculo` VARCHAR(45) NOT NULL,
  `nomeCliente` VARCHAR(45) NOT NULL,
  `funcionarios_id_nome` VARCHAR(25) NOT NULL,
  `dataCompra` DATE NOT NULL,
  `valor` DOUBLE NOT NULL,
  `tipoPagamento` VARCHAR(45) NOT NULL,
  `quantidadeVeiculo` INT NOT NULL,
  INDEX `fk_cadastrarPedido_funcionarios1_idx` (`funcionarios_id_nome` ASC),
  PRIMARY KEY (`nomeCliente`),
  CONSTRAINT `fk_cadastrarPedido_funcionarios1`
    FOREIGN KEY (`funcionarios_id_nome`)
    REFERENCES `deltaBus`.`funcionarios` (`id_nome`));

-- -----------------------------------------------------
-- Table `deltaBus`.`Estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deltaBus`.`Estoque` (
  `Codigoveiculo` INT NOT NULL,
  `funcionarios_id_nome` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`Codigoveiculo`),
  INDEX `fk_consultarEstoque_funcionarios1_idx` (`funcionarios_id_nome` ASC),
  CONSTRAINT `fk_consultarEstoque_funcionarios1`
    FOREIGN KEY (`funcionarios_id_nome`)
    REFERENCES `deltaBus`.`funcionarios` (`id_nome`));

-- -----------------------------------------------------
-- Table `deltaBus`.`Veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deltaBus`.`Veiculo` (
  `codigoVeiculo` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `preco` DOUBLE NOT NULL,
  `ano` INT NOT NULL,
  `acessorios` VARCHAR(45) NOT NULL,
  `lotacao` INT NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `tipoFrota` VARCHAR(45) NOT NULL,
  `kmVeiculo` DOUBLE NOT NULL,
  `tipoCombustivel` VARCHAR(45) NOT NULL,
  `funcionarios_id_nome` VARCHAR(25) NOT NULL,
  `consultarEstoque_Codigoveiculo` INT NOT NULL,
  `cadastrarPedido_codigoVeiculo` VARCHAR(45) NOT NULL,
  INDEX `fk_cadastrarVeiculo_funcionarios1_idx` (`funcionarios_id_nome` ASC),
  INDEX `fk_cadastrarVeiculo_consultarEstoque1_idx` (`consultarEstoque_Codigoveiculo` ASC) ,
  INDEX `fk_cadastrarVeiculo_cadastrarPedido1_idx` (`cadastrarPedido_codigoVeiculo` ASC) ,
  PRIMARY KEY (`marca`),
    FOREIGN KEY (`funcionarios_id_nome`)
    REFERENCES `deltaBus`.`funcionarios` (`id_nome`),
    FOREIGN KEY (`consultarEstoque_Codigoveiculo`)
    REFERENCES `deltaBus`.`Estoque` (`Codigoveiculo`),
    FOREIGN KEY (`cadastrarPedido_codigoVeiculo`)
    REFERENCES `deltaBus`.`Pedido` (`nomeCliente`));

-- -----------------------------------------------------
-- Table `deltaBus`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deltaBus`.`endereco` (
  `cep` INT NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `funcionarios_id_nome` VARCHAR(25) NOT NULL,
  `UF` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cep`),
  INDEX `fk_endereco_funcionarios1_idx` (`funcionarios_id_nome` ASC),
  CONSTRAINT `fk_endereco_funcionarios1`
    FOREIGN KEY (`funcionarios_id_nome`)
    REFERENCES `deltaBus`.`funcionarios` (`id_nome`));

-- -----------------------------------------------------
-- Table `deltaBus`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `deltaBus`.`Clientes` (
  `idClienteNome` INT NOT NULL AUTO_INCREMENT,
  `numeroTelefone` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `cpf` DOUBLE NOT NULL,
  `cnpj` INT NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  `funcionarios_id_nome` VARCHAR(25) NOT NULL,
  `endereco_cep` INT NOT NULL,
  `cadastrarPedido_codigoVeiculo` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `UF` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idClienteNome`),
  INDEX `fk_cadastrarClientes_funcionarios1_idx` (`funcionarios_id_nome` ASC) VISIBLE,
  INDEX `fk_cadastrarClientes_endereco1_idx` (`endereco_cep` ASC) VISIBLE,
  INDEX `fk_cadastrarClientes_cadastrarPedido1_idx` (`cadastrarPedido_codigoVeiculo` ASC) VISIBLE,
  CONSTRAINT `fk_cadastrarClientes_funcionarios1`
    FOREIGN KEY (`funcionarios_id_nome`)
    REFERENCES `deltaBus`.`funcionarios` (`id_nome`),
    FOREIGN KEY (`endereco_cep`)
    REFERENCES `deltaBus`.`endereco` (`cep`),
    FOREIGN KEY (`cadastrarPedido_codigoVeiculo`)
    REFERENCES `deltaBus`.`Pedido` (`codigoVeiculo`));

    
    -- Select adiministrador --
    SELECT COUNT(*) FROM adiministrador;
SELECT * FROM adiministrador ORDER By idEmail ASC;

-- Select funcionarios --
SELECT COUNT(*) FROM funcionarios;
SELECT * FROM funcionarios ORDER BY id_nome ASC;

-- Selects Pedido -- 
SELECT COUNT(*) FROM Pedido; 
SELECT * FROM Pedido ORDER BY nomeCliente ASC;

-- Select Estoque --
SELECT COUNT(*) FROM Estoque;
SELECT * FROM Estoque ORDER BY Codigoveiculo ASC;

-- Selects Veiculo -- 
SELECT COUNT(*) FROM Veiculo;
SELECT * FROM Veiculo  ORDER BY marca ASC;

-- Select endereco -- 
SELECT COUNT(*) FROM endereco;
SELECT * FROM endereco ORDER BY cep ASC;

-- Select Clientes -- 
SELECT COUNT(*) FROM Clientes;
SELECT * FROM Clientes ORDER BY idClienteNome ASC;