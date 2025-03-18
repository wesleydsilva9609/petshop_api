package br.com.alura.Petshop_api.controller;

import br.com.alura.Petshop_api.service.TutorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
