package com.dragsters.controllers;

import com.dragsters.dao.ClienteDAO;
import com.dragsters.dao.PedidoDAO;
import com.dragsters.model.Cliente;
import com.dragsters.model.ItemPedido;
import com.dragsters.model.Pedido;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        ItemPedido itemPedido = new ItemPedido();
        ArrayList<ItemPedido> listaItensPedido = new ArrayList<>();
        
        try {
            // Obter o JSON com a relação de produtos x quantidades para finalizar a venda.
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            
            JSONObject json = new JSONObject(sb.toString());
            JSONArray arr = json.getJSONArray("produtos");
            
            for (int i = 0; i < arr.length(); i++) {
                String produtoID = arr.getJSONObject(i).getString("produtoID");
                String quantidade = arr.getJSONObject(i).getString("quantidade");
                
                itemPedido.setProdutoID(Integer.parseInt(produtoID));
                itemPedido.setQuantidade(Integer.parseInt(quantidade));
                listaItensPedido.add(itemPedido);
            }
            
        } 
        catch (Exception e) {
            return;
        }
        
        HttpSession sessao = request.getSession();
        
        
        // Cliente
        String CPF = request.getParameter("clienteCPF");
        Cliente cliente = clienteDAO.listarClientesCPF(CPF);
        
        Pedido pedido = new Pedido();
        
        pedido.setClienteID(cliente.getClienteID());
        pedido.setFuncionarioID(1);
        pedido.setUnidadeID(1);

        try {
            PedidoDAO.criar(pedido, listaItensPedido);
        } 
        catch (Exception e) {
        }
    }

}
