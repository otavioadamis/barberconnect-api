package com.barberconnect.BarberConnect.api.Controller;

import com.barberconnect.BarberConnect.domain.Interfaces.IServicoService;
import com.barberconnect.BarberConnect.domain.TOs.ServicoTOs.Response.ServicoResponseDTO;
import com.barberconnect.BarberConnect.services.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {

    private final IServicoService _servicoService;

    public ServicoController(IServicoService servicoService){
        _servicoService = servicoService;
    }

    public ResponseEntity<List<ServicoResponseDTO>> listarServicosByFuncionarioId(@PathVariable String funcionarioId){
        List<ServicoResponseDTO> response = _servicoService.listarServicosByFuncionarioId(funcionarioId);
        return ResponseEntity.ok(response);
    }
}
