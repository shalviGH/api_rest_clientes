package com.gestion_clientes_rest.service;

import com.gestion_clientes_rest.dto.ClienteDto;
import com.gestion_clientes_rest.entity.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente save(ClienteDto clienteDto);
    Cliente update(ClienteDto clienteDto);
    Cliente find(long id);
    String delete(long id);
    List findAll();
}
