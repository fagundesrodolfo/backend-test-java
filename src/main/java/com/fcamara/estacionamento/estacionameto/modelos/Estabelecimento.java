package com.fcamara.estacionamento.estacionameto.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private Integer quantidadeDeVagasParaMotos;
    private Integer quantidadeDeVagasParaCarros;

    public Estabelecimento() {
    }

    public Estabelecimento(Long id, String nome, String cnpj, String endereco, String telefone, Integer quantidadeDeVagasParaMotos, Integer quantidadeDeVagasParaCarros) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.quantidadeDeVagasParaMotos = quantidadeDeVagasParaMotos;
        this.quantidadeDeVagasParaCarros = quantidadeDeVagasParaCarros;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereço) {
        this.endereco = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getQuantidadeDeVagasParaMotos() {
        return quantidadeDeVagasParaMotos;
    }

    public void setQuantidadeDeVagasParaMotos(Integer quantidadeDeVagasParaMotos) {
        this.quantidadeDeVagasParaMotos = quantidadeDeVagasParaMotos;
    }

    public Integer getQuantidadeDeVagasParaCarros() {
        return quantidadeDeVagasParaCarros;
    }

    public void setQuantidadeDeVagasParaCarros(Integer quantidadeDeVagasParaCarros) {
        this.quantidadeDeVagasParaCarros = quantidadeDeVagasParaCarros;
    }
}
