package com.barberconnect.BarberConnect.dao.Repositories;

import com.barberconnect.BarberConnect.domain.Entities.Servico;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ServicoRepository extends JpaRepository<Servico, String> {
    @Nonnull
    Optional<Servico> findById(@Nonnull String id);
}
