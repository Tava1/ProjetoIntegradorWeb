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
    private int ativo;
    private int categoriaID;
    private int unidadeID;
}
