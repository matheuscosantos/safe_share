package com.si.safe_share.resource.form;

import com.si.safe_share.model.Categoria;
import com.si.safe_share.model.Produto;
import com.si.safe_share.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

public class ProdutoForm {
    private String descricao;
    private BigDecimal valor;
    private Integer categoria;

    @Autowired
    CategoriaRepository categoriaRepository;

    public Produto toModel(ProdutoForm produtoForm) {
        final Optional<Categoria> categoria = categoriaRepository.findById(produtoForm.getCategoria());
        Produto produto = new Produto();
        if(categoria.isPresent()){
            produto.setCategoria(categoria.get());
            produto.setDescricao(produtoForm.getDescricao());
            produto.setValor(produtoForm.getValor());
            return produto;
        }
        produto.setDescricao(produtoForm.getDescricao());
        produto.setValor(produtoForm.getValor());
        return produto;
    }

    public Produto toModelUpdated(Produto produtoAntigo, Produto produtoNovo) {
        produtoAntigo.setDescricao(produtoNovo.getDescricao());
        produtoAntigo.setValor(produtoNovo.getValor());
        produtoAntigo.setCategoria(produtoNovo.getCategoria());
        Produto produtoAtualizado = new Produto();
        produtoAtualizado = produtoAntigo;
        return produtoAntigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getCategoria() {
        return categoria;
    }

}
