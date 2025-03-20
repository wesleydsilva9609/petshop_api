package br.com.alura.Petshop_api.entity.validacoes;

import br.com.alura.Petshop_api.exceptions.ValidacaoException;
import br.com.alura.Petshop_api.dto.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

@Component
public class ValidadorHorarioDeFuncionamento implements ValidadorAgendaDeConsultas {

    @Override
    public void validar(DadosAgendamentoConsulta agendamentoConsulta) {
        var horarioAbertura = agendamentoConsulta.data().getHour() < 7;
        var horarioFechamento = agendamentoConsulta.data().getHour() > 19;

        if(horarioAbertura || horarioFechamento){
            throw new ValidacaoException("agendamento fora de horario de funcionamento");
        }
    }
}
