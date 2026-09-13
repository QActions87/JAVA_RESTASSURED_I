# Testes em APIs com JAVA e REST-Assured 
Repositório contendo a suíte de testes automatizados de API desenvolvida em **Java** com **REST-Assured** e **JUnit**. O projeto abrange desde a validação de parâmetros e regras de negócio em ambiente local (Swagger/Spring Boot) até a integração com APIs REST externas reais que exigem autenticação via Bearer Token.

---

## 🚀 Tecnologias e Ferramentas

* **Linguagem:** Java 8+
* **Framework de Testes:** JUnit
* **Automação de API:** REST-Assured
* **Assertions:** Hamcrest Matchers
* **Gerenciador de Dependências:** Maven
* **Documentação/Ambiente Local:** Swagger UI

---

## 📌 Escopo dos Testes

O projeto está estruturado em pacotes e classes com focos complementares:

### 1. ⚽ API Futebol (Ambiente Externo Real)
* **Classe:** `ApiFutebolTests`
* **Target:** [API Futebol](https://dash.api-futebol.com.br/)
* **Cenários Automatizados:**
  * Validação de cabeçalho de autenticação HTTP (`Authorization: Bearer`).
  * Asserção de status code `200 OK`.
  * Extração e navegação em payloads complexos usando **JsonPath** e `Response` (ex: posições em tabela de campeonatos).

### 2. 🛠️ API Laboratório Local (Swagger UI)
* **Classes:** `EndPointExerciciosTests` e `EndPointPrimeiraApiTests`
* **Target:** Aplicação local rodando via Swagger (`http://localhost:8080/swagger-ui.html`)
* **Cenários Automatizados:**
  * Envio e validação de **Query Parameters** (ex: busca por palavras e validações de CPF).
  * Centralização de parâmetros de requisição utilizando `RequestSpecification` e `RequestSpecBuilder`.
  * Validação de corpos de resposta (Payload) com `Matchers.containsString`.

---

## 🛠️ Boas Práticas e Conceitos Aplicados

* **Sintaxe BDD (Given-When-Then):** Estruturação clara entre preparação da requisição, execução do verbo HTTP e asserções da resposta.
* **DRY (Don't Repeat Yourself):** Reuso de URLs bases e headers comuns via `RequestSpecification`.
* **Imports Estáticos:** Uso de `import static` no REST-Assured e Hamcrest para aumentar a legibilidade do código.
* **Extração Eficiente de Dados:** Leitura de propriedades específicas via JsonPath diretamente da resposta ou através da interface `Response`.

---

## ⚙️ Como Executar os Testes

1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
Loading...
