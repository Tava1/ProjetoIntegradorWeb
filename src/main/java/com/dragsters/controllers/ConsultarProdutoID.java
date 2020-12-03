package com.dragsters.controllers;

import com.dragsters.dao.ProdutoDAO;
import com.dragsters.model.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Gustavo Santos
 */

@WebServlet(name = "ConsultarProdutoID", urlPatterns = "/ConsultarProdutoID")
public class ConsultarProdutoID extends HttpServlet {

    private Gson gson = new Gson();
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int produtoID = Integer.parseInt(request.getParameter("productID"));
        
        Produto produto = produtoDAO.buscarProduto(produtoID);
        
        String jsonString = this.gson.toJson(produto);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        response.getWriter().write(jsonString);
    }
}
