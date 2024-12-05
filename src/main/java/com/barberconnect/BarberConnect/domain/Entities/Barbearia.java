package com.barberconnect.BarberConnect.domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Set;

@Table(name="barbearia")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Barbearia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String bairro;
    private String rua;
    private BigInteger numero;
}
