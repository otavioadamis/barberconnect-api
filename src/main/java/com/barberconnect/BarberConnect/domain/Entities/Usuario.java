package com.barberconnect.BarberConnect.domain.Entities;

import com.barberconnect.BarberConnect.domain.Enums.Role;
import com.barberconnect.BarberConnect.domain.TOs.GerenteTOs.Request.CreateFuncionarioRequest;
import com.barberconnect.BarberConnect.domain.TOs.UsuarioTOs.Request.SignupRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Table(name="usuario")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String email;
    private String senha;
    private String contato;
    @CreationTimestamp
    private Date criadoEm;
    @Enumerated(EnumType.STRING)
    private Role tipo = Role.ROLE_CLIENTE;
    @OneToOne
    @JoinColumn(name = "barbearia_id")
    private Barbearia barbearia;

    public Usuario(SignupRequestDTO novoUsuario, String encodedPassword){
        nome = novoUsuario.nome();
        email = novoUsuario.email();
        senha = encodedPassword;
        contato = novoUsuario.contato();
    }

    public Usuario(CreateFuncionarioRequest novoUsuario, String encodedPassword, Barbearia barbearia){
        nome = novoUsuario.nome();
        email = novoUsuario.email();
        senha = encodedPassword;
        contato = novoUsuario.contato();
        this.barbearia = barbearia;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(tipo.name()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
