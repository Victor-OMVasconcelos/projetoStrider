# projetoStrider - Sistema Transparente de Registro e Identificação de Dados de Empréstimos e Retornos
O software é uma aplicação local desenvolvida para facilitar o gerenciamento de ferramentas e empréstimos. Ele permite o cadastro de ferramentas e amigos, o registro de empréstimos e devoluções, e a geração de relatórios detalhados sobre os itens emprestados, os custos envolvidos e o histórico de transações.
## Contribuidores

Victor Oliveira Morais de Vasconcelos - RA 162311849

João Vitor Ferraz de Camargo - RA 162312364

Cauan da Silva do Santos - RA 162311667

## Informações do banco de dados

Login do BD: root ('root'@'localhost)

Senha do BD: root

Pode ser modificado na classe ConexaoBd, encontrado no package DAO.

## Requisitos funcionais

### RF01 - Cadastro de Ferramentas
Permitir o registro de ferramentas com os campos: nome, marca e custo de aquisição.
    
Permitir edição e exclusão de ferramentas cadastradas.

### RF02 - Cadastro de Amigos
Permitir o registro de amigos com os campos: nome e telefone.
 
Permitir edição e exclusão de amigos cadastrados.

### RF03 - Gerenciamento de Empréstimos
Permitir o registro de empréstimos, vinculando um ou mais itens a um amigo, com as datas de empréstimo e devolução.

Indicar se o amigo tem ferramentas não devolvidas no momento de um novo empréstimo.

Permitir a atualização do registro de devoluções.

### RF04 - Relatórios
Relatório de ferramentas, incluindo o custo total gasto.

Relatório de empréstimos ativos (ainda não devolvidos).

Relatório de todos os empréstimos realizados, com indicação do amigo que mais emprestou e aqueles que nunca devolveram ferramentas.

### RF05 - Persistência Local
Salvar todos os dados (ferramentas, amigos e empréstimos) localmente, para que sejam preservados ao fechar o aplicativo.

## Requisitos não funcionais

### RNF01 - Plataforma
O software deve rodar localmente no computador do usuário, sem necessidade de conexão com a internet.

### RNF02 - Interface do Usuário
Interface simples e intuitiva.

Uma interface gráfica (GUI) amigável.

### RNF03 - Desempenho
Responder rapidamente às ações do usuário (cadastro, consulta e geração de relatórios).

### RNF04 - Segurança
Evitar a exclusão acidental de dados importantes.

### RNF05 - Compatibilidade
Compatível com o sistema operacional do computador do usuário.

### RNF06 - Simplicidade no Uso
O software deve ser fácil de utilizar, sem necessidade de conhecimento técnico avançado.


