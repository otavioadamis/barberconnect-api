package com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Response;

import java.util.Date;

public record ReservaResponse(
        String reservaId,
        String funcionarioNome,
        String servicoNome,
        Date diaHorario
) {
}
