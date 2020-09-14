CREATE DATABASE ladobmenu;
USE ladobmenu;

CREATE TABLE cliente
(
Id bigint auto_increment,
Nome varchar(30) NOT NULL,
Email varchar(30) NOT NULL, 
Telefone varchar(15) NOT NULL,
PRIMARY KEY (Id),
UNIQUE (Telefone, Email)
);

CREATE TABLE produto
(
Id bigint auto_increment,
Produto varchar(30) NOT NULL,
Preco double NOT NULL, 
PRIMARY KEY (Id),
UNIQUE (Produto)
);

CREATE TABLE mesa
(
Id int auto_increment,
Codigo varchar(8) NOT NULL,
Cadeiras int,
PRIMARY KEY (Id),
UNIQUE (Codigo)
);

CREATE TABLE pedido
(
Id bigint auto_increment,
Id_cliente bigint,
Id_mesa int,
DataPedido date,
HoraPedido time,
Valor double,
PRIMARY KEY (Id),
FOREIGN KEY (Id_cliente) REFERENCES cliente(Id),
FOREIGN KEY (Id_mesa) REFERENCES mesa(Id)
);

CREATE TABLE produto_pedido
(
Id bigint auto_increment,
Id_produto bigint,
Id_pedido bigint,
Quantidade int,
PRIMARY KEY (Id),
FOREIGN KEY (Id_produto) REFERENCES produto(Id),
FOREIGN KEY (Id_pedido) REFERENCES pedido(Id)
);
