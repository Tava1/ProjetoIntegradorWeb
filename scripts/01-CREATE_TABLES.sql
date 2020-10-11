##CREATE DATABASE dragsters;
##USE dragsters;
##DROP DATABASE dragsters;

CREATE TABLE Cliente (
ClienteID INT PRIMARY KEY AUTO_INCREMENT,
Nome VARCHAR(60) NOT NULL,
CPF CHAR(11) NOT NULL,
Genero CHAR(1) NOT NULL,
EstadoCivil CHAR(1) NOT NULL,
Email VARCHAR(60) NOT NULL,
DataNascimento DATE NOT NULL,
NumeroContato VARCHAR(11) NOT NULL,
Endereco VARCHAR(60) NOT NULL,
EnderecoNumero VARCHAR(8) NOT NULL,
Complemento VARCHAR(20),
Cidade VARCHAR(40) NOT NULL,
Estado CHAR(2) NOT NULL
);

CREATE TABLE Cargo (
CargoID INT PRIMARY KEY AUTO_INCREMENT,
Titulo VARCHAR(20) NOT NULL
);

CREATE TABLE Funcionario (
FuncionarioID INT PRIMARY KEY AUTO_INCREMENT,
Nome VARCHAR(60) NOT NULL,
CPF CHAR(11) NOT NULL,
Genero CHAR(1) NOT NULL,
Email VARCHAR(60) NOT NULL,
DataNascimento DATE NOT NULL,
Senha VARCHAR(60),
Ativo BINARY NOT NULL,
CargoID INT NOT NULL,
FOREIGN KEY (CargoID) REFERENCES Cargo (CargoID)
);

CREATE TABLE Estoque (
EstoqueID INT PRIMARY KEY AUTO_INCREMENT,
Quantidade LONG NOT NULL
);

CREATE TABLE Categoria (
CategoriaID INT PRIMARY KEY AUTO_INCREMENT,
Titulo VARCHAR(20) NOT NULL
);

CREATE TABLE Filial (
FilialID INT PRIMARY KEY AUTO_INCREMENT,
Endereco VARCHAR(60) NOT NULL,
EnderecoNumero VARCHAR(8) NOT NULL,
Cidade VARCHAR(40) NOT NULL,
Estado CHAR(2) NOT NULL
);

CREATE TABLE Produto (
ProdutoID INT PRIMARY KEY AUTO_INCREMENT,
Marca VARCHAR(40),
Modelo VARCHAR(40) NOT NULL,
Descricao VARCHAR(500),
PrecoUnitario DECIMAL(10,2) NOT NULL,
Ativo BINARY NOT NULL,
CategoriaID INT NOT NULL,
EstoqueID INT NOT NULL,
FilialID INT NOT NULL,
FOREIGN KEY (CategoriaID) REFERENCES Categoria (CategoriaID),
FOREIGN KEY (EstoqueID) REFERENCES Estoque (EstoqueID),
FOREIGN KEY (FilialID) REFERENCES Filial (FilialID)
);

##Venda
CREATE TABLE Pedido (
PedidoID INT PRIMARY KEY AUTO_INCREMENT,
Total DECIMAL(10, 2) NOT NULL,
DataPedido DATETIME NOT NULL,
ClienteID INT NOT NULL, 
FuncionarioID INT NOT NULL,
FOREIGN KEY (ClienteID) REFERENCES Cliente (ClienteID),
FOREIGN KEY (FuncionarioID) REFERENCES Funcionario (FuncionarioID)
);

CREATE TABLE ItemPedido (
ItemPedidoID INT PRIMARY KEY AUTO_INCREMENT,
Quantidade LONG NOT NULL,
PedidoID INT NOT NULL,
ProdutoID INT NOT NULL,
FOREIGN KEY (PedidoID) REFERENCES Pedido (PedidoID),
FOREIGN KEY (ProdutoID) REFERENCES Produto (ProdutoID)
);