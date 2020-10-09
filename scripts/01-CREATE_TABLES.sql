##CREATE DATABASE dragsters;
##USE dragsters;
##drop database dragsters; 

create table Cliente (
ClienteID INT primary key auto_increment,
Nome VARCHAR(60) not null,
CPF char(11) not null,
Genero char(1) not null,
EstadoCivil char(1) not null,
Email varchar(60) not null,
DataNascimento date not null,
NumeroContato numeric not null,
Endereco varchar(60) not null,
EnderecoNumero varchar(8) not null,
Complemento varbinary(20),
Cidade varchar(40) not null,
Estado char(2) not null
);

create table Cargo (
CargoID INT primary key auto_increment,
Titulo varchar(20) not null
);

create table Funcionario (
FuncionarioID INT primary key auto_increment,
Nome VARCHAR(60) not null,
CPF char(11) not null,
Genero char(1) not null,
Email varchar(60) not null,
DataNascimento date not null,
Senha varchar(60),
Ativo binary,
CargoID int not null,
foreign key (CargoID) references Cargo (CargoID)
);

create table Estoque (
EstoqueID int primary key auto_increment,
Quantidade long not null
);

create table Categoria (
CategoriaID INT primary key auto_increment,
Titulo varchar(20) not null
);

CREATE TABLE Filial (
FilialID INT primary key auto_increment,
Endereco varchar(60) not null,
EnderecoNumero varchar(8) not null,
Cidade varchar(40) not null,
Estado char(2) not null
);

create table Produto (
ProdutoID INT primary key auto_increment,
Marca varchar(40),
Modelo varchar(40),
Descricao varchar(500),
PrecoUnitario decimal(10,2) not null,
Ativo binary,
CategoriaID int not null,
EstoqueID int not null,
FilialID int not null,
foreign key (CategoriaID) references Categoria (CategoriaID),
foreign key (EstoqueID) references Estoque (EstoqueID),
foreign key (FilialID) references Filial (FilialID)
);

##Venda
create table Pedido (
PedidoID INT primary key auto_increment,
Total DECIMAL(10, 2),
DataPedido DATETIME,
ClienteID INT not null, 
FuncionarioID INT,
foreign key (ClienteID) references Cliente (ClienteID),
foreign key (FuncionarioID) references Funcionario (FuncionarioID)
);

create table ItemPedido (
ItemPedidoID int primary key auto_increment,
Quantidade long not null,
PedidoID int not null,
ProdutoID int not null,
foreign key (PedidoID) references Pedido (PedidoID),
foreign key (ProdutoID) references Produto (ProdutoID)
);