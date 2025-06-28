CREATE TABLE pessoa_fisica (
    id IDENTITY PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100),
    cpf VARCHAR(20),
    rg VARCHAR(20),
    celular VARCHAR(20),
    estado_civil VARCHAR(20),
    genero VARCHAR(20),
    data_nascimento DATE,
    nome_mae VARCHAR(100),
    nacionalidade VARCHAR(50)
);
