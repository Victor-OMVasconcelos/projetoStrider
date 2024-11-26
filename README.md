# projetoStrider

## Contribuidores
Victor Oliveira m=Morais de Vasconcelos - RA 162311849

João Vitor Ferraz de Camargo - RA

Cauan da Silva do Santos - RA

## Informações do banco de dados
Login do BD: root ('root'@'localhost)

Senha do BD: root

Pode ser modificado na classe ConexaoBd, encontrado no package DAO.

## Requisitos funcionais

### Cadastro de Ferramentas
Permitir o registro de ferramentas com os campos: nome, marca e custo de aquisição.
    
Permitir edição e exclusão de ferramentas cadastradas.

### Cadastro de Amigos
Permitir o registro de amigos com os campos: nome e telefone.
 
Permitir edição e exclusão de amigos cadastrados.

### Gerenciamento de Empréstimos
Permitir o registro de empréstimos, vinculando um ou mais itens a um amigo, com as datas de empréstimo e devolução.

Indicar se o amigo tem ferramentas não devolvidas no momento de um novo empréstimo.

Permitir a atualização do registro de devoluções.

### Relatórios
Relatório de ferramentas, incluindo o custo total gasto.

Relatório de empréstimos ativos (ainda não devolvidos).

Relatório de todos os empréstimos realizados, com indicação do amigo que mais emprestou e aqueles que nunca devolveram ferramentas.

### Persistência Local
Salvar todos os dados (ferramentas, amigos e empréstimos) localmente, para que sejam preservados ao fechar o aplicativo.


