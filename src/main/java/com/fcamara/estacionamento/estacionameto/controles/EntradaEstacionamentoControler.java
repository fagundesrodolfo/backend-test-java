package com.fcamara.estacionamento.estacionameto.controles;

import com.fcamara.estacionamento.estacionameto.controles.dtos.EntradaEstacionamentoDTO;
import com.fcamara.estacionamento.estacionameto.controles.forms.EntradaEstacionamentoForm;
import com.fcamara.estacionamento.estacionameto.modelos.EntradaEstacionamento;
import com.fcamara.estacionamento.estacionameto.repositorios.EntradaEstacionamentoRepository;
import com.fcamara.estacionamento.estacionameto.repositorios.EstabelecimentoRepository;
import com.fcamara.estacionamento.estacionameto.repositorios.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entrada")
public class EntradaEstacionamentoControler {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private EntradaEstacionamentoRepository entradaEstacionamentoRepository;


    @GetMapping
    public ResponseEntity<List<EntradaEstacionamentoDTO>> listaEntradaEstacionameto() {

        List<EntradaEstacionamento> entradas = entradaEstacionamentoRepository.findAll();

        return ResponseEntity.ok(
                entradas
                        .stream()
                        .map(EntradaEstacionamentoDTO::new)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<EntradaEstacionamentoDTO> buscaEntradaEstacionameto(@PathVariable Long id) {
        Optional<EntradaEstacionamento> optional = entradaEstacionamentoRepository.findById(id);
        return optional
                .map(entradaEstacionamento ->
                        ResponseEntity.ok(new EntradaEstacionamentoDTO(entradaEstacionamento)))
                .orElseGet(() ->
                        ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletaEntradaEstacionameto(@PathVariable Long id) {
        Optional<EntradaEstacionamento> optional = entradaEstacionamentoRepository.findById(id);
        if (optional.isPresent()) {
            estabelecimentoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EntradaEstacionamentoDTO> cadastraEntradaEstacionameto(@RequestBody @Valid EntradaEstacionamentoForm form) {

        Optional<EntradaEstacionamento> entrada = form.getEntradaEstabelecimento(estabelecimentoRepository, veiculoRepository);

        if (entrada.isPresent()) {

            entradaEstacionamentoRepository.save(entrada.get());
        }

        return ResponseEntity.ok().body(new EntradaEstacionamentoDTO(entrada.get()));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<EntradaEstacionamentoDTO> atualizaEntradaEstacionameto(@RequestBody @Valid EntradaEstacionamentoForm form) {

        Optional<EntradaEstacionamento> optionalForm = entradaEstacionamentoRepository.findById(form.getId());

        if (optionalForm.isPresent()) {
            Optional<EntradaEstacionamento> entrada = form.getEntradaEstabelecimento(estabelecimentoRepository,veiculoRepository);

            entradaEstacionamentoRepository.save(entrada.get());

            return ResponseEntity.ok().body(new EntradaEstacionamentoDTO(entrada.get()));
        }

        return ResponseEntity.notFound().build();
    }

}
