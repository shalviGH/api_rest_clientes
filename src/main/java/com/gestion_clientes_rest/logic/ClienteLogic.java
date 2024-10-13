package com.gestion_clientes_rest.logic;

import com.gestion_clientes_rest.dto.ClienteDto;
import com.gestion_clientes_rest.entity.Cliente;
import com.gestion_clientes_rest.repository.ClienteRepository;
import com.gestion_clientes_rest.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteLogic implements ClienteService {

    @Autowired
    ClienteRepository repository;

    @Override
    public Cliente save(ClienteDto clienteDto) {
        Cliente client = new Cliente();
        client.setName(clienteDto.getName());
        client.setLast_name(clienteDto.getLast_name());
        client.setEmail(clienteDto.getEmail());

        repository.save(client);

        return client;
    }

    @Override
    public Cliente update(ClienteDto clienteDto) {
        Cliente client = null;

        if(repository.findById(clienteDto.getId()).isPresent()){
            client = repository.findById(clienteDto.getId()).get();
            client.setName(clienteDto.getName());
            client.setLast_name(clienteDto.getLast_name());
            client.setEmail(clienteDto.getEmail());

            repository.save(client);
        }else {
            System.out.println("No se encontro el usuarioa editar");
        }


        return client;
    }

    @Override
    public Cliente find(long id) {
        Cliente client = null;

        if(repository.findById(id).isPresent()){
            client = repository.findById(id).get();

        }else {
            System.out.println("No se encontro el usuarioa editar");
        }


        return client;
    }

    @Override
    public String delete(long id) {
        Cliente client = null;

        if(repository.findById(id).isPresent()){
            client = repository.findById(id).get();
            repository.delete(client);
        }else {
            System.out.println("No se encontro el usuario a eliminar");
        }

        return  "Cliente eliminado";
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }
}
