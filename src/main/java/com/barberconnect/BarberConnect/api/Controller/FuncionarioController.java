package com.barberconnect.BarberConnect.api.Controller;

import com.barberconnect.BarberConnect.domain.Interfaces.IFuncionarioService;
import com.barberconnect.BarberConnect.domain.TOs.FuncionarioTOs.Response.FuncionarioResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

    private final IFuncionarioService _funcionarioService;
    public FuncionarioController(IFuncionarioService funcionarioService){
        _funcionarioService = funcionarioService;
    }
    @GetMapping("/{barbeariaId}")
    public ResponseEntity<List<FuncionarioResponseDTO>> getAllFuncionariosByBarbeariaId(@PathVariable String barbeariaId){
        return ResponseEntity.ok(_funcionarioService.listarFuncionariosByBarbeariaId(barbeariaId));
    }
}
