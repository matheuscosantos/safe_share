package com.si.safe_share.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Carrinho {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToMany
    private Set<Produto> produtos;

    @ManyToOne
    private Cliente cliente;

    public Carrinho(Set<Produto> produtos, Cliente cliente) {
        this.produtos = produtos;
        this.cliente = cliente;
    }
}