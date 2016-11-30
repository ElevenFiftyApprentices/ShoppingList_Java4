CREATE SCHEMA IF NOT EXISTS shoppingList_Java4;
USE shoppingList_Java4;

CREATE TABLE IF NOT EXISTS shoppingList_Java4.shoppingList (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  shoppingList_id VARCHAR(16) NOT NULL,
  shoppingList_name VARCHAR(36) NOT NULL,
  shoppingList_color VARCHAR(36) NOT NULL,
  shoppingList_createdUtc VARCHAR(36) NOT NULL,
  shoppingList_modifiedUtc VARCHAR(36) NOT NULL,
  PRIMARY KEY (id));
 
