package com.dragsters.controllers;

import com.dragsters.dao.UnidadeDAO;
import com.dragsters.model.Unidade;
import java.io.IOException;
import java.sql.Date;
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
public class CriarUnidade extends HttpServlet {

    private UnidadeDAO unidadeDAO = new UnidadeDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/admin/branches/create-branch.jsp");
        requestDispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Unidade unidade = new Unidade();
        
        try {

            unidade.setEndereco(request.getParameter("endereco"));
            unidade.setEnderecoNumero(request.getParameter("enderecoNumero"));
            unidade.setCidade(request.getParameter("cidade"));
            unidade.setEstado(request.getParameter("estado"));
            unidade.setTitulo(request.getParameter("titulo"));
        
            unidadeDAO.criar(unidade);
        } 
        catch (Exception ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
