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
public class PedidoRelatorio {
    private int pedidoID; 
    private double total; 
    private Date dataPedido; 
    private String nomeCliente;
    private String cpfCliente;
    private String nomeFuncionario;
    private String enderecoUnidade;
    private String enderecoNumeroUnidade;
}