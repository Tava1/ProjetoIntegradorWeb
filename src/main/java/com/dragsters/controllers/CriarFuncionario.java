
package com.dragsters.controllers;

import com.dragsters.dao.FuncionarioDAO;
import com.dragsters.model.Funcionario;
import com.google.gson.Gson;
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
public class CriarFuncionario extends HttpServlet {

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/admin/employees/create-employee.jsp");
        requestDispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Gson gson = new Gson();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Funcionario funcionario = new Funcionario();
        
        try {

            funcionario.setNome(request.getParameter("nome"));
            funcionario.setCPF(request.getParameter("cpf"));
            funcionario.setGenero(request.getParameter("genero"));
            funcionario.setEmail(request.getParameter("email"));
            funcionario.setDataNascimento(Date.valueOf(request.getParameter("dataNascimento")));
            funcionario.setSenha(request.getParameter("senha"));
            funcionario.setAtivo(1);
            funcionario.setCargoID(Integer.parseInt(request.getParameter("cargoID")));
            funcionario.setUnidadeID(Integer.parseInt(request.getParameter("unidadeID")));
            
            if(funcionarioDAO.criar(funcionario)) {
                response.getWriter().write(gson.toJson("Cadastrado com sucesso."));
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
