package br.com.alura.Petshop_api.entity;

import br.com.alura.Petshop_api.dto.DadosCadastroPet;
import br.com.alura.Petshop_api.dto.DadosPetAtualizado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Pet")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String especie;
    private String rga;
    private String cor;


    public Pet(DadosCadastroPet dadosCadastroPet) {
        this.id = dadosCadastroPet.id();
        this.nome  = dadosCadastroPet.nome();
        this.especie = dadosCadastroPet.especie();
        this.rga = dadosCadastroPet.rga();
        this.cor = dadosCadastroPet.cor();
    }

    public void atualizar(DadosPetAtualizado dadosPetAtualizado) {
        if(dadosPetAtualizado.nome() != null){
            this.nome = dadosPetAtualizado.nome();
        }if(dadosPetAtualizado.especie() != null){
            this.especie = dadosPetAtualizado.especie();
        }
        if(dadosPetAtualizado.rga() != null){
            this.rga = dadosPetAtualizado.rga();
        }if(dadosPetAtualizado.cor() != null){
            this.cor = dadosPetAtualizado.cor();
        }
    }
}
