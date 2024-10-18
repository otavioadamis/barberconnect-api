package com.barberconnect.BarberConnect.domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Table(name="reserva")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Usuario funcionario;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente; //Pode ser nulo (ou seja, horario disponível)
    @OneToMany
    @JoinColumn(name = "servico_id")
    private Set<Servico> servico; //Pode ser nulo (ou seja, horario disponível)
    private Date dataHora;
}
