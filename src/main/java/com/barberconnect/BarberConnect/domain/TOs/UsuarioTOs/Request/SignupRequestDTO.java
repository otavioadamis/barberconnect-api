package com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Request;

public record SignupRequestDTO(
        String nome,
        String email,
        String senha,
        String contato
) {
}
