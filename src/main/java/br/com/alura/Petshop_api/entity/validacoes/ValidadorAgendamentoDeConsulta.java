package br.com.alura.Petshop_api.entity.validacoes;

import br.com.alura.Petshop_api.exceptions.ValidacaoException;
import br.com.alura.Petshop_api.dto.consulta.DadosAgendamentoConsulta;
import br.com.alura.Petshop_api.repository.AgendamentoConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAgendamentoDeConsulta implements ValidadorAgendaDeConsultas {
    @Autowired
    private AgendamentoConsultaRepository repository;

    @Override
    public void validar(DadosAgendamentoConsulta agendamentoConsulta) {
        var consultaInicio = agendamentoConsulta.data();
        var consultaFim = consultaInicio.plusHours(1);
        boolean consulta = repository.existsByLocalDateTimeBetween(consultaInicio,consultaFim);
        if(consulta){
            throw new ValidacaoException("ja existe consulta no horario agendado");
        }

    }
}
