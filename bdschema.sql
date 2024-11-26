-- Cria o schema strider_bd
CREATE SCHEMA IF NOT EXISTS strider_bd;
USE strider_bd;

-- Cria a tabela amigo
CREATE TABLE amigo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(15),
    item VARCHAR(100),
    data_emprestimo DATE
);

-- Cria a tabela ferramenta
CREATE TABLE ferramenta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_ferramenta VARCHAR(100) NOT NULL,
    marca VARCHAR(50),
    preco DOUBLE
);

-- Cria a tabela emprestimo
CREATE TABLE emprestimo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ferramenta_id INT NOT NULL,
    amigo_id INT NOT NULL,
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE,
    CONSTRAINT fk_ferramenta FOREIGN KEY (ferramenta_id) REFERENCES ferramenta (id),
    CONSTRAINT fk_amigo FOREIGN KEY (amigo_id) REFERENCES amigo (id)
);

-- Cria a tabela relatorio
CREATE TABLE relatorio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_amigo INT NOT NULL,
    nome_amigo VARCHAR(100) NOT NULL,
    quantidade_itens INT NOT NULL,
    data_emprestimo DATE,
    data_devolucao DATE,
    CONSTRAINT fk_relatorio_amigo FOREIGN KEY (id_amigo) REFERENCES amigo (id)
);
