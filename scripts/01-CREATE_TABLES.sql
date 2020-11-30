DROP DATABASE IF EXISTS dragsters;
CREATE DATABASE IF NOT EXISTS dragsters;
USE dragsters;

CREATE TABLE Unidade (
UnidadeID INT PRIMARY KEY AUTO_INCREMENT,
Endereco VARCHAR(60) NOT NULL,
EnderecoNumero VARCHAR(8) NOT NULL,
Cidade VARCHAR(40) NOT NULL,
Estado CHAR(2) NOT NULL,
Titulo VARCHAR(20) NOT NULL
);

CREATE TABLE Cliente (
ClienteID INT PRIMARY KEY AUTO_INCREMENT,
Nome VARCHAR(60) NOT NULL,
CPF CHAR(11) UNIQUE NOT NULL,
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
CPF CHAR(11) UNIQUE NOT NULL,
Genero CHAR(1) NOT NULL,
Email VARCHAR(60) NOT NULL,
DataNascimento DATE NOT NULL,
Senha VARCHAR(60),
Ativo BINARY NOT NULL,
CargoID INT NOT NULL,
UnidadeID INT NOT NULL,
FOREIGN KEY (CargoID) REFERENCES Cargo (CargoID),
FOREIGN KEY (UnidadeID) REFERENCES Unidade (UnidadeID)
);

CREATE TABLE Categoria (
CategoriaID INT PRIMARY KEY AUTO_INCREMENT,
Titulo VARCHAR(20) NOT NULL
);

CREATE TABLE Produto (
ProdutoID INT PRIMARY KEY AUTO_INCREMENT,
Marca VARCHAR(40),
Modelo VARCHAR(40) NOT NULL,
Descricao VARCHAR(500),
PrecoUnitario DECIMAL(10,2) NOT NULL,
Ativo BINARY NOT NULL,
CategoriaID INT NOT NULL,
UnidadeID INT NOT NULL,
FOREIGN KEY (CategoriaID) REFERENCES Categoria (CategoriaID),
FOREIGN KEY (UnidadeID) REFERENCES Unidade (UnidadeID)
);

CREATE TABLE Estoque (
EstoqueID INT PRIMARY KEY AUTO_INCREMENT,
Quantidade LONG NOT NULL,
ProdutoID INT NOT NULL,
FOREIGN KEY (ProdutoID) REFERENCES Produto (ProdutoID)
);

##Venda
CREATE TABLE Pedido (
PedidoID INT PRIMARY KEY AUTO_INCREMENT,
Total DECIMAL(10, 2) NOT NULL,
DataPedido DATETIME NOT NULL,
VendaConcluida INT NOT NULL,
ClienteID INT NOT NULL, 
FuncionarioID INT NOT NULL,
UnidadeID INT NOT NULL,
FOREIGN KEY (ClienteID) REFERENCES Cliente (ClienteID),
FOREIGN KEY (FuncionarioID) REFERENCES Funcionario (FuncionarioID),
FOREIGN KEY (UnidadeID) REFERENCES Unidade (UnidadeID)
);

CREATE TABLE ItemPedido (
ItemPedidoID INT PRIMARY KEY AUTO_INCREMENT,
Quantidade LONG NOT NULL,
PedidoID INT NOT NULL,
ProdutoID INT NOT NULL,
FOREIGN KEY (PedidoID) REFERENCES Pedido (PedidoID),
FOREIGN KEY (ProdutoID) REFERENCES Produto (ProdutoID)
);

INSERT INTO Cargo(Titulo) VALUES
('Admin'),
('Supervisor'),
('Diretoria'),
('Produtos Global'),
('Marketing Global'),
('Vendas Global'),
('TI Global');


INSERT INTO Categoria(Titulo) VALUES
('Suspensões'),
('Rodas'),
('Pneus'),
('Freios'),
('Lubrificantes');

INSERT INTO Unidade(Endereco, EnderecoNumero, Cidade, Estado, Titulo) VALUES
('Av. Nove de Julho','423','São Paulo', 'SP', 'Matriz'),
('Av. Governador Raul Barbosa','4567','Campina Grande', 'PA', 'Filial'),
('R. Max Lepper','128','Joinville', 'SC', 'Filial'),
('Via W3 Sul','469','Brasília', 'DF', 'Filial'),
('Av. Pres. Tancredo Neves','2001','Belo Horizonte', 'MG', 'Filial'),
('Av. Recife','378','Recife', 'PE', 'Filial');

INSERT INTO Produto(Marca, Modelo, Descricao, PrecoUnitario, Ativo, CategoriaID, UnidadeID) VALUES 
('Bridgestone', '195/55R15 85H EP150 ECOPIA BRIDGESTONE', 'Os pneus Bridgestone EP150 foram desenvolvidos para veículos de tamanho intermediário e são modelos fabricados com composto que provê baixa resistência ao rolamento, traduzindo em muito mais economia, pois além de auxiliar na redução do consumo de combustível, também tem maior durabilidade e vida útil.', 329.00, 1, 3, 1),
('MOMO', 'RODA REVENGE MOMO ARO 19X8,5 5X120 ET 35', 'Preta Fosca', 1099.00, 1, 2, 1),
('MOMO', 'RODA STEALTH MOMO ARO 20X8,5 5X112 ET 45', 'GRAFITE FOSCA DIAMANTADA', 1199.00, 1, 2, 1);


INSERT INTO Funcionario(Nome, CPF, Genero, Email, DataNascimento, Senha, Ativo, CargoID, UnidadeID) VALUES
('Gustavo Santos', '12345678911', 'M', 'gustavo@dragsters.com', '1999-10-26', '1234', 1, '1', '1'),
('Victor Pedrasani', '15948963245', 'M', 'victhor@dragsters.com', '1998-01-02', '6789', 0, '3', '2');