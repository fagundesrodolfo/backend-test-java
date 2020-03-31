package com.fcamara.estacionamento.estacionameto.controles.dtos;

import com.fcamara.estacionamento.estacionameto.modelos.Estabelecimento;

public class EstabelecimentoDTO {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereço;
    private String telefone;
    private Integer quantidadeDeVagasParaMotos;
    private Integer quantidadeDeVagasParaCarros;

    public EstabelecimentoDTO(Long id, String nome, String cnpj, String endereço, String telefone, Integer quantidadeDeVagasParaMotos, Integer quantidadeDeVagasParaCarros) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereço = endereço;
        this.telefone = telefone;
        this.quantidadeDeVagasParaMotos = quantidadeDeVagasParaMotos;
        this.quantidadeDeVagasParaCarros = quantidadeDeVagasParaCarros;
    }

    public EstabelecimentoDTO(Estabelecimento estabelecimento) {
        this.id = estabelecimento.getId();
        this.nome = estabelecimento.getNome();
        this.cnpj = estabelecimento.getCnpj();
        this.endereço = estabelecimento.getEndereco();
        this.telefone = estabelecimento.getTelefone();
        this.quantidadeDeVagasParaMotos = estabelecimento.getQuantidadeDeVagasParaMotos();
        this.quantidadeDeVagasParaCarros = estabelecimento.getQuantidadeDeVagasParaCarros();
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

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
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
