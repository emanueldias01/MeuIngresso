CREATE TABLE eventos (
    id SERIAL PRIMARY KEY,
    nome_evento VARCHAR(255) UNIQUE NOT NULL,
    data DATE NOT NULL,
    local VARCHAR(255) NOT NULL,
    descricao TEXT,
    imagem VARCHAR(350),
    setores TEXT[]
);


