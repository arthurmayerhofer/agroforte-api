CREATE TABLE parcela (
    id IDENTITY PRIMARY KEY,
    data_vencimento DATE,
    valor DECIMAL(10,2),
    paga BOOLEAN,
    operacao_id BIGINT,
    FOREIGN KEY (operacao_id) REFERENCES operacao(id)
);
