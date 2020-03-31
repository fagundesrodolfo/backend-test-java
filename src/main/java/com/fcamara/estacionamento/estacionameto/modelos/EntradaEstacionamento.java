package com.fcamara.estacionamento.estacionameto.modelos;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
public class EntradaEstacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Veiculo veiculo;

    @ManyToOne
    private Estabelecimento estabelecimento;

    private LocalDateTime horaEntrada = LocalDateTime.now();
    private LocalDateTime horaSaida;

    public EntradaEstacionamento() {
    }

    public EntradaEstacionamento(Long id, Veiculo veiculo, Estabelecimento estabelecimento, LocalDateTime horaEntrada, LocalDateTime horaSaida) {
        this.id = id;
        this.veiculo = veiculo;
        this.estabelecimento = estabelecimento;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public EntradaEstacionamento(Long id, Veiculo veiculo, Estabelecimento estabelecimento, LocalDateTime horaEntrada) {
        this.id = id;
        this.veiculo = veiculo;
        this.estabelecimento = estabelecimento;
        this.horaEntrada = horaEntrada;
    }

    public EntradaEstacionamento(Long id, Veiculo veiculo, Estabelecimento estabelecimento) {
        this.id = id;
        this.veiculo = veiculo;
        this.estabelecimento = estabelecimento;
        this.horaEntrada = horaEntrada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntradaEstacionamento that = (EntradaEstacionamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
}
