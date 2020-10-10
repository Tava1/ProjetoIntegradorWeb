package com.dragsters.controllers;

import com.dragsters.dao.CargoDAO;
import com.dragsters.model.Cargo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cargo> listaCargos = CargoDAO.listar();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        
        Cargo cargo = new Cargo(titulo);
        
        try {
            CargoDAO.criar(cargo);
        } catch (SQLException ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
