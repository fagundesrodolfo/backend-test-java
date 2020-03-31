package com.fcamara.estacionamento.estacionameto.controles.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fcamara.estacionamento.estacionameto.modelos.EntradaEstacionamento;
import com.fcamara.estacionamento.estacionameto.modelos.Estabelecimento;
import com.fcamara.estacionamento.estacionameto.modelos.Veiculo;

import java.time.LocalDateTime;

public class EntradaEstacionamentoDTO {

    private Long id;
    private Veiculo veiculo;
    private Estabelecimento estabelecimento;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public EntradaEstacionamentoDTO(Long id, Veiculo veiculo, Estabelecimento estabelecimento, LocalDateTime horaEntrada, LocalDateTime horaSaida) {
        this.id = id;
        this.veiculo = veiculo;
        this.estabelecimento = estabelecimento;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public EntradaEstacionamentoDTO(EntradaEstacionamento entrada) {
        this.id = entrada.getId();
        this.veiculo = entrada.getVeiculo();
        this.estabelecimento = entrada.getEstabelecimento();
        this.horaEntrada = entrada.getHoraEntrada();
        this.horaSaida = entrada.getHoraSaida();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    @JsonIgnore
    public EntradaEstacionamento getEntradaEstabelecimento() {
        return new EntradaEstacionamento(
                getId(),
                getVeiculo(),
                getEstabelecimento(),
                getHoraEntrada(),
                getHoraSaida()
        );
    }
}
