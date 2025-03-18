package br.com.alura.Petshop_api.dto.tutor;

import br.com.alura.Petshop_api.entity.Tutor;

public record DadosDetalhamentoTutor(Long id, String nome, String telefone, String cpf, String email) {

    public DadosDetalhamentoTutor(Tutor tutor){
        this(tutor.getId(),tutor.getNome(),tutor.getTelefone(), tutor.getCpf(), tutor.getEmail());
    }
}
