package com.si.safe_share.resource.form;

import com.si.safe_share.model.Cliente;
import com.si.safe_share.model.ConfiguracaoCompartilhamento;
import com.si.safe_share.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ConfiguracaoCompartilhamentoForm {

    private Integer cliente;
    private Boolean compartilha_dados_pessoais;
    private Boolean compartilha_dados_compras;

    @Autowired
    ClienteRepository clienteRepository;

    public ConfiguracaoCompartilhamento toModel(ConfiguracaoCompartilhamentoForm configuracaoCompartilhamentoForm) {

        Optional<Cliente> clienteOpt = clienteRepository.findById(configuracaoCompartilhamentoForm.getCliente());
        Cliente cliente = clienteOpt.get();

        ConfiguracaoCompartilhamento configuracaoCompartilhamento = new ConfiguracaoCompartilhamento();

        configuracaoCompartilhamento.setCliente(cliente);
        configuracaoCompartilhamento.setCompartilha_dados_compras(configuracaoCompartilhamentoForm.getCompartilha_dados_compras());
        configuracaoCompartilhamento.setCompartilha_dados_pessoais(configuracaoCompartilhamentoForm.getCompartilha_dados_pessoais());

        return configuracaoCompartilhamento;
    }

    public ConfiguracaoCompartilhamento toModelUpdated(ConfiguracaoCompartilhamento configuracaoCompartilhamentoAntiga, ConfiguracaoCompartilhamento configuracaoCompartilhamentoNova) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(configuracaoCompartilhamentoNova.getCliente().getId());
        Cliente cliente = clienteOpt.get();
        configuracaoCompartilhamentoAntiga.setCliente(cliente);
        configuracaoCompartilhamentoAntiga.setCompartilha_dados_compras(configuracaoCompartilhamentoNova.getCompartilha_dados_compras());
        configuracaoCompartilhamentoAntiga.setCompartilha_dados_pessoais(configuracaoCompartilhamentoNova.getCompartilha_dados_pessoais());
        ConfiguracaoCompartilhamento configuracaoCompartilhamentoAtualizada = configuracaoCompartilhamentoAntiga;
        return configuracaoCompartilhamentoAtualizada;
    }

    public Integer getCliente() {
        return cliente;
    }

    public Boolean getCompartilha_dados_pessoais() {
        return compartilha_dados_pessoais;
    }

    public Boolean getCompartilha_dados_compras() {
        return compartilha_dados_compras;
    }

}
