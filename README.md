# API de Gestão de Horários Acadêmicos - UniSales
Sistema web Back-End desenvolvido em Java com o framework Spring Boot para a organização e gerenciamento de horários de aula de professores, disciplinas e turmas.

Este projeto foi desenvolvido como Demonstração de Competência (Projeto de Website - Back-End) no Centro Universitário Salesiano (UniSales).


## Alunos
- Gabriel Oliveira Ramos

## Tecnologias Utilizadas
- `Java 17`
- `Spring Boot 3.3.4`
- `Spring Web (Arquitetura MVC / API RESTful)`
- `Spring Data JPA / Hibernate (Persistência de dados com ORM)`
- `H2 Database (Banco de dados relacional persistido em arquivo local ./data/horarios_db)`
- `Jakarta Bean Validation (Validação de dados de entrada nos formulários JSON)`
- `Spring Security (Camada de proteção com Autenticação Básica - HTTP Basic Auth e criptografia BCrypt)`
- `Springdoc OpenAPI 3 / Swagger UI (Documentação interativa e interface de testes da API)`
- `Apache Maven (Gerenciamento de dependências e build)`


## Arquitetura do Projeto (MVC)

O código-fonte foi organizado aplicando boas práticas de Engenharia de Software, separação de responsabilidades e padronização em camadas:

br.com.unisales.horarios
config/       # Configurações de Segurança (Basic Auth), Swagger, Carga Inicial e Tratamento Global de Erros

controller/   # Controladores REST (Endpoints da API e documentação OpenAPI)

dto/          # Objetos de Transferência de Dados para requisições e consultas consolidadas

model/        # Entidades JPA/ORM (Professor, Disciplina, Turma, Horario) e validações

repository/   # Interfaces Spring Data JPA para comunicação com o banco de dados

service/      # Regras de negócio e orquestração das operações CRUD e filtros

## Funcionalidades implementadas
- Cadastro de Gerentes (nome, salário base e departamento);
- Cadastro de Caixas (nome, salário base e turno de trabalho);
- Listagem geral de funcionários cadastrados no banco de dados;
- Cálculo automático polimórfico de bonificação e salário final por cargo;
- Cálculo do total da folha de pagamento da empresa;
- Exclusão de funcionários do banco de dados por ID;
- Criação automática da tabela `funcionarios` no banco de dados local (`empresa.db`).


## Acesso ao Swagger UI e Autenticação

Como o sistema atua exclusivamente no Back-End, toda a interação, cadastros e visualizações são realizados pela interface interativa do Swagger UI:
- URL do Swagger UI: http://localhost:8080/swagger-ui.html

Credenciais de Autenticação Básica (Basic Auth)
Ao abrir o Swagger UI, clique no botão verde Authorize no canto superior direito e informe:

-Username: admin

-Password: 123456

## Endpoints Principais da API

1. Professores (/api/professores)

Método Endpoint Descrição

GET   /api/professores Lista todos os professores cadastrados

GET /api/professores/{id} Busca um professor específico pelo ID

POST /api/professores Cadastra um novo professor (com validação de nome, e-mail e titulação)

PUT /api/professores/{id} Atualiza os dados de um professor existente

DELETE /api/professores/{id} Exclui um professor pelo ID

2. Disciplinas (/api/disciplinas)

Método Endpoint Descrição

GET /api/disciplinas Lista todas as disciplinas cadastradas

GET /api/disciplinas/{id} Busca uma disciplina específica pelo ID

POST /api/disciplinas Cadastra uma nova disciplina (carga horária mínima de 20h)

PUT /api/disciplinas/{id} Atualiza os dados de uma disciplina existente

DELETE /api/disciplinas/{id} Exclui uma disciplina pelo ID

3. Turmas (/api/turmas)

Método Endpoint Descrição

GET /api/turmas Lista todas as turmas cadastradas

GET /api/turmas/{id} Busca uma turma específica pelo ID

POST /api/turmas Cadastra uma nova turma (código, curso e semestre)

PUT /api/turmas/{id} Atualiza os dados de uma turma existente

DELETE /api/turmas/{id} Exclui uma turma pelo ID


4. Horários e Consultas Especiais (/api/horarios)

Método Endpoint Descrição

GET /api/horarios Lista todos os horários de aula cadastrados

POST /api/horarios Cadastra um novo horário associando Professor, Disciplina e Turma

PUT /api/horarios/{id} Atualiza um horário de aula existente

DELETE /api/horarios/{id} Exclui um horário de aula

GET /api/horarios/professor/{professorId} Consulta por Professor: Exibe disciplinas ministradas, turmas associadas, dias, horários e salas

GET /api/horarios/turma/{turmaId} Consulta por Turma: Exibe professores responsáveis, disciplinas oferecidas, dias, horários e salas

## Como Executar o Projeto
```bash
Pré-requisitos
JDK 17 (ou superior) instalado
VS Code (com Extension Pack for Java) ou qualquer IDE Java de sua preferência
Passo a passo
1. Clone este repositório:
git clone https://github.com/gabrielramos-06/gestao-horarios.git
2. Abra a pasta gestao-horarios no VS Code.
3. Execute a classe principal GestaoHorariosApplication.java clicando em Run (ou via terminal integrado com mvn spring-boot:run).
4. O sistema irá inicializar automaticamente na porta 8080 e populará o banco de dados local com registros de exemplo na primeira execução.


