package com.barberconnect.BarberConnect.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;

@Component
public class DatabaseInit {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() throws IOException, SQLException {
        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM barbearia", Long.class);
        if (count == 0) {
            jdbcTemplate.execute(
                    "COPY barbearia(id, nome, bairro, rua, numero) " +
                            "FROM '/data/barbearia_v2.csv' DELIMITER ',' CSV HEADER;"
            );
            jdbcTemplate.execute(
                    "COPY usuario(id, nome, email, senha, contato, criado_em, tipo) " +
                            "FROM '/data/usuario_v2.csv' DELIMITER ',' CSV HEADER;"
            );
            jdbcTemplate.execute(
                    "COPY servico(id, nome, descricao, tempo_medio, preco, barbearia_id) " +
                            "FROM '/data/servico_v2.csv' DELIMITER ',' CSV HEADER;"
            );
            jdbcTemplate.execute(
                    "COPY funcionario_barbearia(barbearia_id, funcionario_id) " +
                            "FROM '/data/funcionario_barbearia_v2.csv' DELIMITER ',' CSV HEADER;"
            );
            jdbcTemplate.execute(
                    "COPY funcionario_servico(servico_id, funcionario_id) " +
                            "FROM '/data/funcionario_servico_v2.csv' DELIMITER ',' CSV HEADER;"
            );
        }
    }
}
