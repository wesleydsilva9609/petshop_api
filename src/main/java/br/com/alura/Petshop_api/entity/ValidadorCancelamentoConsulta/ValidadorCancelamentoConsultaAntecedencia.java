package br.com.alura.Petshop_api.entity.ValidadorCancelamentoConsulta;

import br.com.alura.Petshop_api.dto.consulta.DadosCancelamentoConsulta;
import br.com.alura.Petshop_api.infra.exceptions.ValidacaoException;
import br.com.alura.Petshop_api.repository.AgendamentoConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorCancelamentoConsultaAntecedencia implements ValidadorCancelamentoConsulta {
    @Autowired
    private AgendamentoConsultaRepository repository;

    @Override
    public void validador(DadosCancelamentoConsulta dadosCancelamentoConsulta) {
        var consulta = repository.getReferenceById(dadosCancelamentoConsulta.consultaId()).getLocalDateTime();
        var agora = LocalDateTime.now();
        var antecedencia = Duration.between(agora,consulta).toHours();

        if(antecedencia < 24){
            throw new ValidacaoException("consulta so pode ser cancelada com no minimo 24h de antecedencia");
        }
    }
}
