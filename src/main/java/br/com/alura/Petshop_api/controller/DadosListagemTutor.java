package br.com.alura.Petshop_api.controller;

import br.com.alura.Petshop_api.entity.Tutor;

public record DadosListagemTutor(Long id, String nome, String telefone, String cpf, String email) {

    public DadosListagemTutor(Tutor tutor){
        this(tutor.getId(), tutor.getNome(), tutor.getTelefone(), tutor.getCpf(), tutor.getEmail());
    }
}
