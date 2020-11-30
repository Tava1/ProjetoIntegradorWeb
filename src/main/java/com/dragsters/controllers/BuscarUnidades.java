package com.dragsters.controllers;

import com.dragsters.dao.UnidadeDAO;
import com.dragsters.model.Unidade;
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
public class BuscarUnidades extends HttpServlet {

    private UnidadeDAO unidadeDAO = new UnidadeDAO();
    private Gson gson = new Gson();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ArrayList<Unidade> unidades = unidadeDAO.listar();
        
        String jsonString = this.gson.toJson(unidades);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonString);
    }

}
