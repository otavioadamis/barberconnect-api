package com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Response;

public record LoginResponseDTO(
        String token,
        UsuarioDTO usuario
) {
}
