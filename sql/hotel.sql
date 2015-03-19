-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hotel
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotel` DEFAULT CHARACTER SET utf8 ;
USE `hotel` ;

-- -----------------------------------------------------
-- Table `hotel`.`food_menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`food_menu` ;

CREATE TABLE IF NOT EXISTS `hotel`.`food_menu` (
  `idfood` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `price` FLOAT NOT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `amount_available` INT NOT NULL COMMENT 'number of item available',
  PRIMARY KEY (`idfood`),
  UNIQUE INDEX `idfood_UNIQUE` (`idfood` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'list of food the hotel offers';


-- -----------------------------------------------------
-- Table `hotel`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`user` ;

CREATE TABLE IF NOT EXISTS `hotel`.`user` (
  `iduser` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) NOT NULL COMMENT 'Max chars in username is 20',
  `password` VARCHAR(40) NOT NULL COMMENT 'SHA-1 algorithm will be used to store passwords which generates 40 chars long hash value',
  `email` VARCHAR(45) NOT NULL COMMENT 'Max chars in email is 45',
  `user_type` TINYINT(4) NOT NULL COMMENT 'Account type: admin, registered user, ....',
  `created_date` DATETIME NOT NULL COMMENT 'Date when the user was created',
  `activated_date` DATETIME NULL DEFAULT NULL COMMENT 'Date of account verification.\nIf the user doesnt activate the account within a certain time period after creating the account, the user will be deleted.',
  `deactivated_date` DATETIME NULL DEFAULT NULL COMMENT 'In case user was deactivated for any reason the date will be shown here',
  `confirmation_key` VARCHAR(40) NOT NULL COMMENT 'SHA-1 algorithm based on username, email or other unique user properties',
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `idUser_UNIQUE` (`iduser` ASC),
  UNIQUE INDEX `EMAIL_UNIQUE` (`email` ASC),
  UNIQUE INDEX `USERNAME_UNIQUE` (`username` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hotel`.`food_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`food_order` ;

CREATE TABLE IF NOT EXISTS `hotel`.`food_order` (
  `idfood_order` INT(11) NOT NULL AUTO_INCREMENT,
  `order_name` VARCHAR(45) NOT NULL COMMENT 'will be based on username and an incremental number',
  `oder_date` DATETIME NOT NULL,
  `amount` INT NOT NULL DEFAULT 1,
  `order_price` FLOAT NOT NULL,
  `user_iduser` INT(11) NOT NULL,
  `food_menu_idfood` INT(11) NOT NULL,
  PRIMARY KEY (`idfood_order`, `user_iduser`, `food_menu_idfood`),
  UNIQUE INDEX `idfood_order_UNIQUE` (`idfood_order` ASC),
  INDEX `fk_food_order_user1_idx` (`user_iduser` ASC),
  INDEX `fk_food_order_food_menu1_idx` (`food_menu_idfood` ASC),
  CONSTRAINT `fk_food_order_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `hotel`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_food_order_food_menu1`
    FOREIGN KEY (`food_menu_idfood`)
    REFERENCES `hotel`.`food_menu` (`idfood`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'list of food ordered by user';


-- -----------------------------------------------------
-- Table `hotel`.`resource_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`resource_type` ;

CREATE TABLE IF NOT EXISTS `hotel`.`resource_type` (
  `idresource_type` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(256) NOT NULL,
  `price` FLOAT NOT NULL,
  `qunatity` INT NOT NULL,
  PRIMARY KEY (`idresource_type`),
  UNIQUE INDEX `idresource_type_UNIQUE` (`idresource_type` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Hotel resource types are static and new resource types cant be added.\nResource types are defined during developement stage (all resource types that the hotel contains).';


-- -----------------------------------------------------
-- Table `hotel`.`image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`image` ;

CREATE TABLE IF NOT EXISTS `hotel`.`image` (
  `idimage` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `location` VARCHAR(100) NOT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `resource_type_idresource_type` INT(11) NOT NULL,
  PRIMARY KEY (`idimage`, `resource_type_idresource_type`),
  UNIQUE INDEX `idimage_UNIQUE` (`idimage` ASC),
  INDEX `fk_image_resource_type1_idx` (`resource_type_idresource_type` ASC),
  CONSTRAINT `fk_image_resource_type1`
    FOREIGN KEY (`resource_type_idresource_type`)
    REFERENCES `hotel`.`resource_type` (`idresource_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'pictures of hotel interior and exterior';


-- -----------------------------------------------------
-- Table `hotel`.`keycard`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`keycard` ;

CREATE TABLE IF NOT EXISTS `hotel`.`keycard` (
  `idkeycard` INT(11) NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(10) NOT NULL COMMENT 'unique number to each keycard based on which the keycard is identified',
  `access_identifier` VARCHAR(10) NOT NULL DEFAULT '0000000000' COMMENT 'identifier used to give access to hotel resources',
  PRIMARY KEY (`idkeycard`),
  UNIQUE INDEX `idkeycard_UNIQUE` (`idkeycard` ASC),
  UNIQUE INDEX `number_UNIQUE` (`number` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Keycards handed out to users that are staying at the hotel.\nEach room has its own keycard.\nKeycards have semi-static values, each room has exactly one keycard so when a keycard is lost it needs to be disabled and replaced.\nHotel resources can be accessed based on the access identifier on the keycard (spa, swimming pool, sauna, conference room, ...)';


-- -----------------------------------------------------
-- Table `hotel`.`location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`location` ;

CREATE TABLE IF NOT EXISTS `hotel`.`location` (
  `idlocation` INT(11) NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(45) NOT NULL,
  `latitude` FLOAT NOT NULL,
  `longitude` FLOAT NOT NULL,
  PRIMARY KEY (`idlocation`),
  UNIQUE INDEX `idlocation_UNIQUE` (`idlocation` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hotel`.`reservation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`reservation` ;

CREATE TABLE IF NOT EXISTS `hotel`.`reservation` (
  `idreservation` INT(11) NOT NULL AUTO_INCREMENT,
  `from_date` DATETIME NOT NULL COMMENT 'reservation start date and time',
  `to_date` DATETIME NOT NULL COMMENT 'reservation end date and time',
  `price` FLOAT NOT NULL,
  `status` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '0 - not activated\n1 - currently active (activates on check_in_date)\n2 - expired (activates on check_out_date)',
  `type` TINYINT(4) NULL DEFAULT NULL COMMENT '0 - rooms, apartments and suites\n1 - indoor swimming pool\n2 - sauna\n3 - conference room\n4 - ...',
  `user_iduser` INT(11) NOT NULL,
  PRIMARY KEY (`idreservation`, `user_iduser`),
  UNIQUE INDEX `idreservation_UNIQUE` (`idreservation` ASC),
  INDEX `fk_reservation_user1_idx` (`user_iduser` ASC),
  CONSTRAINT `fk_reservation_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `hotel`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'hotel resrervations (includes all hotel resources';


-- -----------------------------------------------------
-- Table `hotel`.`resource`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`resource` ;

CREATE TABLE IF NOT EXISTS `hotel`.`resource` (
  `idresource` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL COMMENT 'Name of the resource',
  `occupied` BINARY(1) NOT NULL DEFAULT '0' COMMENT '1 - room has a guest currently\n0 - room is free',
  `available` BINARY(1) NOT NULL DEFAULT '1' COMMENT '1 - resource can be used\n0 - resource can\'t be used',
  `availability_status` VARCHAR(64) NULL DEFAULT 'available' COMMENT 'description of the resources status: available, renovating, ...',
  `availability_date` DATETIME NULL DEFAULT NULL COMMENT 'date when the resource will be available again in case it is known (cleaning for example), it will be automatically set back to available resources once the date and time has been reached.',
  `resource_type_idresource_type` INT(11) NOT NULL,
  `keycard_idkeycard` INT(11) NOT NULL,
  `user_iduser` INT(11) NOT NULL,
  PRIMARY KEY (`idresource`, `resource_type_idresource_type`, `keycard_idkeycard`, `user_iduser`),
  UNIQUE INDEX `idresource_UNIQUE` (`idresource` ASC),
  INDEX `fk_resource_resource_type_idx` (`resource_type_idresource_type` ASC),
  INDEX `fk_resource_keycard1_idx` (`keycard_idkeycard` ASC),
  INDEX `fk_resource_user1_idx` (`user_iduser` ASC),
  CONSTRAINT `fk_resource_resource_type`
    FOREIGN KEY (`resource_type_idresource_type`)
    REFERENCES `hotel`.`resource_type` (`idresource_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resource_keycard1`
    FOREIGN KEY (`keycard_idkeycard`)
    REFERENCES `hotel`.`keycard` (`idkeycard`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resource_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `hotel`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Hotel resources (rooms, apartments, suites, ...)\nHotel resources are static and new resources cant be added. Resources can be however temporary disabled (in case a room needs cleaning, renovating or similar).\nResources are defined during developement stage (all resources that the hotel contains).';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
