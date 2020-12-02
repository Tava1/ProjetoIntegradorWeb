package com.dragsters.controllers;

import com.dragsters.dao.ProdutoDAO;
import com.dragsters.model.Produto;
import java.io.IOException;
import java.sql.Date;
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
public class DetalheProduto extends HttpServlet {

private ProdutoDAO produtoDAO = new ProdutoDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int produtoID = Integer.parseInt(request.getParameter("produtoID"));
        
        Produto produto = produtoDAO.listarProdutoID(produtoID);
        
        request.setAttribute("produto", produto);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/products/update-product.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Produto produto = new Produto();
       
        try {
            produto.setProdutoID(Integer.parseInt(request.getParameter("produtoID")));
            produto.setMarca(request.getParameter("marca"));
            produto.setModelo(request.getParameter("modelo"));
            produto.setDescricao(request.getParameter("descricao"));
            produto.setPrecoUnitario(Double.parseDouble(request.getParameter("precoUnitario")));
            //produto.setAtivo(Integer.parseInt(request.getParameter("ativo")));
            produto.setAtivo(1);
            produto.setCategoriaID(Integer.parseInt(request.getParameter("categoriaID")));
            produto.setUnidadeID(Integer.parseInt(request.getParameter("unidadeID")));

            produtoDAO.atualizar(produto);
        } 
        catch (Exception ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
