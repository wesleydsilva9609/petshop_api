package br.com.alura.Petshop_api;

public record DadosDetalhamentoPet(Long id, String nome, String especie, String rga, String cor) {

    public DadosDetalhamentoPet(Pet pet){
        this(pet.getId(), pet.getNome(), pet.getEspecie(), pet.getRga(), pet.getCor());
    }
}
