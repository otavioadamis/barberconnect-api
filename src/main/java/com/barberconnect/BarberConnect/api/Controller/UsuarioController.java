package com.barberconnect.BarberConnect.api.Controller;

import com.barberconnect.BarberConnect.domain.Interfaces.IUsuarioService;
import com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Request.LoginRequestDTO;
import com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Request.SignupRequestDTO;
import com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Response.LoginResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final IUsuarioService _usuarioService;
    public UsuarioController(IUsuarioService usuarioService){
        _usuarioService = usuarioService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<LoginResponseDTO> cadastrar(@RequestBody @Valid SignupRequestDTO novoUsuario){
        LoginResponseDTO response = _usuarioService.cadastrarUsuario(novoUsuario);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO loginRequest){
        LoginResponseDTO response = _usuarioService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}
