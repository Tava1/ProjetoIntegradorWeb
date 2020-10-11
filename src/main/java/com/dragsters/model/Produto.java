package com.dragsters.model;

/**
 *
 * @author Gustavo Santos
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    private int produtoID;
    private String marca;
    private String modelo;
    private String descricao;
    private double precoUnitario;
    private boolean ativo;
    private int categoriaID;
    private int estoqueID;
    private int filialID;
}