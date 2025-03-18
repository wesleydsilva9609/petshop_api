package br.com.alura.Petshop_api.service;

import br.com.alura.Petshop_api.dto.DadosCadastroTutor;
import br.com.alura.Petshop_api.dto.DadosDetalhamentoTutor;
import br.com.alura.Petshop_api.dto.DadosTutorAtualizado;
import br.com.alura.Petshop_api.entity.Tutor;
import br.com.alura.Petshop_api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Pageable;

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

    public ResponseEntity deletarPorId(Long id) {
        tutorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity atualizar(Long id, DadosTutorAtualizado dadosTutorAtualizado) {
        var tutor = tutorRepository.getReferenceById(id);
        tutor.atualizar(dadosTutorAtualizado);
        return ResponseEntity.ok(new DadosDetalhamentoTutor(tutor));
    }
}
