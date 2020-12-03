package com.dragsters.model;

/**
 *
 * @author Gustavo Santos
 */
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDetalheRelatorio {
    private int pedidoID; 
    private String modelo;
    private int quantidade;
    private double precoUnitario;
    private double total; 
    private String nomeCliente;
    private String cpfCliente;
    private String nomeFuncionario;
    private String enderecoUnidade;
    private String enderecoNumeroUnidade;
    private Date dataPedido; 
}