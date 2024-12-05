package com.barberconnect.BarberConnect.domain.Interfaces;

public interface IEmailService {
    void SendMail(String receiver, String subject, String body);
}
