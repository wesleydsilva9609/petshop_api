package br.com.alura.Petshop_api.entity;

import br.com.alura.Petshop_api.dto.tutor.DadosCadastroTutor;
import br.com.alura.Petshop_api.dto.tutor.DadosTutorAtualizado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tutor", uniqueConstraints = {
        @UniqueConstraint(name = "uk_email_cpf", columnNames = { "email", "cpf" })
})
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    @Column(unique = true,nullable = false)
    private String cpf;
    @Column(unique = true,nullable = false)
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
