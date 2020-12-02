/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dragsters.controllers;

import com.dragsters.dao.UnidadeDAO;
import com.dragsters.model.Unidade;
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
public class DetalheUnidade extends HttpServlet {

private UnidadeDAO unidadeDAO = new UnidadeDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int unidadeID = Integer.parseInt(request.getParameter("unidadeID"));
        
        Unidade unidade = unidadeDAO.listarUnidadeID(unidadeID);
        
        request.setAttribute("unidade", unidade);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/branches/update-branch.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Unidade unidade = new Unidade();
       
        try {
            unidade.setUnidadeID(Integer.parseInt(request.getParameter("unidadeID")));
            unidade.setTitulo(request.getParameter("titulo"));
            unidade.setEndereco(request.getParameter("endereco"));
            unidade.setEnderecoNumero(request.getParameter("enderecoNumero"));
            unidade.setCidade(request.getParameter("cidade"));
            unidade.setEstado(request.getParameter("estado"));
            unidade.setTitulo(request.getParameter("titulo"));
        
            unidadeDAO.atualizar(unidade);
        } 
        catch (Exception ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
