package com.example.produtosapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<com.example.produtosapi.models.Pedido, Long> {
    
}
