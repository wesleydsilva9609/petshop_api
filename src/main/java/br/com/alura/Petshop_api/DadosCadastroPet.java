package br.com.alura.Petshop_api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPet(Long id, String nome, String especie, @NotBlank String rga, String cor) {
}
