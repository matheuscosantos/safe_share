package com.si.safe_share.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Categoria {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String descricao;

    public Categoria(String descricao) {
        this.descricao = descricao;
    }
}


