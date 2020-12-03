SELECT Pedido.PedidoID, Produto.Modelo, ItemPedido.Quantidade, Produto.PrecoUnitario, Pedido.Total, Cliente.Nome as NomeCliente, Cliente.CPF as CPFCliente, Funcionario.Nome as FuncionarioNome, Unidade.Endereco, Unidade.EnderecoNumero, Pedido.DataPedido
FROM ItemPedido
INNER JOIN Pedido
ON ItemPedido.PedidoID = Pedido.PedidoID
INNER JOIN Cliente
ON Pedido.ClienteID = Cliente.ClienteID
INNER JOIN Produto
ON Produto.ProdutoID = ItemPedido.ProdutoID
INNER JOIN Funcionario
ON Pedido.FuncionarioID = Funcionario.FuncionarioID
INNER JOIN Unidade
ON Unidade.UnidadeID = Funcionario.UnidadeID
WHERE Pedido.PedidoID = ?
