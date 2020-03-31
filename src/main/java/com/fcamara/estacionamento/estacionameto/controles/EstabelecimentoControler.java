package com.fcamara.estacionamento.estacionameto.controles;

import com.fcamara.estacionamento.estacionameto.controles.dtos.EstabelecimentoDTO;
import com.fcamara.estacionamento.estacionameto.controles.forms.EstabelecimentoForm;
import com.fcamara.estacionamento.estacionameto.modelos.Estabelecimento;
import com.fcamara.estacionamento.estacionameto.repositorios.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoControler {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @GetMapping
    public ResponseEntity<List<EstabelecimentoDTO>> listaEstabelecimentos() {

        List<Estabelecimento> estabelecimentos = estabelecimentoRepository.findAll();

        return ResponseEntity.ok(
                estabelecimentos
                        .stream()
                        .map(EstabelecimentoDTO::new)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<EstabelecimentoDTO> buscaEstabelecimento(@PathVariable Long id) {
        Optional<Estabelecimento> optional = estabelecimentoRepository.findById(id);
        return optional
                .map(estabelecimento ->
                        ResponseEntity.ok(new EstabelecimentoDTO(estabelecimento)))
                .orElseGet(() ->
                        ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletaEstabelecimento(@PathVariable Long id) {
        Optional<Estabelecimento> optional = estabelecimentoRepository.findById(id);
        if (optional.isPresent()) {
            estabelecimentoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EstabelecimentoDTO> cadastraEstabelecimento(@RequestBody @Valid EstabelecimentoForm form, UriComponentsBuilder uriBuilder) {

        Estabelecimento estabelecimento = form.getEstabelecimento();

        estabelecimentoRepository.save(estabelecimento);

        return ResponseEntity.ok().body(new EstabelecimentoDTO(estabelecimento));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<EstabelecimentoDTO> atualizaEstabelecimento(@RequestBody @Valid EstabelecimentoForm form) {

        Optional<Estabelecimento> optional = estabelecimentoRepository.findById(form.getId());

        if (optional.isPresent()) {
            Estabelecimento estabelecimento = form.getEstabelecimento();

            estabelecimentoRepository.save(estabelecimento);

            return ResponseEntity.ok().body(new EstabelecimentoDTO(estabelecimento));
        }

        return ResponseEntity.notFound().build();
    }

}
