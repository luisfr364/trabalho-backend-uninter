package com.example.produtosapi.services;

import com.example.produtosapi.models.Pedido;
import com.example.produtosapi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PedidoServices {

    private final PedidoRepository repository;

    @Autowired
    public PedidoServices(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido criarPedido(Pedido pedido) {
        return repository.save(pedido);
    }

    public void deletarPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido nao encontrado");
        }
        repository.deleteById(id);
    }

    public Pedido buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido nao encontrado"));
    }

    public List<Pedido> listarTodos() {
        return repository.findAll();
    }
}
