package com.dragsters.controllers;

import com.dragsters.dao.CategoriaDAO;
import com.dragsters.model.Categoria;
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
public class CategoriaProdutoController extends HttpServlet {
    
    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Categoria> listaCategorias = categoriaDAO.listar();
        
        request.setAttribute("listaCategorias", listaCategorias);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/categories/list-category.jsp");
        requestDispatcher.forward(request, response);
    }

}
