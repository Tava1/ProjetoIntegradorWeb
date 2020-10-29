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
public class Pedido {
    private int pedidoID; 
    private double total; 
    private Date dataPedido; 
    private int vendaConcluida;
    private int clienteID; 
    private int funcionarioID; 
    private int unidadeID;
}
