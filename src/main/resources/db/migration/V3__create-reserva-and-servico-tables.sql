CREATE TABLE servico (
    id VARCHAR(255) DEFAULT gen_random_uuid() PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    tempo_medio INT NOT NULL,
    preco decimal(10,2) NOT NULL
);

CREATE TABLE reserva (
    id VARCHAR(255) DEFAULT gen_random_uuid() PRIMARY KEY,
    funcionario_id VARCHAR(255) NOT NULL,
    cliente_id VARCHAR(255) NULL,
    servico_id VARCHAR(255) NULL,
    data_hora TIMESTAMP NOT NULL,
    CONSTRAINT fk_funcionario FOREIGN KEY (funcionario_id) REFERENCES usuario(id),
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES usuario(id),
    CONSTRAINT fk_servico FOREIGN KEY (servico_id) REFERENCES servico(id)
);

CREATE TABLE funcionario_servico (
    servico_id VARCHAR(255) NOT NULL,
    funcionario_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (servico_id, funcionario_id),
    CONSTRAINT fk_servico FOREIGN KEY (servico_id) REFERENCES servico(id),
    CONSTRAINT fk_funcionario FOREIGN KEY (funcionario_id) REFERENCES usuario(id)
);