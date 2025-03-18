package br.com.alura.Petshop_api;

public record DadosListagemPet(Long id, String nome, String especie, String rga, String cor) {

    public DadosListagemPet(Pet pet){
        this(pet.getId(), pet.getNome(), pet.getEspecie(), pet.getRga(), pet.getCor());
    }
}
