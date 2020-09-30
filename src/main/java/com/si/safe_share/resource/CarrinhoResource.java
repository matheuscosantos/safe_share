package com.si.safe_share.resource;

import com.si.safe_share.model.Carrinho;
import com.si.safe_share.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
public class CarrinhoResource {
    @Autowired
    CarrinhoRepository carrinhoRepository;

    @PostMapping("/carrinho")
    public Carrinho salva(@RequestBody Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    @GetMapping("/carrinho/{id}")
    public Optional<Carrinho> buscaPorId(@PathVariable(value="id") Integer id){
        return carrinhoRepository.findById(id);
    }

    @DeleteMapping("/carrinho/{id}")
    public void apagaPorId(@PathVariable(value="id") Integer id){
        Optional<Carrinho> carrinho = carrinhoRepository.findById(id);
        if (carrinho.isPresent()){
            carrinhoRepository.delete(carrinho.get());
        }
    }

    @PutMapping("/carrinho/{id}")
    public Carrinho atualiza(@PathVariable(value="id") Integer id,
                              @RequestBody Carrinho carrinho){
        Optional<Carrinho> carrinhoAntigo = carrinhoRepository.findById(id);
        if (carrinhoAntigo.isPresent()){
            carrinhoAntigo.get().setProdutos(carrinho.getProdutos());
            carrinhoAntigo.get().setCliente(carrinho.getCliente());
            return carrinhoRepository.save(carrinhoAntigo.get());
        }
        return carrinhoAntigo.get();
    }

    @GetMapping("/carrinhos")
    public List<Carrinho> lista(){
        return carrinhoRepository.findAll();
    }
}
