package com.barberconnect.BarberConnect.domain.TOs.ServicoTOs.Response;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface ServicoResponseDTO {
    String getServicoId();
    String getNomeServico();
    String getDescricaoServico();
    BigInteger getTempoMedioMin();
    BigDecimal getPrecoServico();
}
