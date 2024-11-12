package com.barberconnect.BarberConnect.services;

import com.barberconnect.BarberConnect.dao.Repositories.ServicoRepository;
import com.barberconnect.BarberConnect.domain.Entities.Servico;
import com.barberconnect.BarberConnect.domain.Entities.Usuario;
import com.barberconnect.BarberConnect.domain.Interfaces.IServicoService;
import com.barberconnect.BarberConnect.domain.TOs.ServicoTOs.Request.CreateServicoRequest;
import com.barberconnect.BarberConnect.domain.TOs.ServicoTOs.Response.ServicoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ServicoService implements IServicoService {
    private final ServicoRepository _servicoRepo;
    public ServicoService(ServicoRepository servicoRepository){
        _servicoRepo = servicoRepository;
    }

    public List<ServicoResponseDTO> listarServicosByBarbeariaId(String barbeariaId){
        return _servicoRepo.findAllServicosByBarbeariaId(barbeariaId);
    }

    public List<ServicoResponseDTO> listarServicosByFuncionarioId(String funcionarioId){
        return null;
    }
}
