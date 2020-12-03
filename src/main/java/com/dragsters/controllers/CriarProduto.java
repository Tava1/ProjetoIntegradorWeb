package com.dragsters.controllers;

import com.dragsters.dao.ProdutoDAO;
import com.dragsters.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Santos
 */
public class CriarProduto extends HttpServlet {

    private ProdutoDAO produtoDAO = new ProdutoDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/pages/products/create-product.jsp");
        requestDispatcher.forward(request, response);
    }

        // Cria um novo produto
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Produto produto = new Produto();
        
        try {
            produto.setMarca(request.getParameter("marca"));
            produto.setModelo(request.getParameter("modelo"));
            produto.setDescricao(request.getParameter("descricao"));
            produto.setPrecoUnitario(Double.parseDouble(request.getParameter("precoUnitario")));
            //produto.setAtivo(Integer.parseInt(request.getParameter("ativo")));
            produto.setAtivo(1);
            produto.setCategoriaID(Integer.parseInt(request.getParameter("categoriaID")));
            produto.setUnidadeID(Integer.parseInt(request.getParameter("unidadeID")));
        
            produtoDAO.criar(produto);
        } 
        catch (Exception e) {
        }
    }


}
