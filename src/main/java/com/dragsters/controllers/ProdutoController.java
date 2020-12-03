package com.dragsters.controllers;

import com.dragsters.dao.ProdutoDAO;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dragsters.model.Produto;
import java.util.ArrayList;
/**
 *
 * @author Gustavo Santos
 */
public class ProdutoController extends HttpServlet {

    private ProdutoDAO produtoDAO = new ProdutoDAO();
    
    // Lista todos os produtos cadastrados
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Produto> listaProdutos = produtoDAO.listar();
        
        request.setAttribute("listaProdutos", listaProdutos);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/pages/products/list-product.jsp");
        requestDispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        int produtoID = Integer.parseInt(request.getParameter("produtoID"));
        
        try {
            if(produtoDAO.deletar(produtoID))
            {
                ArrayList<Produto> listaProdutos = produtoDAO.listar();
                request.setAttribute("listaProdutos", listaProdutos);
                response.setContentType("text/html;charset=UTF-8");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/pages/products/list-product.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                request.setAttribute("erro", "Ocorreu algum erro ao tentar deletar.");
                response.setContentType("text/html;charset=UTF-8");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                requestDispatcher.forward(request, response);
            }
        } 
        catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(request, response);
        }
    }

}
