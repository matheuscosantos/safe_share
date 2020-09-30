package com.si.safe_share.resource;

import com.si.safe_share.model.Empresa;
import com.si.safe_share.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value="/api")
class EmpresaResource {

    //    Injeção de dependência
    @Autowired
    EmpresaRepository empresaRepository;

    @PostMapping("/empresa")
    public Empresa salva(@RequestBody Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @GetMapping("/empresa/{id}")
    public Optional<Empresa> buscaPorId(@PathVariable(value="id") Integer id){
        return empresaRepository.findById(id);
    }

    @DeleteMapping("/empresa/{id}")
    public void apagaPorId(@PathVariable(value="id") Integer id){
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if (empresa.isPresent()){
            empresaRepository.delete(empresa.get());
        }
    }

    @PutMapping("/empresa/{id}")
    public Empresa atualiza(@PathVariable(value="id") Integer id,
                              @RequestBody Empresa empresa){
        Optional<Empresa> empresaAntigo = empresaRepository.findById(id);
        if (empresaAntigo.isPresent()){
            empresaAntigo.get().setNome(empresa.getNome());
            return empresaRepository.save(empresaAntigo.get());
        }
        return empresaAntigo.get();
    }

    @GetMapping("/empresas")
    public List<Empresa> lista(){
        return empresaRepository.findAll();
    }
}