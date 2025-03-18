package br.com.alura.Petshop_api.dto;

import br.com.alura.Petshop_api.entity.AgendamentoConsulta;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(Long id, @NotNull Long petId,@NotNull Long tutorId, @Future LocalDateTime data) {

    public DadosAgendamentoConsulta(AgendamentoConsulta agendamentoConsulta){
        this(agendamentoConsulta.getId(),
                agendamentoConsulta.getPet().getId(),
                agendamentoConsulta.getTutor().getId(),agendamentoConsulta.getLocalDateTime());
    }
}
