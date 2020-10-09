package com.dragsters.model;

/**
 *
 * @author Gustavo Santos
 */

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {
    private String nome;
    private String CPF;
    private String genero;
    private String email;
    private Date dataNascimento;
}
