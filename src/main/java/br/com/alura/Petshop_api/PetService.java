package br.com.alura.Petshop_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PetService {
    @Autowired
    private PetRepository repository;

    public ResponseEntity cadastro(DadosCadastroPet dadosCadastroPet, UriComponentsBuilder uriComponentsBuilder) {
        var pet = new Pet(dadosCadastroPet);
        var uri = uriComponentsBuilder.path("/pet/{id}").buildAndExpand(dadosCadastroPet.id()).toUri();
        repository.save(pet);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPet(pet));
    }
}
