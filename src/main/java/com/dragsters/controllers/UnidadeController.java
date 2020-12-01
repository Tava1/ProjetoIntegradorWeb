package com.dragsters.controllers;

import com.dragsters.dao.UnidadeDAO;
import com.dragsters.model.Unidade;
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
public class UnidadeController extends HttpServlet {

    private UnidadeDAO unidadeDAO = new UnidadeDAO();
            
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Unidade> listaUnidades = unidadeDAO.listar();
        
        request.setAttribute("listaUnidades", listaUnidades);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/branches/list-branch.jsp");
        requestDispatcher.forward(request, response);
    }

}
