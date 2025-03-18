package br.com.alura.Petshop_api.entity;

import br.com.alura.Petshop_api.dto.DadosCadastroTutor;
import br.com.alura.Petshop_api.dto.DadosTutorAtualizado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tutor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    private String email;


    public Tutor(DadosCadastroTutor dadosCadastroTutor) {
        this.id = dadosCadastroTutor.id();
        this.nome = dadosCadastroTutor.nome();
        this.telefone = dadosCadastroTutor.telefone();
        this.cpf = dadosCadastroTutor.cpf();
        this.email = dadosCadastroTutor.email();
    }

    public void atualizar(DadosTutorAtualizado dadosTutorAtualizado) {
        if(dadosTutorAtualizado.nome() != null){
            this.nome = dadosTutorAtualizado.nome();
        }
        if(dadosTutorAtualizado.cpf() != null){
            this.cpf = dadosTutorAtualizado.cpf();
        }
        if(dadosTutorAtualizado.telefone() != null){
            this.telefone = dadosTutorAtualizado.telefone();
        }
        if(dadosTutorAtualizado.email() != null){
            this.email = dadosTutorAtualizado.email();
        }
    }
}
