package com.barberconnect.BarberConnect.domain.Interfaces;

import com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Request.LoginRequestDTO;
import com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Request.SignupRequestDTO;
import com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Response.LoginResponseDTO;

public interface IUsuarioService {
    LoginResponseDTO cadastrarUsuario(SignupRequestDTO novoUsuario);
    LoginResponseDTO login(LoginRequestDTO loginRequest);
}
