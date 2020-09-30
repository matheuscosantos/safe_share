package com.si.safe_share.resource;

import com.si.safe_share.model.Categoria;
import com.si.safe_share.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
public class CategoriaResource {
    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping("/categoria")
    public Categoria salva(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @GetMapping("/categoria/{id}")
    public Optional<Categoria> buscaPorId(@PathVariable(value="id") Integer id){
        return categoriaRepository.findById(id);
    }

    @DeleteMapping("/categoria/{id}")
    public void apagaPorId(@PathVariable(value="id") Integer id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()){
            categoriaRepository.delete(categoria.get());
        }
    }

    @PutMapping("/categoria/{id}")
    public Categoria atualiza(@PathVariable(value="id") Integer id,
                              @RequestBody Categoria categoria){
        Optional<Categoria> categoriaAntigo = categoriaRepository.findById(id);
        if (categoriaAntigo.isPresent()){
            categoriaAntigo.get().setDescricao(categoria.getDescricao());
            return categoriaRepository.save(categoriaAntigo.get());
        }
        return categoriaAntigo.get();
    }

    @GetMapping("/categorias")
    public List<Categoria> lista(){
        return categoriaRepository.findAll();
    }
}
