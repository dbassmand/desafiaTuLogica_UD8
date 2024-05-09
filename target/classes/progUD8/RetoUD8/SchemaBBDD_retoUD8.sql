-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tucine
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tucine
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tucine` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `tucine` ;

-- -----------------------------------------------------
-- Table `tucine`.`cines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tucine`.`cines` (
  `identificador` INT NOT NULL AUTO_INCREMENT,
  `nombreCine` VARCHAR(255) NOT NULL,
  `direccion` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`identificador`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tucine`.`peliculas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tucine`.`peliculas` (
  `identificador` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(255) NOT NULL,
  `duracionMinutos` INT NOT NULL,
  `genero` VARCHAR(50) NOT NULL,
  `director` VARCHAR(255) NOT NULL,
  `clasificacionEdad` ENUM('G', 'PG-13', 'R', 'NC-17') NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`identificador`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tucine`.`salas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tucine`.`salas` (
  `identificador` INT NOT NULL AUTO_INCREMENT,
  `capacidad` INT NOT NULL,
  `metrosCuadrados` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`identificador`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
