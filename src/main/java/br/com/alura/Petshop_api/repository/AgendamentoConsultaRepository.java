package br.com.alura.Petshop_api.repository;

import br.com.alura.Petshop_api.entity.AgendamentoConsulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AgendamentoConsultaRepository extends JpaRepository<AgendamentoConsulta,Long> {
    

    boolean existsByLocalDateTime(LocalDateTime dataConsulta);

    boolean existsByLocalDateTimeBetween(LocalDateTime dataConsulta, LocalDateTime fim);
}
