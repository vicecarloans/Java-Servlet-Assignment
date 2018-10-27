DELETE DATABASE IF EXISTS COMP3095;

CREATE DATABASE IF NOT EXISTS COMP3095;
USE COMP3095;
grant all on COMP3095.* to 'admin@domain.ca'@'localhost' identified by 'P@ssword1'; 
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS ROLES;
DROP TABLE IF EXISTS USERROLES;
CREATE TABLE USERS 
( 
	id varchar(255) PRIMARY KEY, 
	firstname varchar(255),
	lastname varchar(255),
	email varchar(255), 
	address varchar(500),
	created timestamp default current_timestamp,
	password varchar(20),
	activate boolean default false
);

CREATE TABLE ROLES
(
	id int(11) AUTO_INCREMENT PRIMARY KEY,
	roleName varchar(255)
);

CREATE TABLE USERROLES
(
	id int(11) AUTO_INCREMENT PRIMARY KEY,
	userID varchar(255),
	roleID int(11)
);
TRUNCATE TABLE USERS;
TRUNCATE TABLE ROLES;
TRUNCATE TABLE USERROLES;
INSERT INTO `USERS` (`id`,`firstname`, `lastname`, `email`, `password`, `address`, `activate`) VALUES
('1','Admin', 'IT', 'admin@isp.net', 'P@ssword1', '160 Kendal Avenue', true);

INSERT INTO `ROLES` (`roleName`) VALUES
('admin');
INSERT INTO `ROLES` (`roleName`) VALUES
('client');
INSERT INTO `USERROLES` (`userID`, `roleID`) VALUES
(1,1);