package br.com.alura.Petshop_api.controller;

import br.com.alura.Petshop_api.dto.tutor.DadosCadastroTutor;
import br.com.alura.Petshop_api.dto.tutor.DadosListagemTutor;
import br.com.alura.Petshop_api.dto.tutor.DadosTutorAtualizado;
import br.com.alura.Petshop_api.service.TutorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/tutor")
public class TutorController {
    @Autowired
    private TutorService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroTutor(@Valid @RequestBody DadosCadastroTutor dadosCadastroTutor, UriComponentsBuilder uriComponentsBuilder){
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

    @GetMapping
    public ResponseEntity<Page<DadosListagemTutor>> listarTutor(@PageableDefault(size = 5,sort = "id") Pageable pageable){
        return service.listartutores(pageable);
    }




}
