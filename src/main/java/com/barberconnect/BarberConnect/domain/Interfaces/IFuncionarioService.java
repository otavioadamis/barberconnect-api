package com.barberconnect.BarberConnect.domain.Interfaces;

import com.barberconnect.BarberConnect.domain.TOs.FuncionarioTOs.Response.FuncionarioResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface IFuncionarioService {
    List<FuncionarioResponseDTO> listarFuncionariosByBarbeariaId(String barbeariaId);
}
