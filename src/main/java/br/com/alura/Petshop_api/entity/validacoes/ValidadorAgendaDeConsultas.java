package br.com.alura.Petshop_api.entity.validacoes;

import br.com.alura.Petshop_api.dto.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendaDeConsultas {
    void validar(DadosAgendamentoConsulta agendamentoConsulta);
}
