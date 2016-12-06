CREATE SCHEMA IF NOT EXISTS java302;
USE java302 ;

CREATE TABLE IF NOT EXISTS java302.shopping_list (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name  VARCHAR(45) NOT NULL,
	color VARCHAR(20) NOT NULL,
	created_utc VARCHAR(45) NOT NULL,
	modified_utc VARCHAR(45) NULL,
	PRIMARY KEY (id));
	
CREATE TABLE IF NOT EXISTS java302.shopping_list_item (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	shopping_list_id INT UNSIGNED NOT NULL,
	contents VARCHAR(100) NOT NULL,
	priority INT NOT NULL,
	is_checked tinyint(1) NOT NULL DEFAULT 0,	
	created_utc VARCHAR(45) NOT NULL,
	modified_utc VARCHAR(45) NULL,
	PRIMARY KEY (id));
	
CREATE TABLE IF NOT EXISTS java302.notes(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	shopping_list_item_id INT UNSIGNED NOT NULL,
	body VARCHAR(100) NOT NULL,
	created_date VARCHAR(45) NOT NULL,
	modified_date VARCHAR(45) NULL,
	PRIMARY KEY (id));
	
CREATE TABLE IF NOT EXISTS java302.users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  email VARCHAR(128) NULL,
  phone_number VARCHAR(10) NULL,
  active tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (id));
  
  CREATE TABLE IF NOT EXISTS java302.user_roles (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL,
  role VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));