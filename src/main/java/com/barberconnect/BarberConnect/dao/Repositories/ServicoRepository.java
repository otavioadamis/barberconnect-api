package com.barberconnect.BarberConnect.dao.Repositories;

import com.barberconnect.BarberConnect.domain.Entities.Servico;
import com.barberconnect.BarberConnect.domain.TOs.ServicoTOs.Response.ServicoResponseDTO;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ServicoRepository extends JpaRepository<Servico, String> {
    @Nonnull
    Optional<Servico> findById(@Nonnull String id);

    @Query(
            value = "SELECT s.id as servicoId, " +
                    "s.nome as nomeServico, " +
                    "s.descricao as descricaoServico, " +
                    "s.tempo_medio as tempoMedioMin, " +
                    "s.preco as precoServico " +
                    "FROM servico s " +
                    "WHERE s.barbearia_id = :barbeariaId",
            nativeQuery = true
    )
    List<ServicoResponseDTO> findAllServicosByBarbeariaId(@Param("barbeariaId") String barbeariaId);
    @Query(
            value = "SELECT s.id as servicoId, " +
                    "s.nome as nomeServico, " +
                    "s.descricao as descricaoServico, " +
                    "s.tempo_medio as tempoMedioMin, " +
                    "s.preco as precoServico " +
                    "FROM servico s " +
                    "JOIN funcionario_servico fs ON s.id = fs.servico_id " +
                    "WHERE fs.funcionario_id = :funcionarioId",
            nativeQuery = true
    )
    List<ServicoResponseDTO> findAllServicosByFuncionarioId(@Param("funcionarioId") String funcionarioId);
}
