package com.barberconnect.BarberConnect.api.Controller;

import com.barberconnect.BarberConnect.domain.Interfaces.IReservaService;
import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Request.CreateReservaRequest;
import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Response.ReservaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {
    private final IReservaService _reservaService;

    public ReservaController(IReservaService reservaService) {
        _reservaService = reservaService;
    }

    @PostMapping("/criar-reserva")
    public ResponseEntity<ReservaResponse> criarNovaReserva(CreateReservaRequest novaReserva){
        ReservaResponse response = _reservaService.CriarReserva(novaReserva);
        return ResponseEntity.ok(response);
    }
}
