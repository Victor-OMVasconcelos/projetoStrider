-- Criação do banco de dados
CREATE DATABASE strider_db;

-- Usar o banco de dados criado
USE strider_db;

-- Criação da tabela 'amigo'
CREATE TABLE amigo (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Chave primária
    nome VARCHAR(100) NOT NULL,        -- Nome do amigo, obrigatório
    telefone VARCHAR(15) NOT NULL,    -- Telefone do amigo, obrigatório
    item VARCHAR(50) DEFAULT NULL     -- Item relacionado ao amigo, opcional
);

-- Criação da tabela 'ferramenta'
CREATE TABLE ferramenta (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Chave primária
    nome VARCHAR(100) NOT NULL,        -- Nome da ferramenta, obrigatório
    marca VARCHAR(50) DEFAULT NULL,   -- Marca da ferramenta, opcional
    preco DECIMAL(10,2) DEFAULT NULL  -- Preço da ferramenta, opcional
);

-- Criação da tabela 'emprestimo'
CREATE TABLE emprestimo (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Chave primária
    ferramenta_id INT NOT NULL,        -- ID da ferramenta (chave estrangeira)
    amigo_id INT NOT NULL,             -- ID do amigo (chave estrangeira)
    data_emprestimo DATE NOT NULL,     -- Data do empréstimo, obrigatório
    data_devolucao DATE DEFAULT NULL,  -- Data de devolução, opcional
    FOREIGN KEY (ferramenta_id) REFERENCES ferramenta(id), -- Relacionamento com ferramenta
    FOREIGN KEY (amigo_id) REFERENCES amigo(id)            -- Relacionamento com amigo
);
