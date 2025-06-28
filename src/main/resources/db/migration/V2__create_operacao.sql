CREATE TABLE operacao (
    id IDENTITY PRIMARY KEY,
    data_inicio DATE,
    data_emissao DATE,
    data_fim DATE,
    data_primeira_parcela DATE,
    quantidade_parcelas INT,
    tempo_carencia INT,
    valor_operacao DECIMAL(10,2),
    taxa_mensal DECIMAL(5,2),
    pessoa_id BIGINT,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa_fisica(id)
);
