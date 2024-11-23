package com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record CreateReservaRequest (
        String servicoId,
        String funcionarioId,
        @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
        LocalDateTime diaHorario
) {
}
