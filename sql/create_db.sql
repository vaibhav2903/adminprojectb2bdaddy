CREATE SCHEMA `b2bdaddy` ;

CREATE TABLE `b2bdaddy`.`status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `b2bdaddy`.`product_categories` (
  `category_id` INT(11) NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(300) NULL,
  `category_parent_id` INT(11) NULL,
  `category_level` INT(11) NULL DEFAULT 1,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`));
  
  ALTER TABLE `b2bdaddy`.`product_categories` 
ADD COLUMN `category_status` INT(11) NULL AFTER `category_level`,
ADD INDEX `category_Status_fk_idx` (`category_status` ASC) VISIBLE;
;
ALTER TABLE `b2bdaddy`.`product_categories` 
ADD CONSTRAINT `category_status_fk`
  FOREIGN KEY (`category_status`)
  REFERENCES `b2bdaddy`.`status` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  CREATE TABLE `b2bdaddy`.`product_categories_archive` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_category_id` INT(11) NULL,
  `last_updated_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `category_name` VARCHAR(45) NULL,
  `category_level` VARCHAR(45) NULL,
  `category_parant_id` VARCHAR(45) NULL,
  `product_categories_status` INT(11) NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `category_id_fk_idx` (`product_category_id` ASC) VISIBLE,
  INDEX `status_id_fk_idx` (`product_categories_status` ASC) VISIBLE,
  CONSTRAINT `category_id_fk`
    FOREIGN KEY (`product_category_id`)
    REFERENCES `b2bdaddy`.`product_categories` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `status_id_fk`
    FOREIGN KEY (`product_categories_status`)
    REFERENCES `b2bdaddy`.`status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
  