package br.com.alura.Petshop_api.service;

import br.com.alura.Petshop_api.controller.DadosCadastroTutor;
import br.com.alura.Petshop_api.entity.Tutor;
import br.com.alura.Petshop_api.repository.PetRepository;
import br.com.alura.Petshop_api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TutorService {
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private PetRepository petRepository;


    public ResponseEntity cadastro(DadosCadastroTutor dadosCadastroTutor, UriComponentsBuilder uriComponentsBuilder) {
        var tutor = new Tutor(dadosCadastroTutor);
        var uri = uriComponentsBuilder.path("/tutor/{id}").buildAndExpand(dadosCadastroTutor.id()).toUri();
        tutorRepository.save(tutor);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTutor(tutor));
    }
}
