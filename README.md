# 📘 Agroforte API

### 💼 Projeto proposto no teste Java Pleno - Agroforte

Este projeto consiste em uma API RESTful para cadastro de **pessoa física** e simulação de **operações financeiras** com geração automática de **parcelas**, considerando taxa mensal e tempo de carência. Desenvolvido em Java com Spring Boot, seguindo uma arquitetura limpa e escalável.

---

## 🚀 Como rodar localmente

### ✅ Pré-requisitos:
- Java 17+
- Maven
- IDE (IntelliJ, VS Code, etc.)

### ▶️ Passos:

```bash
git clone https://github.com/seuusuario/agroforte-api.git
cd agroforte-api
./mvnw spring-boot:run
```

> A aplicação estará rodando em:  
> `http://localhost:8080`

---

## 📚 Documentação Swagger

Abra no navegador:

```
http://localhost:8080/swagger-ui.html
```

---

## 🧪 Testes via Swagger

### 1. Cadastrar pessoa física
`POST /pessoas/fisica`
```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "cpf": "123.456.789-00",
  "rg": "MG-1234567",
  "celular": "31999999999",
  "estadoCivil": "Casado",
  "genero": "Masculino",
  "dataNascimento": "1985-01-01",
  "nomeMae": "Maria",
  "nacionalidade": "Brasileira"
}
```

### 2. Cadastrar operação
`POST /operacoes`
```json
{
  "pessoaId": 1,
  "dataInicio": "2025-07-01",
  "dataEmissao": "2025-06-30",
  "dataFim": "2026-06-30",
  "quantidadeParcelas": 6,
  "tempoCarencia": 1,
  "valorOperacao": 12000.00,
  "taxaMensal": 1.5
}
```

---

## 🗂️ Estrutura do Projeto

```
com.agroforte
├── api
│   ├── controller        # Endpoints REST
│   └── dto               # Entrada/saída via API
├── application
│   └── usecase           # Casos de uso (Clean Architecture)
├── domain
│   ├── model             # Entidades JPA
│   ├── repository        # Interfaces JPA
│   └── service           # Regras de negócio puras (ex: cálculo financeiro)
├── config                # Swagger, exceptions etc.
└── AgroforteApiApplication.java
```

---

## 🧠 Regras implementadas

- ✅ Cadastro de Pessoa Física
- ✅ Cadastro de Operação
- ✅ Cálculo de parcelas baseado em:
  - Valor total
  - Taxa mensal
  - Número de parcelas
  - Tempo de carência (em meses)
- ✅ Armazenamento das parcelas geradas

---

## ⚙️ Banco de dados

- H2 em memória (`jdbc:h2:mem:agroforte`)
- Migrations com Flyway (`resources/db/migration`)
- Acesso ao console:  
  `http://localhost:8080/h2-console`  
  → JDBC: `jdbc:h2:mem:agroforte`  
  → Usuário: `sa` (sem senha)

---

## 📦 Tecnologias utilizadas

| Tecnologia        | Finalidade                        |
|-------------------|------------------------------------|
| Java 17           | Linguagem principal                |
| Spring Boot       | Framework principal da API         |
| Spring Web        | Criação de REST APIs               |
| Spring Data JPA   | ORM e persistência                 |
| H2 Database       | Banco em memória para testes       |
| Flyway            | Controle de versão do banco        |
| Lombok            | Redução de boilerplate             |
| Swagger/OpenAPI   | Documentação da API                |

---

## ✨ Diferenciais

- Arquitetura orientada a **casos de uso (`usecase`)**
- Separação clara de responsabilidades (API, domínio, aplicação)
- Cálculo financeiro centralizado no serviço `CalculoFinanceiroService`
- Preparado para futura adição de **Pessoa Jurídica**
- Fácil de testar, manter e escalar
