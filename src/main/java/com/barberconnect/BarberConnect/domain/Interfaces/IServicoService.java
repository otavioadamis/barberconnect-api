package com.barberconnect.BarberConnect.domain.Interfaces;

import com.barberconnect.BarberConnect.domain.TOs.ServicoTOs.Response.ServicoResponseDTO;

import java.util.List;

public interface IServicoService {
    List<ServicoResponseDTO> listarServicosByFuncionarioId(String funcionarioId);
    List<ServicoResponseDTO> listarServicosByBarbeariaId(String barbeariaId);
}
