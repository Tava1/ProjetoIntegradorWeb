package com.dragsters.controllers;

import com.dragsters.dao.ClienteDAO;
import com.dragsters.dao.PedidoDAO;
import com.dragsters.dao.ProdutoDAO;
import com.dragsters.model.Cliente;
import com.dragsters.model.ItemPedido;
import com.dragsters.model.Pedido;
import com.dragsters.model.Produto;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Gustavo Santos
 */
public class VendaController extends HttpServlet {

    private ClienteDAO clienteDAO = new ClienteDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/pages/orders/order.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        StringBuilder sb = new StringBuilder();
        String line = null;
        ArrayList<ItemPedido> listaItensPedido = new ArrayList<>();
        Gson gson = new Gson();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            // Obter o JSON com a relação de produtos x quantidades para finalizar a venda.
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            
            JSONObject json = new JSONObject(sb.toString());
            JSONArray arr = json.getJSONArray("produtos");
            
            for (int i = 0; i < arr.length(); i++) {
                ItemPedido itemPedido = new ItemPedido();
                String produtoID = arr.getJSONObject(i).getString("produtoID");
                String quantidade = arr.getJSONObject(i).getString("quantidade");
                if (produtoID.isEmpty() || quantidade.isEmpty()) {
                    response.getWriter().write(gson.toJson("É Necessário determinar a quantidade para todos os produtos na lista."));
                    return;
                }
                itemPedido.setProdutoID(Integer.parseInt(produtoID));
                itemPedido.setQuantidade(Integer.parseInt(quantidade));
                listaItensPedido.add(itemPedido);
            }
        } 
        catch (Exception e) {
            response.getWriter().write(gson.toJson(e.getMessage()));
        }
        
        
        double totalVenda = 0.0;
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        for (ItemPedido item : listaItensPedido) {
            item.getQuantidade();
            Produto p = produtoDAO.buscarProduto(item.getProdutoID());
            totalVenda += p.getPrecoUnitario() * item.getQuantidade();
        }
        
        // Cliente
        String CPF = request.getParameter("clienteCPF");
        if(CPF.isEmpty()) {
            response.getWriter().write(gson.toJson("É necessário preencher o campo CPF do cliente."));
            return;
        }
        Cliente cliente = clienteDAO.listarClientesCPF(CPF);
        
        Pedido pedido = new Pedido();
        
        pedido.setTotal(totalVenda);
        pedido.setClienteID(cliente.getClienteID());
        pedido.setFuncionarioID(1);
        pedido.setUnidadeID(1);

        try {
            if(PedidoDAO.criar(pedido, listaItensPedido)) {
                response.getWriter().write(gson.toJson("Venda efetuada com sucesso."));
            }
        } 
        catch (Exception e) {
        }
    }

}
