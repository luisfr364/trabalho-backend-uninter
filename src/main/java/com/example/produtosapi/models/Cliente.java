package com.example.produtosapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate clienteDesde;

    public Cliente() {

    }

    public Cliente(String nome, LocalDate clienteDesde) {
        this.nome = nome;
        this.clienteDesde = clienteDesde;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getClienteDesde() {
        return clienteDesde;
    }

    public void setClienteDesde(LocalDate clienteDesde) {
        this.clienteDesde = clienteDesde;
    }

    public void setClienteDesde(String clienteDesde) {
        if (clienteDesde == null || clienteDesde.isBlank()) {
            this.clienteDesde = null;
            return;
        }
        DateTimeFormatter dash = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter slash = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            this.clienteDesde = LocalDate.parse(clienteDesde, dash);
        } catch (DateTimeParseException first) {
            this.clienteDesde = LocalDate.parse(clienteDesde, slash);
        }
    }
}
