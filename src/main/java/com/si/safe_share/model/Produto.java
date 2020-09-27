package com.si.safe_share.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Produto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String descricao;
    private BigDecimal valor;

    @ManyToOne
    private Categoria categoria;

    public Produto(String descricao, BigDecimal valor, Categoria categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }
}


