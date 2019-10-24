CREATE TABLE `b2bdaddy`.`product_item` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_category_id` INT(11) NULL,
  `product_title` VARCHAR(500) NULL,
  `product_description` VARCHAR(1000) NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `product_created_by` INT(11) NULL,
  `product_last_updated_by` INT(11) NULL,
  PRIMARY KEY (`product_id`));
