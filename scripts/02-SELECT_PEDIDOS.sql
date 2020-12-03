SELECT Pedido.PedidoID, Pedido.Total, Pedido.DataPedido, Cliente.Nome, Cliente.CPF, Funcionario.Nome, Unidade.Endereco, Unidade.EnderecoNumero
FROM Pedido
INNER JOIN Cliente
ON Pedido.ClienteID = Cliente.ClienteID
INNER JOIN Funcionario
ON Pedido.FuncionarioID = Funcionario.FuncionarioID
INNER JOIN Unidade
ON Pedido.UnidadeID = Unidade.UnidadeID