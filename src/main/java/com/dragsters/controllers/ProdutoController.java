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
/**
 *
 * @author Gustavo Santos
 */
public class ProdutoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Produto> listaProdutos = ProdutoDAO.listar();
        
        request.setAttribute("listaProduto", listaProdutos);
        
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/products.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Produto produto = new Produto();
        
        produto.setMarca(request.getParameter("marca"));
        produto.setModelo(request.getParameter("modelo"));
        produto.setDescricao(request.getParameter("descricao"));
        produto.setPrecoUnitario(Double.parseDouble(request.getParameter("precoUnitario")));
        produto.setAtivo(Integer.parseInt(request.getParameter("ativo")));
        produto.setCategoriaID(Integer.parseInt(request.getParameter("categoriaID")));
        produto.setEstoqueID(Integer.parseInt(request.getParameter("estoqueID")));
        produto.setFilialID(Integer.parseInt(request.getParameter("filialID")));
        
        try {
            ProdutoDAO.criar(produto);
        } 
        catch (Exception e) {
        }
    }

}
