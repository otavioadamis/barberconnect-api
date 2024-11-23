package com.barberconnect.BarberConnect.domain.Entities;

import com.barberconnect.BarberConnect.domain.TOs.ServicoTOs.Request.CreateServicoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Table(name="servico")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String descricao;
    private int tempoMedio;
    private BigDecimal preco;
    @ManyToMany
    @JoinTable(name = "funcionario_servico",
                joinColumns = @JoinColumn(name = "servico_id"),
                inverseJoinColumns = @JoinColumn(name = "funcionario_id"))
    private Set<Usuario> funcionarios;
    @ManyToOne
    @JoinColumn(name = "barbearia_id")
    private Barbearia barbearia;

    public Servico(CreateServicoRequest novoServico, Set<Usuario> funcionarios){
        nome = novoServico.nome();
        descricao = novoServico.descricao();
        tempoMedio = novoServico.tempoMedioMin();
        preco = novoServico.valor();
        this.funcionarios.addAll(funcionarios);
    }
}
