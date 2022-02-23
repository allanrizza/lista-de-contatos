package com.teste.demo.service;
import java.util.List;

import com.teste.demo.model.Contato;
import com.teste.demo.repository.ContatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("contatoService")
public class ContatoService {
    @Autowired
    ContatoRepository pessoaRepository;

    public void salvaPessoaServ(Contato pessoa) {
        pessoaRepository.save(pessoa);
    }

    public List<Contato> retornaPessoaServ(String nome){
        return pessoaRepository.findAllByIdentificacao(nome);

    }

    public boolean validaNumero(Contato contato) {
        String numeroContato = contato.getNumero1();
        for(int i=0; i < numeroContato.length(); i++){
            if(
                !(Character.isDigit(numeroContato.charAt(i))) &&
                !(Character.isWhitespace(numeroContato.charAt(i)))
            ){
                return false; }
        }

        return true;
    }

    public void verificaNumero(Contato contato) {
        String numeroContato = contato.getNumero1();
        for(int i = 0; i < numeroContato.length(); i++){
            if(!validaNumero(contato)){
                throw new IllegalArgumentException();
            }
        }
    }

}
