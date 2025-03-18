package br.com.alura.Petshop_api.dto.pet;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPet(Long id, @NotBlank String nome,@NotBlank String especie,@NotBlank String rga,@NotBlank String cor) {
}
