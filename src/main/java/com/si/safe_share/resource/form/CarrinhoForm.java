package com.si.safe_share.resource.form;

import com.si.safe_share.model.Carrinho;
import com.si.safe_share.model.Cliente;
import com.si.safe_share.model.Produto;
import com.si.safe_share.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;

public class CarrinhoForm {
    private Set<Produto> produtos;
    private Integer cliente;

    @Autowired
    ClienteRepository clienteRepository;

    public Carrinho toModel(CarrinhoForm carrinhoForm) {
        Carrinho carrinho = new Carrinho();

        Optional<Cliente> clienteOpt = clienteRepository.findById(carrinhoForm.getCliente());
        Cliente cliente = clienteOpt.get();

        carrinho.setCliente(cliente);
        carrinho.setProdutos(carrinhoForm.getProdutos());
        return carrinho;
    }

    public Carrinho toModelUpdated(Carrinho carrinhoAntigo, Carrinho carrinhoNovo) {
        carrinhoAntigo.setCliente(carrinhoNovo.getCliente());
        carrinhoAntigo.setProdutos(carrinhoNovo.getProdutos());
        Carrinho carrinhoAtualizado = carrinhoAntigo;
        return carrinhoAtualizado;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public Integer getCliente() {
        return cliente;
    }

}
