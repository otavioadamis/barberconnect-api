package com.barberconnect.BarberConnect.domain.Interfaces;

import com.barberconnect.BarberConnect.domain.TOs.GerenteTOs.Request.CreateFuncionarioRequest;

public interface IGerenteService {
    void CadastrarFuncionario(CreateFuncionarioRequest novoFuncionario);
}
