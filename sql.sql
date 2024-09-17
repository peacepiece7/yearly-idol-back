create schema yearly_idol;

-- -----------------------------------------------------
-- Table `yearly_idol`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yearly_idol`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(60) NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `profile_image` VARCHAR(255) NULL,
  `created_at` DATETIME NULL DEFAULT current_timestamp,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yearly_idol`.`scheduler`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yearly_idol`.`scheduler` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yearly_idol`.`scheduler-content`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yearly_idol`.`scheduler-content` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `scheduler_id` BIGINT NOT NULL,
  `type` VARCHAR(45) NOT NULL DEFAULT 'RANGE',
  `url` VARCHAR(45) NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  `content` TEXT NULL,
  `title` VARCHAR(255) NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'REGISTERED',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
