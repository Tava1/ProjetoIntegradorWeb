package com.dragsters.model;

/**
 *
 * @author Gustavo Santos
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedido {
    private int itemPedidoID;
    private int quantidade;
    private int pedidoID;
    private int produtoID;
}
