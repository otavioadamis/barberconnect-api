package com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public interface ReservaCard {
    String getReservaId();
    String getFuncionarioNome();
    String getServicoNome();
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    LocalDateTime getDiaHorario();
}
