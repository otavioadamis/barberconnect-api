package com.barberconnect.BarberConnect.domain.Entities;

import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Request.CreateReservaRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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
    private Usuario cliente;
    @OneToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime dataHora;

    public Reserva(CreateReservaRequest novaReserva, Usuario usuarioLogado, Usuario funcionarioEscolhido, Servico servicoEscolhido) {
        funcionario = funcionarioEscolhido;
        cliente = usuarioLogado;
        servico = servicoEscolhido;
        dataHora = novaReserva.diaHorario();
    }
}
