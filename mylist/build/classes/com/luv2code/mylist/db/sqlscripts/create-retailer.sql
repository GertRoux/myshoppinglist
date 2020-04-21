CREATE USER 'hbstudent'@'localhost' IDENTIFIED BY 'hbstudent';

GRANT ALL PRIVILEGES ON * . * TO 'hbstudent'@'localhost';

#
# Starting with MySQL 8.0.4, the MySQL team changed the 
# default authentication plugin for MySQL server 
# from mysql_native_password to caching_sha2_password.
#
# The command below will make the appropriate updates for your user account.
#
# See the MySQL Reference Manual for details: 
# https://dev.mysql.com/doc/refman/8.0/en/caching-sha2-pluggable-authentication.html
#
ALTER USER 'hbstudent'@'localhost' IDENTIFIED WITH mysql_native_password BY 'hbstudent';

DROP SCHEMA IF EXISTS `mylist`;

CREATE SCHEMA `mylist`;

use mylist;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `retailer`;

CREATE TABLE `retailer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address_line_1` varchar(45) DEFAULT NULL,
  `address_line_2` varchar(45) DEFAULT NULL,
  `town` varchar(45) DEFAULT NULL,
  `address_city` varchar(45) DEFAULT NULL,
  `address_postal_code` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(255) NOT NULL,
  `brand_name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `price`;

CREATE TABLE `price` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `price` DOUBLE DEFAULT NULL,
  `date_of_purchase` DATETIME DEFAULT NULL,
  `retailer_id` INT(11) DEFAULT NULL,
  `product_id` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_RETAIL_idx` (`retailer_id`),
  KEY `FK_PRODUCT_idx` (`product_id`),
  CONSTRAINT `FK_RETAILER`
  FOREIGN KEY (`retailer_id`)
  REFERENCES `retailer` (`id`),
  CONSTRAINT `FK_PRODUCT`
  FOREIGN KEY (`product_id`)
  REFERENCES `product` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
