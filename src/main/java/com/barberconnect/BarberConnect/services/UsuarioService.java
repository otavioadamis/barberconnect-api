package com.barberconnect.BarberConnect.services;

import com.barberconnect.BarberConnect.dao.Repositories.UsuarioRepository;
import com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Request.LoginRequestDTO;
import com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Request.SignupRequestDTO;
import com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Response.LoginResponseDTO;
import com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Response.UsuarioDTO;
import com.barberconnect.BarberConnect.domain.Entities.Usuario;
import com.barberconnect.BarberConnect.domain.Interfaces.IUsuarioService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository _usuarioRepo;
    private final PasswordEncoder _passwordEncoder;
    private final AuthenticationService _authService;
    private final AuthenticationManager _authManager;
    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationService authenticationService,
            AuthenticationManager authenticationManager
    )
    {
        _usuarioRepo = usuarioRepository;
        _passwordEncoder = passwordEncoder;
        _authService = authenticationService;
        _authManager = authenticationManager;
    }

    @Override
    public LoginResponseDTO cadastrarUsuario(SignupRequestDTO novoUsuario) {
        UserDetails checkEmail = _usuarioRepo.findByEmail(novoUsuario.email());
        if(checkEmail != null) {
            throw new IllegalArgumentException("Este email já está cadastrado no sistema.");
        }

        String encryptedPassword = _passwordEncoder.encode(novoUsuario.senha());
        Usuario usuario = new Usuario(novoUsuario, encryptedPassword);

        _usuarioRepo.save(usuario);
        String authToken = _authService.createToken(usuario);

        UsuarioDTO usuarioResponse = new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getContato()
        );
        return new LoginResponseDTO(
                authToken,
                usuarioResponse
        );
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequest){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequest.email(),
                loginRequest.senha()
        );
        Authentication auth = _authManager.authenticate(authenticationToken);
        Usuario usuario = (Usuario) auth.getPrincipal();

        String authToken = _authService.createToken(usuario);

        UsuarioDTO usuarioResponse = new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getContato()
        );
        return new LoginResponseDTO(
                authToken,
                usuarioResponse
        );
    }
}
