# Todo List API

API REST para gerenciamento de tarefas desenvolvida com Spring Boot.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.0
- Spring Data JPA
- Spring Validation
- PostgreSQL
- H2 Database (para ambiente de desenvolvimento/testes)
- Lombok
- Springdoc OpenAPI (Swagger)

## Funcionalidades

- Criar tarefas
- Listar todas as tarefas (ordenadas por prioridade e título)
- Buscar tarefa por ID
- Atualizar tarefas
- Excluir tarefas

## Estrutura do Projeto

O projeto segue a arquitetura em camadas:

- **Controller**: Gerencia as requisições HTTP
- **Service**: Contém a lógica de negócios
- **Repository**: Responsável pela persistência de dados
- **Entity**: Define o modelo de dados

## Endpoints

| Método | URL | Descrição |
|--------|-----|-----------|
| POST | `/api/tasks` | Cria uma nova tarefa |
| GET | `/api/tasks` | Lista todas as tarefas |
| GET | `/api/tasks/{id}` | Busca uma tarefa pelo ID |
| PUT | `/api/tasks/{id}` | Atualiza uma tarefa existente |
| DELETE | `/api/tasks/{id}` | Remove uma tarefa |

## Modelo de Dados

As tarefas possuem os seguintes atributos:
- `id`: Identificador único (gerado automaticamente)
- `title`: Título da tarefa (obrigatório)
- `description`: Descrição da tarefa (obrigatório)
- `completed`: Status de conclusão da tarefa (true/false)
- `priority`: Prioridade da tarefa

## Pré-requisitos

- JDK 21
- Maven
- PostgreSQL (para ambiente de produção)

## Configuração e Execução

1. Clone o repositório:
   ```
   git clone https://github.com/pedroleonez/todo-list-spring.git
   cd todo-list-spring
   ```

2. Configure o banco de dados no arquivo `application.properties` (o projeto já vem configurado com H2 para desenvolvimento)

3. Compile e execute o projeto:
   ```
   mvn spring-boot:run
   ```

4. Acesse a documentação da API:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

## Documentação

A documentação completa da API está disponível através do Swagger UI, que pode ser acessado após iniciar a aplicação.

## CORS

A aplicação está configurada para aceitar requisições de `http://localhost:4200`, o que permite a integração com uma aplicação frontend Angular. Para adicionar outros domínios permitidos, edite a classe `CorsConfig`.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).
