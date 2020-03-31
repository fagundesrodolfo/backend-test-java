package com.fcamara.estacionamento.estacionameto.controles;


import com.fcamara.estacionamento.estacionameto.controles.dtos.VeiculoDTO;
import com.fcamara.estacionamento.estacionameto.controles.forms.VeiculoForm;
import com.fcamara.estacionamento.estacionameto.modelos.Veiculo;
import com.fcamara.estacionamento.estacionameto.repositorios.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/veiculos")
public class VeiculosControler {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> listaVeiculos() {

        List<Veiculo> estabelecimentos = veiculoRepository.findAll();

        return ResponseEntity.ok(
                estabelecimentos
                        .stream()
                        .map(VeiculoDTO::new)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<VeiculoDTO> buscaVeiculos(@PathVariable Long id) {
        Optional<Veiculo> optional = veiculoRepository.findById(id);
        return optional
                .map(estabelecimento ->
                        ResponseEntity.ok(new VeiculoDTO(estabelecimento)))
                .orElseGet(() ->
                        ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletaVeiculo(@PathVariable Long id) {
        Optional<Veiculo> optional = veiculoRepository.findById(id);
        if (optional.isPresent()) {
            veiculoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<VeiculoDTO> cadastraVeiculo(@RequestBody @Valid VeiculoForm form, UriComponentsBuilder uriBuilder) {

        Veiculo veiculo = form.getVeiculo();

        veiculoRepository.save(veiculo);

        return ResponseEntity.ok().body(new VeiculoDTO(veiculo));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<VeiculoDTO> atualizaVeiculo(@RequestBody @Valid VeiculoForm form) {

        Optional<Veiculo> optional = veiculoRepository.findById(form.getId());

        if (optional.isPresent()) {
            Veiculo estabelecimento = form.getVeiculo();

            veiculoRepository.save(estabelecimento);

            return ResponseEntity.ok().body(new VeiculoDTO(estabelecimento));
        }

        return ResponseEntity.notFound().build();
    }

}
