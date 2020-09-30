package com.si.safe_share.resource;

import com.si.safe_share.model.ConfiguracaoCompartilhamento;
import com.si.safe_share.repository.ConfiguracaoCompartilhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
public class ConfiguracaoCompartilhamentoResource {
    @Autowired
    ConfiguracaoCompartilhamentoRepository configuracaoCompartilhamentoRepository;

    @PostMapping("/configuracaoCompartilhamento")
    public ConfiguracaoCompartilhamento salva(@RequestBody ConfiguracaoCompartilhamento configuracaoCompartilhamento) {
        return configuracaoCompartilhamentoRepository.save(configuracaoCompartilhamento);
    }

    @GetMapping("/configuracaoCompartilhamento/{id}")
    public Optional<ConfiguracaoCompartilhamento> buscaPorId(@PathVariable(value="id") Integer id){
        return configuracaoCompartilhamentoRepository.findById(id);
    }

    @DeleteMapping("/configuracaoCompartilhamento/{id}")
    public void apagaPorId(@PathVariable(value="id") Integer id){
        Optional<ConfiguracaoCompartilhamento> configuracaoCompartilhamento = configuracaoCompartilhamentoRepository.findById(id);
        if (configuracaoCompartilhamento.isPresent()){
            configuracaoCompartilhamentoRepository.delete(configuracaoCompartilhamento.get());
        }
    }

    @PutMapping("/configuracaoCompartilhamento/{id}")
    public ConfiguracaoCompartilhamento atualiza(@PathVariable(value="id") Integer id,
                              @RequestBody ConfiguracaoCompartilhamento configuracaoCompartilhamento){
        Optional<ConfiguracaoCompartilhamento> configuracaoCompartilhamentoAntigo = configuracaoCompartilhamentoRepository.findById(id);
        if (configuracaoCompartilhamentoAntigo.isPresent()){
            configuracaoCompartilhamentoAntigo.get().getCliente();
            configuracaoCompartilhamentoAntigo.get().getCompartilha_dados_compras();
            configuracaoCompartilhamentoAntigo.get().getCompartilha_dados_pessoais();

            return configuracaoCompartilhamentoRepository.save(configuracaoCompartilhamentoAntigo.get());
        }
        return configuracaoCompartilhamentoAntigo.get();
    }

    @GetMapping("/configuracao-compartilhamentos")
    public List<ConfiguracaoCompartilhamento> lista(){
        return configuracaoCompartilhamentoRepository.findAll();
    }
}
