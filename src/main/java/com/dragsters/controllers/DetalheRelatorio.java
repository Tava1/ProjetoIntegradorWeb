package com.dragsters.controllers;

import com.dragsters.dao.RelatorioDAO;
import com.dragsters.model.PedidoDetalheRelatorio;
import com.dragsters.model.Produto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Santos
 */
public class DetalheRelatorio extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int pedidoID = Integer.parseInt(request.getParameter("pedidoID"));
        
        ArrayList<PedidoDetalheRelatorio> detalhePedido = RelatorioDAO.listarDetalheVenda(pedidoID);
        
        request.setAttribute("detalhePedido", detalhePedido);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/gerente/reports/report-details.jsp");
        requestDispatcher.forward(request, response);
    }
}
