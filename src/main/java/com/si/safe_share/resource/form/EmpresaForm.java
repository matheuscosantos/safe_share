package com.si.safe_share.resource.form;

import com.si.safe_share.model.Empresa;

public class EmpresaForm {
    private String nome;


    public Empresa toModel(EmpresaForm empresaForm) {
        Empresa empresa = new Empresa();
        empresa.setNome(empresaForm.getNome());
        return empresa;
    }

    public Empresa toModelUpdated(Empresa empresaAntiga, Empresa empresaNova) {
        empresaAntiga.setNome(empresaNova.getNome());
        return empresaAntiga;
    }

    public String getNome() {
        return nome;
    }


}
