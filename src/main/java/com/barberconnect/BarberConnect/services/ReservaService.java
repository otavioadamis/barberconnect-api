package com.barberconnect.BarberConnect.services;

import com.barberconnect.BarberConnect.dao.Repositories.ReservaRepository;
import com.barberconnect.BarberConnect.dao.Repositories.ServicoRepository;
import com.barberconnect.BarberConnect.dao.Repositories.UsuarioRepository;
import com.barberconnect.BarberConnect.domain.Entities.Reserva;
import com.barberconnect.BarberConnect.domain.Entities.Servico;
import com.barberconnect.BarberConnect.domain.Entities.Usuario;
import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Request.CreateReservaRequest;
import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Response.ReservaResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaService {
    private final ReservaRepository _reservaRepo;
    private final UsuarioRepository _userRepo;
    private final ServicoRepository _servicoRepo;
    public ReservaService(UsuarioRepository usuarioRepository, ServicoRepository servicoRepository, ReservaRepository reservaRepository) {
        _userRepo = usuarioRepository;
        _servicoRepo = servicoRepository;
        _reservaRepo = reservaRepository;
    }

    public ReservaResponse CriarReserva(CreateReservaRequest novaReserva){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();

        Usuario funcionarioEscolhido = _userRepo.findById(novaReserva.funcionarioId())
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado"));

        Servico servicoEscolhido = _servicoRepo.findById(novaReserva.servicoId())
                .orElseThrow(() -> new IllegalArgumentException("Servico não encontrado"));

        Reserva reserva = new Reserva(
                novaReserva,
                usuarioLogado,
                funcionarioEscolhido,
                servicoEscolhido
        );
        _reservaRepo.save(reserva);
        return new ReservaResponse(
                reserva.getId(),
                funcionarioEscolhido.getNome(),
                servicoEscolhido.getNome(),
                reserva.getDataHora()
        );
    }
}
