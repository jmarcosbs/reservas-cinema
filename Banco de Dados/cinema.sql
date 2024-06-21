-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`filmes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`filmes` (
  `id` INT NOT NULL,
  `titulo` VARCHAR(70) NOT NULL,
  `sinopse` VARCHAR(200) NULL,
  `valor_ingresso` FLOAT NOT NULL,
  `sala` INT NOT NULL,
  `horario` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(70) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`compra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `valor_compra` FLOAT NOT NULL,
  `data_compra` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`assentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`assentos` (
  `id` INT NOT NULL,
  `filmes_id` INT NOT NULL,
  PRIMARY KEY (`id`, `filmes_id`),
  INDEX `fk_assentos_filmes1_idx` (`filmes_id` ASC) VISIBLE,
  CONSTRAINT `fk_assentos_filmes1`
    FOREIGN KEY (`filmes_id`)
    REFERENCES `mydb`.`filmes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ingresso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ingresso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `FK_usuario_id` INT NOT NULL,
  `FK_compra_id` INT NOT NULL,
  `FK_filmes_id` INT NOT NULL,
  `FK_assentos_id` INT NOT NULL,
  PRIMARY KEY (`id`, `FK_usuario_id`, `FK_compra_id`, `FK_filmes_id`, `FK_assentos_id`),
  INDEX `fk_ingresso_usuario1_idx` (`FK_usuario_id` ASC) VISIBLE,
  INDEX `fk_ingresso_compra1_idx` (`FK_compra_id` ASC) VISIBLE,
  INDEX `fk_ingresso_filmes1_idx` (`FK_filmes_id` ASC) VISIBLE,
  INDEX `fk_ingresso_assentos1_idx` (`FK_assentos_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_ingresso_usuario1`
    FOREIGN KEY (`FK_usuario_id`)
    REFERENCES `mydb`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ingresso_compra1`
    FOREIGN KEY (`FK_compra_id`)
    REFERENCES `mydb`.`compra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ingresso_filmes1`
    FOREIGN KEY (`FK_filmes_id`)
    REFERENCES `mydb`.`filmes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ingresso_assentos1`
    FOREIGN KEY (`FK_assentos_id`)
    REFERENCES `mydb`.`assentos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
