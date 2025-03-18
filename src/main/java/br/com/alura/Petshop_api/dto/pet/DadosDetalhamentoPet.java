package br.com.alura.Petshop_api.dto.pet;

import br.com.alura.Petshop_api.entity.Pet;

public record DadosDetalhamentoPet(Long id, String nome, String especie, String rga, String cor) {

    public DadosDetalhamentoPet(Pet pet){
        this(pet.getId(), pet.getNome(), pet.getEspecie(), pet.getRga(), pet.getCor());
    }
}
