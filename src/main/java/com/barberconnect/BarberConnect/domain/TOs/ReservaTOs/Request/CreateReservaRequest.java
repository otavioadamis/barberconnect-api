package com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Request;

import java.util.Date;

public record CreateReservaRequest (
        String servicoId,
        String funcionarioId,
        Date diaHorario
) {
}
