package com.fcamara.estacionamento.estacionameto.controles.forms;

import com.fcamara.estacionamento.estacionameto.modelos.EntradaEstacionamento;
import com.fcamara.estacionamento.estacionameto.modelos.Estabelecimento;
import com.fcamara.estacionamento.estacionameto.modelos.Veiculo;
import com.fcamara.estacionamento.estacionameto.repositorios.EstabelecimentoRepository;
import com.fcamara.estacionamento.estacionameto.repositorios.VeiculoRepository;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;

public class EntradaEstacionamentoForm {

    private Long id;

    @NotNull
    private Long idVeiculo;

    @NotNull
    private Long idEstabelecimento;

    @NotNull
    private LocalDateTime horaEntrada;

    private LocalDateTime horaSaida;

    public EntradaEstacionamentoForm(Long id, @NotNull Long veiculo, @NotNull Long estabelecimento, @NotNull LocalDateTime horaEntrada, LocalDateTime horaSaida) {
        this.id = id;
        this.idVeiculo = veiculo;
        this.idEstabelecimento = estabelecimento;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Long getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Long idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
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

    public Optional<EntradaEstacionamento> getEntradaEstabelecimento(EstabelecimentoRepository estabelecimentoRepository, VeiculoRepository veiculoRepository) {

        Optional<Veiculo> veiculo = veiculoRepository.findById(getIdVeiculo());

        Optional<Estabelecimento> estabelecimento = estabelecimentoRepository.findById(getIdEstabelecimento());

        Optional<EntradaEstacionamento> retorno = Optional.empty();

        if (veiculo.isPresent() && estabelecimento.isPresent()) {

            retorno = Optional.of(new EntradaEstacionamento(
                            getId(),
                            veiculo.get(),
                            estabelecimento.get(),
                            getHoraEntrada(),
                            getHoraSaida()
                    )
            );
        }

        return retorno;
    }
}
