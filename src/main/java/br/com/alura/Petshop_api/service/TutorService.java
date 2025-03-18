package br.com.alura.Petshop_api.service;

import br.com.alura.Petshop_api.dto.DadosCadastroTutor;
import br.com.alura.Petshop_api.dto.DadosDetalhamentoTutor;
import br.com.alura.Petshop_api.entity.Tutor;
import br.com.alura.Petshop_api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TutorService {
    @Autowired
    private TutorRepository tutorRepository;


    public ResponseEntity cadastro(DadosCadastroTutor dadosCadastroTutor, UriComponentsBuilder uriComponentsBuilder) {
        var tutor = new Tutor(dadosCadastroTutor);
        var uri = uriComponentsBuilder.path("/tutor/{id}").buildAndExpand(dadosCadastroTutor.id()).toUri();
        tutorRepository.save(tutor);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTutor(tutor));
    }

    public ResponseEntity buscarPorId(Long id) {
        var tutor = tutorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTutor(tutor));
    }
}
