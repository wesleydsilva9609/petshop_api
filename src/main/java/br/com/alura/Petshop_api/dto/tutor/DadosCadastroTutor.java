package br.com.alura.Petshop_api.dto.tutor;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroTutor(Long id, String nome, String telefone, @CPF String cpf, @Email String email) {
}
