package com.dragsters.controllers;

import com.dragsters.dao.CargoDAO;
import com.dragsters.model.Cargo;
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


public class CriarCargo extends HttpServlet {
    private CargoDAO cargoDAO = new CargoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/roles/create-role.jsp");
        requestDispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String titulo = request.getParameter("titulo");
        Cargo cargo = new Cargo(titulo);
        
        try {
            cargoDAO.criar(cargo);
        } 
        catch (Exception ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
