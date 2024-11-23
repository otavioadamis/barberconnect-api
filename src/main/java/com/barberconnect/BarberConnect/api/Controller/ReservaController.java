package com.barberconnect.BarberConnect.api.Controller;

import com.barberconnect.BarberConnect.domain.Entities.Reserva;
import com.barberconnect.BarberConnect.domain.Interfaces.IReservaService;
import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Request.CreateReservaRequest;
import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Response.ReservaResponse;
import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Response.ReservasOcupadasResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {
    private final IReservaService _reservaService;

    public ReservaController(IReservaService reservaService) {
        _reservaService = reservaService;
    }

    @PostMapping("/criar-reserva")
    public ResponseEntity<ReservaResponse> criarNovaReserva(@RequestBody @Valid CreateReservaRequest novaReserva){
        ReservaResponse response = _reservaService.CriarReserva(novaReserva);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{funcionarioId}/{dia}")
    public ResponseEntity<List<ReservasOcupadasResponse>> getAllReservasFromFuncionarioInDay(@PathVariable String funcionarioId,
                                                                                             @PathVariable LocalDate dia){
        List<ReservasOcupadasResponse> horarios = _reservaService.getHorariosReservadosByFuncionarioIdAndDia(dia, funcionarioId);
        return ResponseEntity.ok(horarios);
    }
}
