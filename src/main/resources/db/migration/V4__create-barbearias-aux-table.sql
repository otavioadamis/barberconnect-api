CREATE TABLE barbearia (
        id VARCHAR(255) DEFAULT gen_random_uuid() PRIMARY KEY,
        nome VARCHAR(255) NOT NULL,
        bairro VARCHAR(255) NOT NULL,
        rua VARCHAR(255) NOT NULL,
        numero INTEGER NOT NULL
);

CREATE TABLE funcionario_barbearia (
        barbearia_id VARCHAR(255) NOT NULL,
        funcionario_id VARCHAR(255) NOT NULL,
        CONSTRAINT fk_barbearia FOREIGN KEY (barbearia_id) REFERENCES barbearia(id),
        CONSTRAINT fk_funcionario FOREIGN KEY (funcionario_id) REFERENCES usuario(id)
);

ALTER TABLE servico
ADD COLUMN barbearia_id VARCHAR(255);

ALTER TABLE servico
ADD CONSTRAINT fk_barbearia
FOREIGN KEY (barbearia_id) REFERENCES barbearia(id);