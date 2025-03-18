package br.com.alura.Petshop_api.controller;

import br.com.alura.Petshop_api.dto.DadosCadastroTutor;
import br.com.alura.Petshop_api.dto.DadosListagemPet;
import br.com.alura.Petshop_api.dto.DadosTutorAtualizado;
import br.com.alura.Petshop_api.service.TutorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/tutor")
public class TutorController {
    @Autowired
    private TutorService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroTutor(@RequestBody DadosCadastroTutor dadosCadastroTutor, UriComponentsBuilder uriComponentsBuilder){
        return service.cadastro(dadosCadastroTutor,uriComponentsBuilder);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarTutorPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPorId(@PathVariable Long id){
        return service.deletarPorId(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarTutorPorId(@PathVariable Long id, @RequestBody DadosTutorAtualizado dadosTutorAtualizado){
        return service.atualizar(id,dadosTutorAtualizado);
    }




}
