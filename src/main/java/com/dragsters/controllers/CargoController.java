package com.dragsters.controllers;

import com.dragsters.dao.CargoDAO;
import com.dragsters.model.Cargo;
import java.io.IOException;
import java.util.ArrayList;
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
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        int cargoID = Integer.parseInt(request.getParameter("cargoID"));
        
        try {
            if(cargoDAO.deletar(cargoID))
            {
                ArrayList<Cargo> listaCargos = cargoDAO.listar();
                request.setAttribute("listaCargos", listaCargos);
                response.setContentType("text/html;charset=UTF-8");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/roles/list-role.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                throw new Exception("Ocorreu algum erro ao tentar deletar.");
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
