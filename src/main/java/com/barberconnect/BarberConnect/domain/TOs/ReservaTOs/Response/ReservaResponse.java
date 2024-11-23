package com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;

public record ReservaResponse(
        String reservaId,
        String funcionarioNome,
        String servicoNome,
        @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
        LocalDateTime diaHorario
) {
}
