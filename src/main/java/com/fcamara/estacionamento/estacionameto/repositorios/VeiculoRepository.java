package com.fcamara.estacionamento.estacionameto.repositorios;


import com.fcamara.estacionamento.estacionameto.modelos.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
