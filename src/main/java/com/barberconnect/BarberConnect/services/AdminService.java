package com.barberconnect.BarberConnect.services;

import com.barberconnect.BarberConnect.dao.Repositories.BarbeariaRepository;
import com.barberconnect.BarberConnect.domain.Entities.Barbearia;
import com.barberconnect.BarberConnect.domain.Entities.Usuario;
import com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Request.SignupRequestDTO;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdminService {
    private final UsuarioService _usuarioService;
    private final BarbeariaRepository _barbeariaRepo;
    public AdminService(UsuarioService usuarioService, BarbeariaRepository barbeariaRepository){
        _usuarioService = usuarioService;
        _barbeariaRepo = barbeariaRepository;
    }

    public void CadastrarFuncionario(SignupRequestDTO novoFuncionario, String barbeariaId){
        Usuario funcionario = _usuarioService.SalvarUsuario(novoFuncionario);
        Barbearia barbearia = _barbeariaRepo.findById(barbeariaId)
                        .orElseThrow(() -> new IllegalArgumentException("Barbearia não encontrada, verifique os dados."));
        barbearia.getFuncionarios().add(funcionario);
        _barbeariaRepo.save(barbearia);
    }
}
