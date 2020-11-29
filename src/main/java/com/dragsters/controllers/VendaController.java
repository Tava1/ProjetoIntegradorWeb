package com.dragsters.controllers;

import com.dragsters.dao.ClienteDAO;
import com.dragsters.dao.PedidoDAO;
import com.dragsters.model.Cliente;
import com.dragsters.model.ItemPedido;
import com.dragsters.model.Pedido;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/order.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Cliente
        String CPF = request.getParameter("cpf");
        Cliente cliente = clienteDAO.listarClientesCPF(CPF);
        
        
        ArrayList<ItemPedido> listaItensPedido = new ArrayList<>();
        
        Pedido pedido = new Pedido();
        
        pedido.setClienteID(cliente.getClienteID());
        
//        for (:) {
//            
//            ItemPedido itemPedido = new ItemPedido();
//
//            itemPedido.setProdutoID(Integer.parseInt(request.getParameter("produtoID")));
//            itemPedido.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
//            
//            listaItensPedido.add(itemPedido);
//        }

        try {
            PedidoDAO.criar(pedido, listaItensPedido);
        } 
        catch (Exception e) {
        }
    }

}
