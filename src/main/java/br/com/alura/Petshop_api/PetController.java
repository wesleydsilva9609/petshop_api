package br.com.alura.Petshop_api;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroPet(@RequestBody DadosCadastroPet dadosCadastroPet, UriComponentsBuilder uriComponentsBuilder){
        return service.cadastro(dadosCadastroPet,uriComponentsBuilder);
    }
}
