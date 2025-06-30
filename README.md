# 🚀 AgroForte API - Prova de Conceito Java Pleno

API REST desenvolvida em Java (Spring Boot) com persistência em banco relacional e deploy completo via Docker + AWS ECS (Fargate).

---

## 📦 Tecnologias principais

- Java 17 + Spring Boot 3
- Spring Data JPA, Flyway, H2 (dev) / PostgreSQL (prod)
- Docker + Amazon ECS (Fargate)
- Swagger para documentação de API

---

## 🧪 Testar localmente

```bash
# Build e subir localmente
mvn clean package -DskipTests
docker build -t agroforte-api .
docker run -p 8080:8080 agroforte-api
```

Acesse: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🔧 Endpoints principais + Exemplos de Teste

### 📍 POST /api/pessoas/fisicas

```bash
curl -X POST http://3.90.214.127:8080/api/pessoas/fisicas \
-H "Content-Type: application/json" \
-d '{
  "nome": "João Silva",
  "email": "joao@email.com",
  "cpf": "12345678901",
  "rg": "MG1234567",
  "celular": "(31)99999-9999",
  "estadoCivil": "SOLTEIRO",
  "genero": "MASCULINO",
  "dataNascimento": "1990-05-20",
  "nomeMae": "Maria Silva",
  "nacionalidade": "Brasileira"
}'
```

---

### 📍 POST /api/operacoes

```bash
curl -X POST http://3.90.214.127:8080/api/operacoes \
-H "Content-Type: application/json" \
-d '{
  "pessoaFisicaId": 1,
  "dataInicio": "2025-01-01",
  "dataEmissao": "2025-01-01",
  "dataFim": "2025-12-31",
  "quantidadeParcelas": 6,
  "dataPrimeiraParcela": "2025-02-01",
  "tempoCarencia": 1,
  "valorOperacao": 12000.00,
  "taxaMensal": 1.5
}'
```

---

## ☁️ Deploy na AWS (ECS Fargate)

1. Suba a imagem para o ECR:
```bash
docker tag agroforte-api:latest <AWS_ECR_URL>
docker push <AWS_ECR_URL>
```

2. Crie:
   - Task Definition (`agroforte-task`)
   - Cluster (`agroforte-cluster`)
   - Service com IP público e SG porta 8080

3. Acesse:
```
http://<IP-PUBLICO>:8080/swagger-ui.html
```

---

## 🧱 Estrutura de código

```
📦 com.agroforte
├── api          → Controllers e DTOs
├── domain       → Entidades e Repositórios
├── application  → Casos de uso (UseCases)
├── infra        → Serviços e lógica de negócio
└── resources/db/migration → Scripts Flyway
```

---

## 💡 Extras

- Cálculo de parcelas automatizado via `CalculoFinanceiroService`
- Pronto para incluir `PessoaJuridica`

---
Desenvolvido como parte do teste técnico para AgroForte.