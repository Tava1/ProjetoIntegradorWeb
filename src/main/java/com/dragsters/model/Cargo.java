package com.dragsters.model;

/**
 *
 * @author Gustavo Santos
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cargo {
    private int cargoID;
    private String titulo;

    public Cargo() {
    }
       
    public Cargo(String titulo) {
        this.titulo = titulo;
    }

    public Cargo(int cargoID, String titulo) {
        this.cargoID = cargoID;
        this.titulo = titulo;
    }
    
}