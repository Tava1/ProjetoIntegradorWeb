package com.dragsters.controllers;

import com.dragsters.dao.CargoDAO;
import com.dragsters.model.Cargo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Santos
 */
@WebServlet(name = "CargoController", urlPatterns = "/CargoController")
public class CargoController extends HttpServlet {
  
    private CargoDAO cargoDAO = new CargoDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Cargo> listaCargos = cargoDAO.listar();
        
        request.setAttribute("listaCargos", listaCargos);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/roles/list-role.jsp");
        requestDispatcher.forward(request, response);
    }
}
