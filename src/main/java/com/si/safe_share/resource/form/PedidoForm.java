package com.si.safe_share.resource.form;

import com.si.safe_share.model.Carrinho;
import com.si.safe_share.model.Cliente;
import com.si.safe_share.model.Pedido;
import com.si.safe_share.repository.CarrinhoRepository;
import com.si.safe_share.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class PedidoForm {
    private Integer cliente;
    private Integer carrinho;
    private BigDecimal valorTotal;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CarrinhoRepository carrinhoRepository;

    public Pedido toModel(PedidoForm pedidoForm) {
        Optional<Cliente> clienteEncontradoOpt = clienteRepository.findById(pedidoForm.getCliente());
        Cliente cliente = clienteEncontradoOpt.get();

        Optional<Carrinho> carrinhoEncontradoOpt = carrinhoRepository.findById(pedidoForm.getCliente());
        Carrinho carrinho = carrinhoEncontradoOpt.get();

        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);
        pedido.setDataDoPedido(LocalDateTime.now());
        pedido.setCarrinho(carrinho);

        return pedido;
    }

    public Pedido toModelUpdated(Pedido pedidoAntigo, Pedido pedidoNovo) {
        pedidoAntigo.setCliente(pedidoNovo.getCliente());
        pedidoAntigo.setCarrinho(pedidoNovo.getCarrinho());
        pedidoAntigo.setDataDoPedido(LocalDateTime.now());
        Pedido pedidoAtualizado = pedidoAntigo;
        return pedidoAtualizado;
    }

    public Integer getCliente() {
        return cliente;
    }

    public Integer getCarrinho() {
        return carrinho;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }


}
