package com.teste.demo.repository;

import java.util.List;

import com.teste.demo.model.Contato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
    List<Contato> findAllByIdentificacao(String identificacao);
}
