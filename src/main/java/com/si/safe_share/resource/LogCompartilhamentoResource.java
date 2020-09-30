package com.si.safe_share.resource;

import com.si.safe_share.model.LogCompartilhamento;
import com.si.safe_share.repository.LogCompartilhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
public class LogCompartilhamentoResource {
    @Autowired
    LogCompartilhamentoRepository logCompartilhamentoRepository;

    @PostMapping("/log-compartilhamento")
    public LogCompartilhamento salva(@RequestBody LogCompartilhamento logCompartilhamento) {
        return logCompartilhamentoRepository.save(logCompartilhamento);
    }

    @GetMapping("/log-compartilhamento/{id}")
    public Optional<LogCompartilhamento> buscaPorId(@PathVariable(value="id") Integer id){
        return logCompartilhamentoRepository.findById(id);
    }

    @DeleteMapping("/log-compartilhamento/{id}")
    public void apagaPorId(@PathVariable(value="id") Integer id){
        Optional<LogCompartilhamento> logCompartilhamento = logCompartilhamentoRepository.findById(id);
        if (logCompartilhamento.isPresent()){
            logCompartilhamentoRepository.delete(logCompartilhamento.get());
        }
    }

    @PutMapping("/log-compartilhamento/{id}")
    public LogCompartilhamento atualiza(@PathVariable(value="id") Integer id,
                              @RequestBody LogCompartilhamento logCompartilhamento){
        Optional<LogCompartilhamento> logCompartilhamentoAntigo = logCompartilhamentoRepository.findById(id);
        if (logCompartilhamentoAntigo.isPresent()){
            logCompartilhamentoAntigo.get().setCliente(logCompartilhamento.getCliente());
            logCompartilhamentoAntigo.get().setDadoCompartilhado(logCompartilhamento.getDadoCompartilhado());
            logCompartilhamentoAntigo.get().setDataDeInicio(logCompartilhamento.getDataDeInicio());
            logCompartilhamentoAntigo.get().setDataFinal(logCompartilhamento.getDataFinal());
            logCompartilhamentoAntigo.get().setEmpresa(logCompartilhamento.getEmpresa());

            return logCompartilhamentoRepository.save(logCompartilhamentoAntigo.get());
        }
        return logCompartilhamentoAntigo.get();
    }

    @GetMapping("/log-compartilhamentos")
    public List<LogCompartilhamento> lista(){
        return logCompartilhamentoRepository.findAll();
    }
}
