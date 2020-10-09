package com.dragsters.model;

/**
 *
 * @author Gustavo Santos
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {
    private String endereco;
    private String enderecoNumero;
    private String complemento;
    private String cidade;
    private String estado;

    public Endereco(String endereco, String enderecoNumero, String complemento, String cidade, String estado) {
        this.endereco = endereco;
        this.enderecoNumero = enderecoNumero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }
}
