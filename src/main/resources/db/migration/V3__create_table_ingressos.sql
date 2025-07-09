CREATE TABLE ingressos (
    id SERIAL PRIMARY KEY,
    nome_ingresso VARCHAR(50) NOT NULL,
    disponivel BOOLEAN NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    evento_id INTEGER NOT NULL,
    CONSTRAINT fk_evento
      FOREIGN KEY(evento_id)
      REFERENCES eventos(id)
      ON DELETE CASCADE
);
