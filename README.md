# Testes em APIs com JAVA e REST-Assured 
![Java](https://api.devicons.dev.br/icon?icons=Linux%2CIdea%2CJava%2CMaven&size=48&theme=dark&perline=30)

Repositório contendo a suíte de testes automatizados de API desenvolvida em **Java** com **REST-Assured** e **JUnit**. O projeto abrange desde a validação de parâmetros e regras de negócio em ambiente local (Swagger/Spring Boot) até a integração com APIs REST externas reais que exigem autenticação via Bearer Token.

---

#
## 🚀 Tecnologias e Ferramentas

* **Linguagem:** Java 8+
* **Framework de Testes:** JUnit
* **Automação de API:** REST-Assured
* **Assertions:** Hamcrest Matchers
* **Gerenciador de Dependências:** Maven
* **Documentação/Ambiente Local:** Swagger UI

---

#
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

### 3. 🐶 API Swagger PetStore (Operações POST e Payloads JSON)
* **Classe:** `ApiPetShopTests`
* **Target:** [Swagger PetStore](https://petstore.swagger.io/#/user/createUsersWithListInput)
* **Cenários Automatizados:**
  * Envio de requisições com o verbo HTTP **`POST`** para criação de novos registros em lote.
  * Definição explícita de cabeçalho de conteúdo (`Content-Type: application/json`).
  * Envio de payloads estruturados no corpo da requisição utilizando listas de objetos JSON (Array JSON).
  * Validação de código de status HTTP `200 OK` no processamento do cadastro.
---

#
## 🛠️ Boas Práticas e Conceitos Aplicados

* **Sintaxe BDD (Given-When-Then):** Estruturação clara entre preparação da requisição, execução do verbo HTTP e asserções da resposta.
* **DRY (Don't Repeat Yourself):** Reuso de URLs bases e headers comuns via `RequestSpecification`.
* **Imports Estáticos:** Uso de `import static` no REST-Assured e Hamcrest para aumentar a legibilidade do código.
* **Extração Eficiente de Dados:** Leitura de propriedades específicas via JsonPath diretamente da resposta ou através da interface `Response`.

---

#
## ⚙️ Como Executar os Testes

Para executar toda a suíte de testes com sucesso, é necessário primeiro subires a aplicação backend local em Java (necessária para as classes de teste da API local) e, em seguida, rodar a suíte REST-Assured.

### 1️⃣ Subir a Aplicação Backend (Ambiente Local)

1. Clone o repositório do backend local e acesse a pasta do projeto:
   ```
   git clone https://github.com/qaacademy/primeiraApiQAAcademy.git
   ```
2. Navegue até o diretório do projeto usando o comando `cd`:
   ```
   cd caminho/para/o/diretório/primeiraApi
   ```
   **Obs.:** Certifique-se de substituir caminho/para/o/diretório/primeiraApi pelo caminho real do diretório do seu projeto.
   
4. Use o comando mvn spring-boot:run para iniciar o projeto:
   ```
   mvn spring-boot:run
   ```
   
 #  
 ## Documentação da API
A documentação da API está disponível no Swagger UI. Após iniciar o aplicativo, você pode acessar a documentação em:

```

http://localhost:8080/swagger-ui.html
```

#
### 2️⃣ Clonar e Executar a Suíte de Testes (Este Repositório)

1. Abra um novo terminal, clone este repositório de testes e navegue até a pasta:
   ```
   git clone https://github.com/QActions87/JAVA_RESTASSURED_I.git
   ```
2. Navegue até o diretório onde tem o 'pom.xml'.
   
3. Execute a suíte de testes automatizados utilizando o Maven:
   ```
   mvn test
   ```
   
