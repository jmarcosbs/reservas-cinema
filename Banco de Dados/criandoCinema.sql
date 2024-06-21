CREATE SCHEMA IF NOT EXISTS `reserva_cinema` DEFAULT CHARACTER SET utf8 ;
USE `reserva_cinema` ;

-- -----------------------------------------------------
-- Table `reserva_cinema`.`filme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reserva_cinema`.`filme` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(70) NOT NULL,
  `sinopse` VARCHAR(500) NULL,
  `valor_ingresso` FLOAT NOT NULL,
  `horario` TIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reserva_cinema`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reserva_cinema`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(70) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reserva_cinema`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reserva_cinema`.`compra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `valor_compra` FLOAT NOT NULL,
  `data_compra` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reserva_cinema`.`assento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reserva_cinema`.`assento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo_assento` VARCHAR(3) NOT NULL,
  `FK_filme_id` INT NOT NULL,
  `ocupado` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`FK_filme_id`)
    REFERENCES `reserva_cinema`.`filme` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ingresso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reserva_cinema`.`ingresso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `FK_usuario_id` INT NOT NULL,
  `FK_compra_id` INT NOT NULL,
  `FK_filme_id` INT NOT NULL,
  `FK_assento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`FK_usuario_id`) REFERENCES `reserva_cinema`.`usuario` (`id`),
  FOREIGN KEY (`FK_compra_id`) REFERENCES `reserva_cinema`.`compra` (`id`),
  FOREIGN KEY (`FK_filme_id`) REFERENCES `reserva_cinema`.`filme` (`id`),
  FOREIGN KEY (`FK_assento_id`) REFERENCES `reserva_cinema`.`assento` (`id`)
);

