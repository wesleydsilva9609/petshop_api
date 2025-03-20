package br.com.alura.Petshop_api.dto.consulta;

import br.com.alura.Petshop_api.entity.Cancelamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(@NotNull Long consultaId,@NotBlank Cancelamento motivo) {
}
