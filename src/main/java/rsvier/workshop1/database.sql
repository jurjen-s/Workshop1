-- MySQL Script generated by MySQL Workbench
-- Tue 07 Feb 2017 03:01:59 PM CET
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`accounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`accounts` ;

CREATE TABLE IF NOT EXISTS `mydb`.`accounts` (
  `accounts_id` INT NOT NULL AUTO_INCREMENT,
  `accounts_type` INT NOT NULL,
  `wachtwoord` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`accounts_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`medewerkers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`medewerkers` ;

CREATE TABLE IF NOT EXISTS `mydb`.`medewerkers` (
  `medewerkers_id` INT NOT NULL AUTO_INCREMENT,
  `FK__medewerkers_accounts_id` INT NOT NULL,
  `email` VARCHAR(45) NULL,
  `voornaam` VARCHAR(45) NULL,
  `tussenvoegsel` VARCHAR(45) NULL,
  `achternaam` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`medewerkers_id`, `FK__medewerkers_accounts_id`),
  INDEX `fk_Medewerker_Account1_idx` (`FK__medewerkers_accounts_id` ASC),
  CONSTRAINT `FK_medewerkers_accounts_id`
    FOREIGN KEY (`FK__medewerkers_accounts_id`)
    REFERENCES `mydb`.`accounts` (`accounts_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`adressen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`adressen` ;

CREATE TABLE IF NOT EXISTS `mydb`.`adressen` (
  `adressen_id` INT NOT NULL AUTO_INCREMENT,
  `adresssen_type` INT NOT NULL,
  `FK_adressen_klanten_id` INT NOT NULL,
  `straatnaam` VARCHAR(45) NOT NULL,
  `huisnummer` INT NOT NULL,
  `heeft_huisnr_toevoeging` TINYINT(1) NOT NULL DEFAULT 0,
  `huisnummer_toevoeging` VARCHAR(45) NULL,
  `postcode` VARCHAR(45) NOT NULL,
  `land` VARCHAR(45) NULL DEFAULT 'Nederland',
  PRIMARY KEY (`adressen_id`, `adresssen_type`, `FK_adressen_klanten_id`),
  INDEX `FK_klanten_id_idx` (`FK_adressen_klanten_id` ASC),
  CONSTRAINT `FK_adressen_klanten_id`
    FOREIGN KEY (`FK_adressen_klanten_id`)
    REFERENCES `mydb`.`klanten` (`klanten_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`klanten`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`klanten` ;

CREATE TABLE IF NOT EXISTS `mydb`.`klanten` (
  `klanten_id` INT NOT NULL AUTO_INCREMENT,
  `FK_klanten_accounts_id` INT NOT NULL,
  `FK_klanten_adressen_id` INT NULL,
  `voornaam` VARCHAR(45) NULL,
  `heeft_tussenvoegsel` TINYINT(1) NOT NULL DEFAULT 0,
  `tussenvoegsel` VARCHAR(45) NULL,
  `achternaam` VARCHAR(45) NOT NULL,
  `telefoonnummer` INT(13) NULL,
  PRIMARY KEY (`klanten_id`, `FK_klanten_accounts_id`),
  INDEX `fk_Klant_Account1_idx` (`FK_klanten_accounts_id` ASC),
  INDEX `FK_adressen_klant_idx` (`FK_klanten_adressen_id` ASC),
  CONSTRAINT `FK_klanten_accounts_id`
    FOREIGN KEY (`FK_klanten_accounts_id`)
    REFERENCES `mydb`.`accounts` (`accounts_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_klanten_adressen_id`
    FOREIGN KEY (`FK_klanten_adressen_id`)
    REFERENCES `mydb`.`adressen` (`adressen_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`producten`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`producten` ;

CREATE TABLE IF NOT EXISTS `mydb`.`producten` (
  `producten_id` INT NOT NULL AUTO_INCREMENT,
  `omschrijving` VARCHAR(45) NULL,
  `soort` VARCHAR(45) NOT NULL,
  `prijs` DECIMAL(10,2) NOT NULL,
  `voorraad` INT NULL,
  PRIMARY KEY (`producten_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`bestellingen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`bestellingen` ;

CREATE TABLE IF NOT EXISTS `mydb`.`bestellingen` (
  `bestellingen_id` INT NOT NULL AUTO_INCREMENT,
  `FK_bestellingen_klanten_id` INT NOT NULL,
  `FK_bestellingen_adressen_id` INT NOT NULL,
  `aantal_artikelen` INT NULL,
  `totaalprijs` DECIMAL(10,2) NULL,
  PRIMARY KEY (`bestellingen_id`, `FK_bestellingen_klanten_id`),
  INDEX `fk_Bestelling_Klant1_idx` (`FK_bestellingen_klanten_id` ASC),
  INDEX `FK_adressen_bestelling_idx` (`FK_bestellingen_adressen_id` ASC),
  CONSTRAINT `FK_bestellingen_klanten_id`
    FOREIGN KEY (`FK_bestellingen_klanten_id`)
    REFERENCES `mydb`.`klanten` (`klanten_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_bestellingen_adressen_id`
    FOREIGN KEY (`FK_bestellingen_adressen_id`)
    REFERENCES `mydb`.`adressen` (`adressen_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`bestelregels`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`bestelregels` ;

CREATE TABLE IF NOT EXISTS `mydb`.`bestelregels` (
  `bestellingregels_id` INT NOT NULL AUTO_INCREMENT,
  `FK_bestellingregels_bestellingen_id` INT NOT NULL,
  `FK_bestellingregels_producten_id` INT NOT NULL,
  `hoeveelheid` INT NOT NULL,
  INDEX `idBestelling_idx` (`FK_bestellingregels_bestellingen_id` ASC),
  PRIMARY KEY (`bestellingregels_id`),
  INDEX `FK_bestellingregels_producten_id_idx` (`FK_bestellingregels_producten_id` ASC),
  CONSTRAINT `FK_bestellingregels_producten_id`
    FOREIGN KEY (`FK_bestellingregels_producten_id`)
    REFERENCES `mydb`.`producten` (`producten_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_bestellingregels_bestellingen_id`
    FOREIGN KEY (`FK_bestellingregels_bestellingen_id`)
    REFERENCES `mydb`.`bestellingen` (`bestellingen_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`facturen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`facturen` ;

CREATE TABLE IF NOT EXISTS `mydb`.`facturen` (
  `facturen_id` INT NOT NULL AUTO_INCREMENT,
  `FK_facturen_bestellingen_id` INT NOT NULL,
  `FK_facturen_adressen_id` INT NOT NULL,
  `totaalprijs` DECIMAL(10,2) NOT NULL,
  `status` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`facturen_id`, `FK_facturen_bestellingen_id`),
  INDEX `fk_Betaling_Bestelling1_idx` (`FK_facturen_bestellingen_id` ASC),
  INDEX `FK_adressen_factuur_idx` (`FK_facturen_adressen_id` ASC),
  CONSTRAINT `FK_facturen_bestellingen_id`
    FOREIGN KEY (`FK_facturen_bestellingen_id`)
    REFERENCES `mydb`.`bestellingen` (`bestellingen_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_facturen_adressen_id`
    FOREIGN KEY (`FK_facturen_adressen_id`)
    REFERENCES `mydb`.`adressen` (`adressen_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

GRANT SELECT ON TABLE `mydb`.* TO 'klant';
GRANT SELECT, INSERT, TRIGGER ON TABLE `mydb`.* TO 'medewerker';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `mydb`.* TO 'medewerker';
GRANT SELECT ON TABLE `mydb`.* TO 'medewerker';
GRANT ALL ON `mydb`.* TO 'admin';
GRANT ALL ON TABLE `mydb`.`klanten` TO 'admin';
GRANT ALL ON `mydb`.* TO 'test';
GRANT ALL ON TABLE `mydb`.`klanten` TO 'test';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
