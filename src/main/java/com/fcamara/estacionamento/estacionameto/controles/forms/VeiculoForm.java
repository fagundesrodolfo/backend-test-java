package com.fcamara.estacionamento.estacionameto.controles.forms;

import com.fcamara.estacionamento.estacionameto.modelos.Veiculo;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VeiculoForm {

    private Long id;

    @NotNull
    @NotEmpty
    @Length(max = 50)
    private String marca;

    @NotNull
    @NotEmpty
    @Length(max = 50)
    private String modelo;

    @NotNull
    @NotEmpty
    @Length(max = 50)
    private String cor;

    @NotNull
    @Length(min = 8)
    @Length(max = 10)
    private String placa;

    @NotNull
    @NotEmpty
    @Length(max = 50)
    private String tipo;

    public VeiculoForm(Long id, @NotNull @Length(min = 5) @Length(max = 50) String marca, @NotNull @Length(min = 5) @Length(max = 50) String modelo, @NotNull @Length(min = 5) @Length(max = 50) String cor, @NotNull @Length(min = 10) @Length(max = 12) String placa, @NotNull @Length(min = 5) @Length(max = 50) String tipo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Veiculo getVeiculo() {
        return new Veiculo(
                getId(),
                getMarca(),
                getModelo(),
                getCor(),
                getPlaca(),
                getTipo()
        );
    }
}
