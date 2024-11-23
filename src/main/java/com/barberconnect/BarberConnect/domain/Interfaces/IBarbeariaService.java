package com.barberconnect.BarberConnect.domain.Interfaces;

import com.barberconnect.BarberConnect.domain.TOs.BarbeariaTOs.Response.BarbeariaResponseDTO;

import java.util.List;

public interface IBarbeariaService {
    List<BarbeariaResponseDTO> listarBarbearias();
}
