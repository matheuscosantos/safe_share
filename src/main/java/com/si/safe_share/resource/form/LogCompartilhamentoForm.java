package com.si.safe_share.resource.form;

import com.si.safe_share.model.Cliente;
import com.si.safe_share.model.Empresa;
import com.si.safe_share.model.LogCompartilhamento;
import com.si.safe_share.repository.ClienteRepository;
import com.si.safe_share.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

public class LogCompartilhamentoForm {
    private LocalDate dataDeInicio;
    private LocalDate dataFinal;
    private String dadoCompartilhado;
    private Integer cliente;
    private Integer empresa;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    public LogCompartilhamento toModel(LogCompartilhamentoForm logCompartilhamentoForm) {

        Optional<Cliente> clienteOpt = clienteRepository.findById(cliente);
        Cliente cliente = clienteOpt.get();

        Optional<Empresa> empresaOpt = empresaRepository.findById(empresa);
        Empresa empresa = empresaOpt.get();

        LogCompartilhamento logCompartilhamento = new LogCompartilhamento();

        logCompartilhamento.setCliente(cliente);
        logCompartilhamento.setEmpresa(empresa);
        logCompartilhamento.setDataDeInicio(logCompartilhamentoForm.getDataDeInicio());
        logCompartilhamento.setDataFinal(logCompartilhamentoForm.getDataFinal());
        logCompartilhamento.setDadoCompartilhado(logCompartilhamentoForm.getDadoCompartilhado());

        return logCompartilhamento;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public String getDadoCompartilhado() {
        return dadoCompartilhado;
    }

    public Integer getCliente() {
        return cliente;
    }

    public Integer getEmpresa() {
        return empresa;
    }

}
