DROP DATABASE IF EXISTS padaria_poo;
CREATE DATABASE padaria_poo;
USE padaria_poo;

CREATE TABLE endereco (
                          id_endereco INT AUTO_INCREMENT PRIMARY KEY,
                          rua VARCHAR(100) NOT NULL,
                          numero VARCHAR(20) NOT NULL,
                          cidade VARCHAR(100) NOT NULL,
                          estado VARCHAR(50) NOT NULL
);

CREATE TABLE cliente (
                         id_cliente INT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         cpf VARCHAR(20) NOT NULL UNIQUE,
                         telefone VARCHAR(30),
                         data_cadastro VARCHAR(20),
                         id_endereco INT,
                         FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco)
);

CREATE TABLE funcionario (
                             id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
                             nome VARCHAR(100) NOT NULL,
                             cpf VARCHAR(20) NOT NULL UNIQUE,
                             telefone VARCHAR(30),
                             cargo VARCHAR(100),
                             salario DECIMAL(10,2),
                             data_contratacao VARCHAR(20)
);

CREATE TABLE fornecedor (
                            id_fornecedor INT AUTO_INCREMENT PRIMARY KEY,
                            nome_empresa VARCHAR(100) NOT NULL,
                            cnpj VARCHAR(30) NOT NULL UNIQUE,
                            tipo_produto VARCHAR(100),
                            telefone VARCHAR(30)
);

CREATE TABLE produto (
                         id_produto INT AUTO_INCREMENT PRIMARY KEY,
                         codigo VARCHAR(30) NOT NULL UNIQUE,
                         nome VARCHAR(100) NOT NULL,
                         preco DECIMAL(10,2) NOT NULL,
                         quantidade_estoque INT NOT NULL,
                         categoria VARCHAR(100)
);

CREATE TABLE venda (
                       id_venda INT AUTO_INCREMENT PRIMARY KEY,
                       data_venda VARCHAR(20),
                       id_cliente INT,
                       id_funcionario INT NOT NULL,
                       tipo_pagamento VARCHAR(50),
                       valor_total DECIMAL(10,2),
                       FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
                       FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario)
);

CREATE TABLE item_venda (
                            id_item_venda INT AUTO_INCREMENT PRIMARY KEY,
                            id_venda INT NOT NULL,
                            id_produto INT NOT NULL,
                            quantidade INT NOT NULL,
                            subtotal DECIMAL(10,2) NOT NULL,
                            FOREIGN KEY (id_venda) REFERENCES venda(id_venda),
                            FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);

INSERT INTO endereco (rua, numero, cidade, estado) VALUES ('Rua A', '123', 'Barbacena', 'MG');
INSERT INTO cliente (nome, cpf, telefone, data_cadastro, id_endereco) VALUES ('João', '12345678900', '32999999999', '26/03/2026', 1);
INSERT INTO funcionario (nome, cpf, telefone, cargo, salario, data_contratacao) VALUES ('Maria', '98765432100', '32988888888', 'Caixa', 1800.00, '01/03/2026');
INSERT INTO fornecedor (nome_empresa, cnpj, tipo_produto, telefone) VALUES ('Farinhas Finas', '12345678000199', 'Farinha e derivados', '3233334444');

DROP USER IF EXISTS 'padaria_app'@'localhost';
CREATE USER 'padaria_app'@'localhost' IDENTIFIED BY 'padaria_pass123';
GRANT ALL PRIVILEGES ON padaria_poo.* TO 'padaria_app'@'localhost';
FLUSH PRIVILEGES;