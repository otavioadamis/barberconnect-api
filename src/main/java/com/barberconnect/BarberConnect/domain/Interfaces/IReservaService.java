package com.barberconnect.BarberConnect.domain.Interfaces;

import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Request.CreateReservaRequest;
import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Response.ReservaCard;
import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Response.ReservaResponse;
import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Response.ReservasOcupadasResponse;

import java.time.LocalDate;
import java.util.List;

public interface IReservaService {
    ReservaResponse CriarReserva(CreateReservaRequest novaReserva);
    List<ReservasOcupadasResponse> getHorariosReservadosByFuncionarioIdAndDia(LocalDate dia, String funcionarioId);
    List<ReservaCard> listarReservas();
}
