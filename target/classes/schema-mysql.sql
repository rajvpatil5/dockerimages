CREATE TABLE `test`.`message` (
  `message_id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NULL,
  `emailid` VARCHAR(45) NULL,
  `mobile_number` VARCHAR(45) NULL,
  `message_text` VARCHAR(500) NULL,
  PRIMARY KEY (`message_id`))
ENGINE = InnoDB;