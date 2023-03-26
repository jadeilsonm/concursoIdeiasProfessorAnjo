IF CIPA NOT EXISTS CREATE DATABASE CIPA;

USE CIPA;

CREATE TABLE users(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(150) UNIQUE,
    name VARCHAR(100),
    password VARCHAR(350),
    role varchar(10) DEFAULT "DEFAULT",
    cpf VARCHAR(11),
    image BLOB DEFAULT NULL
);