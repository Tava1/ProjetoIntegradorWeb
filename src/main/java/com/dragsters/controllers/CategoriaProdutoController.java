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
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/admin/categories/list-category.jsp");
        requestDispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        int categoriaID = Integer.parseInt(request.getParameter("categoriaID"));
        
        try {
            if(categoriaDAO.deletar(categoriaID))
            {
                ArrayList<Categoria> listaCategoria = categoriaDAO.listar();
                request.setAttribute("listaCategoria", listaCategoria);
                response.setContentType("text/html;charset=UTF-8");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/admin/categories/list-category.jsp");
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
