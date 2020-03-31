package com.fcamara.estacionamento.estacionameto.controles.forms;

import com.fcamara.estacionamento.estacionameto.modelos.Estabelecimento;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EstabelecimentoForm {

    private Long id;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    @Length(max = 50)
    private String nome;

    @NotNull
    @NotEmpty
    @Length(max = 14)
    @Length(min = 14)
    private String cnpj;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    @Length(max = 100)
    private String endereco;

    @NotNull
    @NotEmpty
    @Length(min = 8)
    private String telefone;

    @NotNull
    @NotEmpty
    @Min(0)
    private Integer quantidadeDeVagasParaMotos;

    @NotNull
    @NotEmpty
    @Min(0)
    private Integer quantidadeDeVagasParaCarros;

    public EstabelecimentoForm(Long id, @NotNull @NotEmpty @Length(min = 5) @Length(max = 50) String nome, @NotNull @NotEmpty @Length(max = 14) @Length(min = 14) String cnpj, @NotNull @NotEmpty @Length(min = 5) @Length(max = 100) String endereco, @NotNull @NotEmpty @Length(min = 8) String telefone, @NotNull @NotEmpty @Min(0) Integer quantidadeDeVagasParaMotos, @NotNull @NotEmpty @Min(0) Integer quantidadeDeVagasParaCarros) {
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

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public Estabelecimento getEstabelecimento() {
        return
                new Estabelecimento(
                        getId(),
                        getNome(),
                        getCnpj(),
                        getEndereco(),
                        getTelefone(),
                        getQuantidadeDeVagasParaMotos(),
                        getQuantidadeDeVagasParaCarros()
                );
    }
}
