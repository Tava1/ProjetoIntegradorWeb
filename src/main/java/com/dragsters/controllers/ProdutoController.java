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

    private ProdutoDAO produtoDAO = new ProdutoDAO();
    
    // Lista todos os produtos cadastrados
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Produto> listaProdutos = produtoDAO.listar();
        
        request.setAttribute("listaProdutos", listaProdutos);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/products/list-product.jsp");
        requestDispatcher.forward(request, response);
    }

    // Cria um novo produto
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
        produto.setUnidadeID(Integer.parseInt(request.getParameter("unidadeID")));
        
        try {
            produtoDAO.criar(produto);
        } 
        catch (Exception e) {
        }
    }
    
    // Atualiza um produto especifico
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Produto produto = new Produto();
        
        produto.setProdutoID(Integer.parseInt(request.getParameter("produtoID")));
        produto.setMarca(request.getParameter("marca"));
        produto.setModelo(request.getParameter("modelo"));
        produto.setDescricao(request.getParameter("descricao"));
        produto.setPrecoUnitario(Double.parseDouble(request.getParameter("precoUnitario")));
        produto.setAtivo(Integer.parseInt(request.getParameter("ativo")));
        produto.setCategoriaID(Integer.parseInt(request.getParameter("categoriaID")));
        produto.setUnidadeID(Integer.parseInt(request.getParameter("unidadeID")));
        
        try {
            produtoDAO.atualizar(produto);
        } 
        catch (Exception e) {
        }
    }

}
