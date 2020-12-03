package com.dragsters.controllers;

import com.dragsters.dao.FuncionarioDAO;
import com.dragsters.model.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gustavo Santos
 */
public class LoginController extends HttpServlet {

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Funcionario usuario = funcionarioDAO.verificarAcesso(Integer.parseInt(login), senha);
        
        if (usuario == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp?erro=UserNotFound");
        }
        else {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);
            response.sendRedirect(request.getContextPath() + "/protected/pages/index.jsp");
        }
    }

}
