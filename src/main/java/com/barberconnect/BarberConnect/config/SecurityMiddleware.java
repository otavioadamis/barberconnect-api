package com.barberconnect.BarberConnect.config;

import com.barberconnect.BarberConnect.dao.Repositories.UsuarioRepository;
import com.barberconnect.BarberConnect.domain.Entities.Usuario;
import com.barberconnect.BarberConnect.domain.Interfaces.IAuthenticationService;
import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class SecurityMiddleware extends OncePerRequestFilter {
    private final IAuthenticationService _authService;
    private final UsuarioRepository _usuarioRepo;
    public SecurityMiddleware(IAuthenticationService authenticationService, UsuarioRepository usuarioRepository){
        _authService = authenticationService;
        _usuarioRepo = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response, @Nonnull FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if(token != null){
            String id = _authService.validateToken(token);
            Optional<Usuario> usuario = _usuarioRepo.findById(id);
            if(usuario.isPresent()){
                UserDetails userDetails = usuario.get();
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }
}
