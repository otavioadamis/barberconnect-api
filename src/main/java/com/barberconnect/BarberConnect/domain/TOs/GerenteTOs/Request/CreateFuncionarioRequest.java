package com.barberconnect.BarberConnect.domain.TOs.GerenteTOs.Request;

public record CreateFuncionarioRequest(
    String nome,
    String email,
    String contato
) {

}
