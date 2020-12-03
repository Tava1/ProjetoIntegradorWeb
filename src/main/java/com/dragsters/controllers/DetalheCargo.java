package com.dragsters.controllers;

import com.dragsters.dao.CargoDAO;
import com.dragsters.model.Cargo;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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
public class DetalheCargo extends HttpServlet {

    private CargoDAO cargoDAO = new CargoDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int cargoID = Integer.parseInt(request.getParameter("cargoID"));
        
        Cargo cargo = cargoDAO.listarCargoID(cargoID);
        
        request.setAttribute("cargo", cargo);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/admin/roles/update-role.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Cargo cargo = new Cargo();
       
        try {
            cargo.setCargoID(Integer.parseInt(request.getParameter("cargoID")));
            cargo.setTitulo(request.getParameter("titulo"));
        
            ;
            
            if(cargoDAO.atualizar(cargo)) {
                response.getWriter().write(gson.toJson("Atualização efetuada com sucesso."));
            }
            else {
                response.getWriter().write(gson.toJson("Ocorreu algum erro."));
            }
        } 
        catch (Exception ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
