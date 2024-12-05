package com.barberconnect.BarberConnect.services;

import com.barberconnect.BarberConnect.dao.Repositories.BarbeariaRepository;
import com.barberconnect.BarberConnect.dao.Repositories.UsuarioRepository;
import com.barberconnect.BarberConnect.domain.Entities.Barbearia;
import com.barberconnect.BarberConnect.domain.Entities.Usuario;
import com.barberconnect.BarberConnect.domain.Interfaces.IEmailService;
import com.barberconnect.BarberConnect.domain.Interfaces.IGerenteService;
import com.barberconnect.BarberConnect.domain.TOs.GerenteTOs.Request.CreateFuncionarioRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class GerenteService implements IGerenteService {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?";
    private final PasswordEncoder _passwordEncoder;
    private final UsuarioRepository _usuarioRepo;
    private final BarbeariaRepository _barbeariaRepo;
    private final IEmailService _emailService;
    public GerenteService(BarbeariaRepository barbeariaRepository,
                          UsuarioRepository usuarioRepository,
                          PasswordEncoder passwordEncoder,
                          IEmailService emailService)
    {
        _barbeariaRepo = barbeariaRepository;
        _usuarioRepo = usuarioRepository;
        _passwordEncoder = passwordEncoder;
        _emailService = emailService;
    }

    @Override
    public void CadastrarFuncionario(CreateFuncionarioRequest novoFuncionario){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUserEmail = authentication.getName();
        Usuario gerenteLogado = (Usuario) _usuarioRepo.findByEmail(loggedInUserEmail);

        String barbeariaId = gerenteLogado.getBarbearia().getId();

        Barbearia barbearia = _barbeariaRepo.findById(barbeariaId)
                        .orElseThrow(() -> new IllegalArgumentException("Barbearia não encontrada, verifique os dados."));

        SalvarFuncionario(novoFuncionario, barbearia);
    }

    private void SalvarFuncionario(CreateFuncionarioRequest novoUsuario, Barbearia barbearia){
        UserDetails checkEmail = _usuarioRepo.findByEmail(novoUsuario.email());
        if(checkEmail != null) {
            throw new IllegalArgumentException("Este email já está cadastrado no sistema.");
        }

        String randomPassword = generateRandom10CharPassword();

        String body = "Olá, " + novoUsuario.nome() + " voce foi cadastrado por um gerente," +
                " sua senha de acesso é: " + randomPassword;

        _emailService.SendMail(novoUsuario.email(), "Bem vindo! ", body);

        String encryptedPassword = _passwordEncoder.encode(randomPassword);

        Usuario usuario = new Usuario(novoUsuario, encryptedPassword, barbearia);

        _usuarioRepo.save(usuario);
    }

    private static String generateRandom10CharPassword() {
        return IntStream.range(0, 10)
                .map(i -> RANDOM.nextInt(CHARACTERS.length()))
                .mapToObj(CHARACTERS::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
