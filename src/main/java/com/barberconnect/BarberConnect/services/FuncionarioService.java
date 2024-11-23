package com.barberconnect.BarberConnect.services;

import com.barberconnect.BarberConnect.dao.Repositories.FuncionarioRepository;
import com.barberconnect.BarberConnect.domain.Interfaces.IFuncionarioService;
import com.barberconnect.BarberConnect.domain.TOs.FuncionarioTOs.Response.FuncionarioResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService implements IFuncionarioService {

    private final FuncionarioRepository _funcionarioRepository;
    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        _funcionarioRepository = funcionarioRepository;
    }
    public List<FuncionarioResponseDTO> listarFuncionariosByBarbeariaId(String barbeariaId){
        return _funcionarioRepository.getAllByBarbeariaId(barbeariaId);
    }
}
