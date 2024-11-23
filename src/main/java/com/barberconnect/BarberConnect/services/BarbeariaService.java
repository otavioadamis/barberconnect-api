package com.barberconnect.BarberConnect.services;

import com.barberconnect.BarberConnect.dao.Repositories.BarbeariaRepository;
import com.barberconnect.BarberConnect.domain.Interfaces.IBarbeariaService;
import com.barberconnect.BarberConnect.domain.TOs.BarbeariaTOs.Response.BarbeariaResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeariaService implements IBarbeariaService {
    private final BarbeariaRepository _barbeariaRepo;
    public BarbeariaService(BarbeariaRepository barbeariaRepository){
        _barbeariaRepo = barbeariaRepository;
    }

    @Override
    public List<BarbeariaResponseDTO> listarBarbearias(){
        return _barbeariaRepo.findAllBarbearias();
    }
}
