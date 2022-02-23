package com.teste.demo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "contatos")
public class Contato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String identificacao;

    @NotBlank
    private String numero1;

    private String numero2;

    @Email
    private String email;

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate data_nascimento;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacao() {
        return this.identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getNumero1() {
        return this.numero1;
    }

    public void setNumero1(String numero1) {
        this.numero1 = numero1;
    }

    public String getNumero2() {
        return this.numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_nascimento() {
        return this.data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", Identificação: '" + getIdentificacao() + "'" +
            ", Número 1: '" + getNumero1() + "'" +
            ", Número 2: '" + getNumero2() + "'" +
            ", E-mail: '" + getEmail() + "'" +
            ", Data de aniversário: '" + getData_nascimento() + "'" +
            "}";
    }


}
