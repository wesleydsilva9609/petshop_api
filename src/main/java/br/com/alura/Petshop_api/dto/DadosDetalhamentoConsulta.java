package br.com.alura.Petshop_api.dto;

import br.com.alura.Petshop_api.entity.AgendamentoConsulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id, Long petId, Long tutorId, LocalDateTime dateTime){
    public DadosDetalhamentoConsulta(AgendamentoConsulta consulta){
        this(consulta.getId(), consulta.getPet().getId(),consulta.getTutor().getId(),consulta.getLocalDateTime());
    }
}
