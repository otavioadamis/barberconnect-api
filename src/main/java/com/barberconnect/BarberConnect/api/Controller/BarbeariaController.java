package com.barberconnect.BarberConnect.api.Controller;

import com.barberconnect.BarberConnect.domain.Interfaces.IBarbeariaService;
import com.barberconnect.BarberConnect.domain.Interfaces.IServicoService;
import com.barberconnect.BarberConnect.domain.TOs.BarbeariaTOs.Response.BarbeariaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/barbearia")
public class BarbeariaController {
    private final IBarbeariaService _barbeariaService;
    public BarbeariaController(IBarbeariaService barbeariaService){
        _barbeariaService = barbeariaService;
    }

    @GetMapping("/listar-barbearias")
    public ResponseEntity<List<BarbeariaResponseDTO>> listarBarbearias(){
        return ResponseEntity.ok(_barbeariaService.listarBarbearias());
    }
}
