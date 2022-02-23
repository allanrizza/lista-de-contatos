package com.teste.demo.controller;

import java.util.List;

import com.teste.demo.model.Contato;
import com.teste.demo.service.ContatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoController {
    @Autowired
    ContatoService contatoService;

    @PostMapping
    public ResponseEntity<?> salvaPessoaCont(@RequestBody Contato contato) {
        try{
            contatoService.verificaNumero(contato);
            contatoService.salvaPessoaServ(contato);
            
        }catch(IllegalArgumentException exception) {
            return new ResponseEntity<>("O número não é válido", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> buscaPessoaCont(@RequestParam(required=false) String nome) {
      List<Contato> retornoContatos = contatoService.retornaPessoaServ(nome);
        return new ResponseEntity<>( retornoContatos ,HttpStatus.OK);
    }
}
