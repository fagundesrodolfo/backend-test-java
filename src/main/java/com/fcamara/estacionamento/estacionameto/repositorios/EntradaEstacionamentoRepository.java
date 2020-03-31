package com.fcamara.estacionamento.estacionameto.repositorios;

import com.fcamara.estacionamento.estacionameto.modelos.EntradaEstacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaEstacionamentoRepository  extends JpaRepository<EntradaEstacionamento, Long> {
}
