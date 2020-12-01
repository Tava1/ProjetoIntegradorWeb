package com.dragsters.controllers;

import com.dragsters.dao.CategoriaDAO;
import com.dragsters.model.Categoria;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Santos
 */
public class BuscarCategorias extends HttpServlet {
    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    private Gson gson = new Gson();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ArrayList<Categoria> categorias = categoriaDAO.listar();
        
        String jsonString = this.gson.toJson(categorias);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonString);
    }

}
