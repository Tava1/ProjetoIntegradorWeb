package com.dragsters.controllers;

import com.dragsters.dao.ClienteDAO;
import com.dragsters.model.Cliente;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Santos
 */

@WebServlet(name = "ClienteController", urlPatterns = "/ClienteController")
public class ClienteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
//        String nome = request.getParameter("nome");
//        String cpf = request.getParameter("cpf");
//        String geneno = request.getParameter("genero");
//        String estadoCivil = request.getParameter("estadoCivil");
//        String email = request.getParameter("email");
//        // TODO: Change to Date type
//        Date dataNascimento = Date.valueOf(request.getParameter("dataNascimento"));
//        String numeroContato = request.getParameter("numeroContato");
//        String endereco = request.getParameter("endereco");
//        String enderecoNumero = request.getParameter("enderecoNumero");
//        String complemento = request.getParameter("complemento");
//        String cidade = request.getParameter("cidade");
//        String estado = request.getParameter("estado");
        
        Cliente cliente = new Cliente();
        
        cliente.setNome(request.getParameter("nome"));
        cliente.setCPF(request.getParameter("cpf"));
        cliente.setGenero(request.getParameter("genero"));
        cliente.setEstadoCivil(request.getParameter("estadoCivil"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setDataNascimento(Date.valueOf(request.getParameter("dataNascimento")));
        cliente.setNumeroContato(request.getParameter("numeroContato"));
        cliente.setEndereco(request.getParameter("endereco"));
        cliente.setEnderecoNumero(request.getParameter("enderecoNumero"));
        cliente.setComplemento(request.getParameter("complemento"));
        cliente.setCidade(request.getParameter("cidade"));
        cliente.setEstado(request.getParameter("estado"));
        
        try {
            ClienteDAO.criar(cliente);
        } 
        catch (Exception e) {
        }
    }


}
