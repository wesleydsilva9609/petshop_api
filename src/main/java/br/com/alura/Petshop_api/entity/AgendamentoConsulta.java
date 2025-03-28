package br.com.alura.Petshop_api.entity;

import br.com.alura.Petshop_api.dto.consulta.DadosCancelamentoConsulta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentoConsulta")
@Getter
@NoArgsConstructor
public class AgendamentoConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;
    private LocalDateTime localDateTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "motivo_cancelamento")
    private Cancelamento motivo;

    public AgendamentoConsulta(Long id, Pet pet, Tutor tutor, LocalDateTime localDateTime) {
        this.id = id;
        this.pet = pet;
        this.tutor = tutor;
        this.localDateTime = localDateTime;
    }


    public void cancelar(DadosCancelamentoConsulta dadosCancelamentoConsulta) {
        this.motivo = dadosCancelamentoConsulta.motivo();
    }
}
