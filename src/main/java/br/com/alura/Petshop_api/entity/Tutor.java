package br.com.alura.Petshop_api.entity;

import br.com.alura.Petshop_api.controller.DadosCadastroTutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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
}
