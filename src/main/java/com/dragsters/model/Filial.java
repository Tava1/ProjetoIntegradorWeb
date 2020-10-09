package com.dragsters.model;

/**
 *
 * @author Gustavo Santos
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filial extends Endereco {
    private int filialID;

    public Filial(int filialID, String endereco, String enderecoNumero, String complemento, String cidade, String estado) {
        super(endereco, enderecoNumero, complemento, cidade, estado);
        this.filialID = filialID;
    }
}
