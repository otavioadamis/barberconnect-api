package com.barberconnect.BarberConnect.domain.Interfaces;

import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Request.CreateReservaRequest;
import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Response.ReservaResponse;

public interface IReservaService {
    ReservaResponse CriarReserva(CreateReservaRequest novaReserva);
}
