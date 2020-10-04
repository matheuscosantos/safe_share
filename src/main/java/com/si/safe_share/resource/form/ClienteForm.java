package com.si.safe_share.resource.form;

import com.si.safe_share.model.Cliente;

public class ClienteForm {
    private String cpf;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String endereco;
    private String email;
    private String senha;
    public Cliente toModel(ClienteForm clienteForm) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteForm.getNome());
        cliente.setSobrenome(clienteForm.getSobrenome());
        cliente.setCpf(clienteForm.getCpf());
        cliente.setEmail(clienteForm.getEmail());
        cliente.setSenha(clienteForm.getSenha());
        cliente.setTelefone(clienteForm.getTelefone());
        cliente.setEndereco(clienteForm.getEndereco());
        return cliente;
    }

    public Cliente toModelUpdated(Cliente clienteAntigo, Cliente clienteNovo) {
        clienteAntigo.setNome(clienteNovo.getNome());
        clienteAntigo.setSobrenome(clienteNovo.getSobrenome());
        clienteAntigo.setEndereco(clienteNovo.getEndereco());
        clienteAntigo.setTelefone(clienteNovo.getTelefone());
        clienteAntigo.setEmail(clienteNovo.getEmail());
        clienteAntigo.setCpf(clienteNovo.getCpf());
        clienteAntigo.setSenha(clienteNovo.getSenha());
        Cliente clienteAtualizado = clienteAntigo;
        return clienteAtualizado;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

}
