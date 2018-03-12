# EICON
pedido
Script de criação da tabela dentro do projeto.

CREATE TABLE pedido (
    codigo_cliente integer NOT NULL,
    nome varchar(255),
    data_cadastro date,
    valor double,
    numero_controle integer primary key,
    quantidade integer,
    total varchar(10)
);
