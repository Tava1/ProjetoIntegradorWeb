package com.dragsters.controllers;

import com.dragsters.dao.CategoriaDAO;
import com.dragsters.model.Categoria;
import java.io.IOException;
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
public class DetalheCategoria extends HttpServlet {
    
    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int categoriaID = Integer.parseInt(request.getParameter("categoriaID"));
        
        Categoria categoria = categoriaDAO.listarCategoriaID(categoriaID);
        
        request.setAttribute("categoria", categoria);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/admin/categories/update-category.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Categoria categoria = new Categoria();
       
        try {
            categoria.setCategoriaID(Integer.parseInt(request.getParameter("categoriaID")));
            categoria.setTitulo(request.getParameter("titulo"));
        
            categoriaDAO.atualizar(categoria);
        } 
        catch (Exception ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
