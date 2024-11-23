package com.barberconnect.BarberConnect.dao.Repositories;

import com.barberconnect.BarberConnect.domain.Entities.Barbearia;
import com.barberconnect.BarberConnect.domain.TOs.BarbeariaTOs.Response.BarbeariaResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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
}
