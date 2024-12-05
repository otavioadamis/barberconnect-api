ALTER TABLE usuario
ADD COLUMN barbearia_id VARCHAR(255) NULL;

ALTER TABLE usuario
ADD CONSTRAINT fk_barbearia
FOREIGN KEY (barbearia_id) REFERENCES barbearia(id);

DROP TABLE funcionario_barbearia;