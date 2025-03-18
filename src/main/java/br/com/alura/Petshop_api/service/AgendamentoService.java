package br.com.alura.Petshop_api.service;

import br.com.alura.Petshop_api.dto.DadosAgendamentoConsulta;
import br.com.alura.Petshop_api.dto.DadosDetalhamentoConsulta;
import br.com.alura.Petshop_api.entity.AgendamentoConsulta;
import br.com.alura.Petshop_api.repository.AgendamentoConsultaRepository;
import br.com.alura.Petshop_api.repository.PetRepository;
import br.com.alura.Petshop_api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoConsultaRepository agendamentoConsultaRepository;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private TutorRepository tutorRepository;


    public ResponseEntity agendar(DadosAgendamentoConsulta agendamentoConsulta, UriComponentsBuilder uriComponentsBuilder) {
        var tutor = tutorRepository.getReferenceById(agendamentoConsulta.tutorId());
        var pet = petRepository.getReferenceById(agendamentoConsulta.petId());
        var consulta = new AgendamentoConsulta(null,pet,tutor,agendamentoConsulta.data());
        var uri = uriComponentsBuilder.path("/agendamento/{id}").buildAndExpand(agendamentoConsulta).toUri();
        agendamentoConsultaRepository.save(consulta);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoConsulta(consulta));
    }
}
