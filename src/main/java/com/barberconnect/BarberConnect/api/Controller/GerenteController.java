package com.barberconnect.BarberConnect.api.Controller;

import com.barberconnect.BarberConnect.domain.Interfaces.IGerenteService;
import com.barberconnect.BarberConnect.domain.TOs.GerenteTOs.Request.CreateFuncionarioRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gerente")
public class GerenteController {

    private final IGerenteService _gerenteService;
    public GerenteController(IGerenteService gerenteService){
        _gerenteService = gerenteService;
    }

    @PostMapping("/cadastrar-funcionario")
    public ResponseEntity<String> cadastrarFuncionario(@RequestBody @Valid CreateFuncionarioRequest novoFuncionario){
        _gerenteService.CadastrarFuncionario(novoFuncionario);
        return ResponseEntity.ok("Um email foi enviado ao funcionário.");
    }
}
