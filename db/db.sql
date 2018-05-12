-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_gecon
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `db_gecon` ;

-- -----------------------------------------------------
-- Schema db_gecon
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_gecon` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `db_gecon` ;

-- -----------------------------------------------------
-- Table `db_gecon`.`tb_condominio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gecon`.`tb_condominio` (
  `idt_condominio` INT NOT NULL AUTO_INCREMENT,
  `nme_condominio` VARCHAR(45) NOT NULL,
  `dsc_local_condominio` TEXT NOT NULL,
  PRIMARY KEY (`idt_condominio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_gecon`.`tb_residencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gecon`.`tb_residencia` (
  `idt_residencia` INT NOT NULL AUTO_INCREMENT,
  `cod_condominio` INT NOT NULL,
  `dsc_bloco_residencia` VARCHAR(255) NOT NULL,
  `dsc_residencia` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idt_residencia`),
  INDEX `fk_tb_residencia_tb_condominio1_idx` (`cod_condominio` ASC),
  CONSTRAINT `fk_tb_residencia_tb_condominio1`
    FOREIGN KEY (`cod_condominio`)
    REFERENCES `db_gecon`.`tb_condominio` (`idt_condominio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_gecon`.`tb_pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gecon`.`tb_pessoa` (
  `idt_pessoa` INT NOT NULL AUTO_INCREMENT,
  `nme_pessoa` VARCHAR(45) NOT NULL,
  `cpf_pessoa` VARCHAR(45) NOT NULL,
  `dta_nasc_pessoa` DATE NOT NULL,
  `tel_pessoa` VARCHAR(45) NOT NULL,
  `eml_pessoa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idt_pessoa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_gecon`.`ta_morador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gecon`.`ta_morador` (
  `idt_morador` INT NOT NULL AUTO_INCREMENT,
  `cod_pessoa` INT NOT NULL,
  `cod_residencia` INT NOT NULL,
  PRIMARY KEY (`idt_morador`),
  INDEX `fk_tb_morador_tb_pessoa1_idx` (`cod_pessoa` ASC),
  INDEX `fk_tb_morador_tb_residencia1_idx` (`cod_residencia` ASC),
  CONSTRAINT `fk_tb_morador_tb_pessoa1`
    FOREIGN KEY (`cod_pessoa`)
    REFERENCES `db_gecon`.`tb_pessoa` (`idt_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_morador_tb_residencia1`
    FOREIGN KEY (`cod_residencia`)
    REFERENCES `db_gecon`.`tb_residencia` (`idt_residencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_gecon`.`ta_visita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gecon`.`ta_visita` (
  `idt_visita` INT NOT NULL AUTO_INCREMENT,
  `cod_pessoa` INT NOT NULL,
  `cod_morador` INT NOT NULL,
  `dta_inicio_visita` DATE NOT NULL,
  `dta_final_visita` DATE NULL,
  PRIMARY KEY (`idt_visita`),
  INDEX `fk_tb_visita_tb_pessoa1_idx` (`cod_pessoa` ASC),
  INDEX `fk_ta_visita_ta_morador1_idx` (`cod_morador` ASC),
  CONSTRAINT `fk_tb_visita_tb_pessoa1`
    FOREIGN KEY (`cod_pessoa`)
    REFERENCES `db_gecon`.`tb_pessoa` (`idt_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ta_visita_ta_morador1`
    FOREIGN KEY (`cod_morador`)
    REFERENCES `db_gecon`.`ta_morador` (`idt_morador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_gecon`.`tb_ocorrencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gecon`.`tb_ocorrencia` (
  `idt_ocorrencia` INT NOT NULL AUTO_INCREMENT,
  `cod_morador` INT NOT NULL,
  `dta_ocorrencia` DATETIME NOT NULL,
  `dsc_ocorrencia` TEXT NOT NULL,
  PRIMARY KEY (`idt_ocorrencia`),
  INDEX `fk_tb_ocorrencia_ta_morador1_idx` (`cod_morador` ASC),
  CONSTRAINT `fk_tb_ocorrencia_ta_morador1`
    FOREIGN KEY (`cod_morador`)
    REFERENCES `db_gecon`.`ta_morador` (`idt_morador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_gecon`.`tb_garagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gecon`.`tb_garagem` (
  `idt_garagem` INT NOT NULL AUTO_INCREMENT,
  `cod_residencia` INT NOT NULL,
  `dsc_garagem` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idt_garagem`),
  INDEX `fk_tb_garagem_tb_residencia1_idx` (`cod_residencia` ASC),
  CONSTRAINT `fk_tb_garagem_tb_residencia1`
    FOREIGN KEY (`cod_residencia`)
    REFERENCES `db_gecon`.`tb_residencia` (`idt_residencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_gecon`.`tb_forum`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gecon`.`tb_forum` (
  `idt_forum` INT NOT NULL AUTO_INCREMENT,
  `cod_morador` INT NOT NULL,
  `tit_forum` VARCHAR(255) NOT NULL,
  `dsc_forum` TEXT NOT NULL,
  `dta_cadastro_forum` DATETIME NOT NULL,
  PRIMARY KEY (`idt_forum`),
  INDEX `fk_tb_forum_ta_morador1_idx` (`cod_morador` ASC),
  CONSTRAINT `fk_tb_forum_ta_morador1`
    FOREIGN KEY (`cod_morador`)
    REFERENCES `db_gecon`.`ta_morador` (`idt_morador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_gecon`.`tb_area_lazer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gecon`.`tb_area_lazer` (
  `idt_area_lazer` INT NOT NULL AUTO_INCREMENT,
  `cod_condominio` INT NOT NULL,
  `dsc_area_lazer` VARCHAR(255) NOT NULL,
  `cap_max_area_lazer` INT NOT NULL,
  `vlr_reserva_area_lazer` DOUBLE NULL,
  PRIMARY KEY (`idt_area_lazer`),
  INDEX `fk_tb_area_lazer_tb_condominio1_idx` (`cod_condominio` ASC),
  CONSTRAINT `fk_tb_area_lazer_tb_condominio1`
    FOREIGN KEY (`cod_condominio`)
    REFERENCES `db_gecon`.`tb_condominio` (`idt_condominio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_gecon`.`ta_reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gecon`.`ta_reserva` (
  `idt_reserva` INT NOT NULL AUTO_INCREMENT,
  `cod_area_lazer` INT NOT NULL,
  `cod_morador` INT NOT NULL,
  `dta_inicio_reserva` DATETIME NOT NULL,
  `dta_fim_reserva` DATETIME NOT NULL,
  `dta_cadastro_reserva` DATETIME NOT NULL,
  `sts_confirmado_reserva` CHAR NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idt_reserva`),
  INDEX `fk_tb_reserva_tb_area_lazer1_idx` (`cod_area_lazer` ASC),
  INDEX `fk_ta_reserva_ta_morador1_idx` (`cod_morador` ASC),
  CONSTRAINT `fk_tb_reserva_tb_area_lazer1`
    FOREIGN KEY (`cod_area_lazer`)
    REFERENCES `db_gecon`.`tb_area_lazer` (`idt_area_lazer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ta_reserva_ta_morador1`
    FOREIGN KEY (`cod_morador`)
    REFERENCES `db_gecon`.`ta_morador` (`idt_morador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_gecon`.`tb_mensagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gecon`.`tb_mensagem` (
  `idt_mensagem` INT NOT NULL AUTO_INCREMENT,
  `cod_forum` INT NOT NULL,
  `cod_morador` INT NOT NULL,
  `txt_mensagem` TEXT NOT NULL,
  `dta_mensagem` DATETIME NOT NULL,
  PRIMARY KEY (`idt_mensagem`),
  INDEX `fk_tb_mensagem_tb_forum1_idx` (`cod_forum` ASC),
  INDEX `fk_tb_mensagem_ta_morador1_idx` (`cod_morador` ASC),
  CONSTRAINT `fk_tb_mensagem_tb_forum1`
    FOREIGN KEY (`cod_forum`)
    REFERENCES `db_gecon`.`tb_forum` (`idt_forum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_mensagem_ta_morador1`
    FOREIGN KEY (`cod_morador`)
    REFERENCES `db_gecon`.`ta_morador` (`idt_morador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_gecon`.`td_perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gecon`.`td_perfil` (
  `idt_perfil` INT NOT NULL AUTO_INCREMENT,
  `nme_perfil` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idt_perfil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_gecon`.`tb_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gecon`.`tb_usuario` (
  `idt_usuario` INT NOT NULL AUTO_INCREMENT,
  `login_usuario` VARCHAR(80) NOT NULL,
  `pwd_usuario` VARCHAR(255) NOT NULL,
  `cod_morador` INT NOT NULL,
  `cod_perfil` INT NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  INDEX `fk_tb_usuario_ta_morador1_idx` (`cod_morador` ASC),
  INDEX `fk_tb_usuario_td_perfil1_idx` (`cod_perfil` ASC),
  PRIMARY KEY (`idt_usuario`),
  CONSTRAINT `fk_tb_usuario_ta_morador1`
    FOREIGN KEY (`cod_morador`)
    REFERENCES `db_gecon`.`ta_morador` (`idt_morador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_usuario_td_perfil1`
    FOREIGN KEY (`cod_perfil`)
    REFERENCES `db_gecon`.`td_perfil` (`idt_perfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `db_gecon`.`td_perfil`
-- -----------------------------------------------------
START TRANSACTION;
USE `db_gecon`;
INSERT INTO `db_gecon`.`td_perfil` (`idt_perfil`, `nme_perfil`) VALUES (1, 'Administrador');
INSERT INTO `db_gecon`.`td_perfil` (`idt_perfil`, `nme_perfil`) VALUES (2, 'Funcionário');
INSERT INTO `db_gecon`.`td_perfil` (`idt_perfil`, `nme_perfil`) VALUES (3, 'Morador');

COMMIT;


