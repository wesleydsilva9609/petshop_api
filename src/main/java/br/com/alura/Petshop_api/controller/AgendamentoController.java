package br.com.alura.Petshop_api.controller;

import br.com.alura.Petshop_api.dto.consulta.DadosCancelamentoConsulta;
import br.com.alura.Petshop_api.dto.consulta.DadosAgendamentoConsulta;
import br.com.alura.Petshop_api.service.AgendamentoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
    @Autowired
    private AgendamentoService service;

    @PostMapping
    @Transactional
    public ResponseEntity agendarConsulta(@Valid @RequestBody DadosAgendamentoConsulta agendamentoConsulta , UriComponentsBuilder uriComponentsBuilder){
        return service.agendar(agendamentoConsulta,uriComponentsBuilder);
    }

    @DeleteMapping("/cancelamento")
    @Transactional
    public ResponseEntity cancelarConsulta(@RequestBody DadosCancelamentoConsulta dadosCancelamentoConsulta){
        return service.cancelar(dadosCancelamentoConsulta);
    }


}
