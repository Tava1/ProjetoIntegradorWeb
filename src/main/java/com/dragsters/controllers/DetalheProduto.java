package com.dragsters.controllers;

import com.dragsters.dao.ProdutoDAO;
import com.dragsters.model.Produto;
import com.google.gson.Gson;
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
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/pages/products/update-product.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
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

            if(produtoDAO.atualizar(produto)) {
                response.getWriter().write(gson.toJson("Atualização efetuada com sucesso."));
            }
            else {
                response.getWriter().write(gson.toJson("Ocorreu algum erro."));
            }
        } 
        catch (Exception ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
