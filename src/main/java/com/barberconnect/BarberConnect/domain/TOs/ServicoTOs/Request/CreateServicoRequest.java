package com.barberconnect.BarberConnect.domain.TOs.ServicoTOs.Request;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

public record CreateServicoRequest(
        String nome,
        String descricao,
        BigDecimal valor,
        int tempoMedioMin,
        String barbeariaId,
        Set<String> funcionariosIds
) {
}
