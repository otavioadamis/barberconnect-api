package com.barberconnect.BarberConnect.domain.Interfaces;

import com.barberconnect.BarberConnect.domain.Entities.Usuario;

public interface IAuthenticationService {
    String createToken(Usuario usuario);
    String validateToken(String token);
}
