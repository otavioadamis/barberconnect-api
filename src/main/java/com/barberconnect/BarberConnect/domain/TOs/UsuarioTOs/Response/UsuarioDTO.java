package com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Response;

import com.barberconnect.BarberConnect.domain.Enums.Role;

public record UsuarioDTO(
        String id,
        String nome,
        String email,
        String contato,
        Role tipo
) {
}
