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
public abstract class Pessoa extends Endereco {
    private String nome;
    private String CPF;
    private String genero;
    private String email;
    private Date dataNascimento;

    public Pessoa() {
        super();
    }
}
