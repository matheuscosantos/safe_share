package com.si.safe_share.resource.form;

import com.si.safe_share.model.Categoria;

public class CategoriaForm {
    private String descricao;

    public Categoria toModel(CategoriaForm categoriaForm) {
        Categoria categoria = new Categoria();
        categoria.setDescricao(categoriaForm.getDescricao());
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria toModelUpdated(Categoria categoriaAntiga, Categoria categoriaNova) {
        categoriaAntiga.setDescricao(categoriaNova.getDescricao());
        Categoria categoriaAtualizada = categoriaAntiga;
        return categoriaAtualizada;
    }
}
