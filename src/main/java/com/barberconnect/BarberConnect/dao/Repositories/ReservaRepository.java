package com.barberconnect.BarberConnect.dao.Repositories;

import com.barberconnect.BarberConnect.domain.Entities.Reserva;
import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Response.ReservaCard;
import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Response.ReservaResponse;
import com.barberconnect.BarberConnect.domain.TOs.ReservaTOs.Response.ReservasOcupadasResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, String> {

    @Query(value =
                    "SELECT r.data_hora as diaHorario " +
                    "FROM RESERVA r " +
                    "WHERE r.funcionario_id = :funcionarioId " +
                    "AND r.data_hora >= :startDate AND r.data_hora <= :endDate ",
            nativeQuery = true)
    List<ReservasOcupadasResponse> findReservasByFuncIdAndDia(@Param("funcionarioId") String funcionarioId, LocalDate startDate, LocalDate endDate);

    @Query(
            value = """
        SELECT r.id as reservaId,
               f.nome as funcionarioNome,
               s.nome as servicoNome,
               r.data_hora as diaHorario
        FROM reserva r
        JOIN usuario f ON r.funcionario_id = f.id
        JOIN servico s ON r.servico_id = s.id
        WHERE r.cliente_id = :userId
        ORDER BY r.data_hora DESC
        """,
            nativeQuery = true
    )
    List<ReservaCard> findAllReservasUser(@Param("userId") String userId);
}
