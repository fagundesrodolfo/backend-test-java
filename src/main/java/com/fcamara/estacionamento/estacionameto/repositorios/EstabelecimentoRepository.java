package com.fcamara.estacionamento.estacionameto.repositorios;

import com.fcamara.estacionamento.estacionameto.modelos.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
}
