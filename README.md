# Avaliação Backend Attornatus

### Tecnologias Utilizadas
- Java
- Spring Boot
- API Rest
- Testes

### O Desafio

Usar o Spring Boot para criar uma API simples para o gerenciamento de pessoas. Permitindo as seguintes operações:

- Criar uma pessoa
- Editar uma pessoa
- Consulte uma pessoa
- Listar pessoas
- Criar o endereço de uma pessoa
- Listar os endereços de uma pessoa
- Ser capaz de informar o endereço principal de uma pessoa

### Requisitos 

- Todas as respostas da API devem ser JSON  
- Banco de dados H2

### Os Endpoints da API

#### Entidade Pessoa
- POST -> /users
- PUT -> /users/{id}
- GET -> /users/{id}
- GET -> /users
- DELETE -> /users/{id}

#### Entidade Endereço
- POST -> /adress
- PUT -> /adress/{id}
- GET -> /adress/{id}
- GET -> /adress
- DELETE -> /adress/{id}

#### Dependências utilizadas:

```sh
java - vesão 17
```
```sh
spring-boot-starter-data-jpa
```
```sh
pring-boot-starter-web
```
```sh
spring-boot-devtools
```
```sh
h2
```
```sh
spring-boot-starter-test
```
```sh
log4j
```
```sh
junit-jupiter-api
```
```sh
lombok
```
