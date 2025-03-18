package br.com.alura.Petshop_api.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPet(Long id, String nome, String especie, @NotBlank String rga, String cor) {
}
