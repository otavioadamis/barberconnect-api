package com.barberconnect.BarberConnect.dao.Repositories;

import com.barberconnect.BarberConnect.domain.Entities.Usuario;
import com.barberconnect.BarberConnect.domain.TOs.FuncionarioTOs.Response.FuncionarioResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Usuario, String> {

    @Query(
            value = "SELECT f.id AS funcionarioId, " +
                    "f.nome AS funcionarioNome " +
                    "FROM usuario f " +
                    "WHERE f.barbearia_id = :barbeariaId and f.tipo = 'ROLE_FUNCIONARIO'",
            nativeQuery = true
    )
    List<FuncionarioResponseDTO> getAllByBarbeariaId(@Param("barbeariaId") String barbeariaId);
}
