package br.com.alura.Petshop_api.controller;

import br.com.alura.Petshop_api.dto.DadosCadastroTutor;
import br.com.alura.Petshop_api.service.TutorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity cadastroTutor(@RequestBody DadosCadastroTutor dadosCadastroTutor, UriComponentsBuilder uriComponentsBuilder){
        return service.cadastro(dadosCadastroTutor,uriComponentsBuilder);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarTutorPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }


}
