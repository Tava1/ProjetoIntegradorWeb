package com.dragsters.model;

/**
 *
 * @author Gustavo Santos
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Pessoa {
    private int clienteID;
    private String estadoCivil;
    private String numeroContato;

    public Cliente() {
        super();
    }
    
    
}