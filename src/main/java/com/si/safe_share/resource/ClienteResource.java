package com.si.safe_share.resource;

import com.si.safe_share.model.Cliente;
import com.si.safe_share.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
public class ClienteResource {
    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping("/cliente")
    public Cliente salva(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/cliente/{id}")
    public Optional<Cliente> buscaPorId(@PathVariable(value="id") Integer id){
        return clienteRepository.findById(id);
    }

    @DeleteMapping("/cliente/{id}")
    public void apagaPorId(@PathVariable(value="id") Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()){
            clienteRepository.delete(cliente.get());
        }
    }

    @PutMapping("/cliente/{id}")
    public Cliente atualiza(@PathVariable(value="id") Integer id,
                              @RequestBody Cliente cliente){
        Optional<Cliente> clienteAntigo = clienteRepository.findById(id);
        if (clienteAntigo.isPresent()){
            clienteAntigo.get().setNome(cliente.getNome());
            clienteAntigo.get().setSobrenome(cliente.getSobrenome());
            clienteAntigo.get().setCpf(cliente.getCpf());
            clienteAntigo.get().setEmail(cliente.getEmail());
            clienteAntigo.get().setEndereco(cliente.getEndereco());
            clienteAntigo.get().setTelefone(cliente.getTelefone());
            clienteAntigo.get().setSenha(cliente.getSenha());
            return clienteRepository.save(clienteAntigo.get());
        }
        return clienteAntigo.get();
    }

    @GetMapping("/clientes")
    public List<Cliente> lista(){
        return clienteRepository.findAll();
    }
}
