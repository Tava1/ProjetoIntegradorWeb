package com.dragsters.model;

/**
 *
 * @author Gustavo Santos
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Unidade extends Endereco {
    private int unidadeID;
    private String titulo;

    public Unidade() {
    }
    
    public Unidade(int unidadeID, String titulo, String endereco, String enderecoNumero, String complemento, String cidade, String estado) {
        super(endereco, enderecoNumero, complemento, cidade, estado);
        this.unidadeID = unidadeID;
        this.titulo = titulo;
    }
}
