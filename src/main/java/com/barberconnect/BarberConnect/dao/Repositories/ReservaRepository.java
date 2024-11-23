package com.barberconnect.BarberConnect.dao.Repositories;

import com.barberconnect.BarberConnect.domain.Entities.Reserva;
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
}
