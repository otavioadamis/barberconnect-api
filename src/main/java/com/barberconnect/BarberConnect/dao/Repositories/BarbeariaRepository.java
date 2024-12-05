package com.barberconnect.BarberConnect.dao.Repositories;

import com.barberconnect.BarberConnect.domain.Entities.Barbearia;
import com.barberconnect.BarberConnect.domain.TOs.BarbeariaTOs.Response.BarbeariaResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BarbeariaRepository extends JpaRepository<Barbearia, String> {
    @Query(
            value = "SELECT barb.id as idBarbearia, " +
                    "barb.nome as nomeBarbearia, " +
                    "barb.bairro as bairroBarbearia, " +
                    "barb.rua as ruaBarbearia, " +
                    "barb.numero as numeroBarbearia " +
                    "FROM barbearia barb",
            nativeQuery = true
    )
    List<BarbeariaResponseDTO> findAllBarbearias();
    @Query(
            value = "SELECT barb.* " +
                    "FROM barbearia barb " +
                    "JOIN usuario user ON barb.id = user.barbearia_id " +
                    "WHERE user.id = :usuarioId",
            nativeQuery = true
    )
    Optional<Barbearia> findByUsuarioId(@Param("usuarioId") String usuarioId);
}
