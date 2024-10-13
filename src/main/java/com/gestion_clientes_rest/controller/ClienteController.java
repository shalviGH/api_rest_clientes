package com.gestion_clientes_rest.controller;

import com.gestion_clientes_rest.dto.ClienteDto;
import com.gestion_clientes_rest.entity.Cliente;
import com.gestion_clientes_rest.logic.ClienteLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    ClienteLogic service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = service.findAll();
        return  new ResponseEntity<List<Cliente>>(list, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Cliente> find(@PathVariable long id){
        Cliente client = service.find(id);
        return  new ResponseEntity<Cliente>(client, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/save")
    public ResponseEntity<Cliente> find(@RequestBody ClienteDto clienteDto){
        Cliente cliente = service.save(clienteDto);

        return new ResponseEntity<Cliente>(cliente, HttpStatusCode.valueOf(200));

    }

    @PutMapping("/update")
    public ResponseEntity<Cliente> update(@RequestBody ClienteDto clienteDto){
        Cliente cliente = service.update(clienteDto);

        return new ResponseEntity<Cliente>(cliente, HttpStatusCode.valueOf(200));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        String message  = service.delete(id);

        return new ResponseEntity<String>(message, HttpStatusCode.valueOf(200));

    }


}
