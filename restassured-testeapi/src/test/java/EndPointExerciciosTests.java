import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class EndPointExerciciosTests {
    // 1º Teste: verifica se a variável passada por Query Param é a mesma retornada no payload do response:
    @Test
    public void exercicio04_TesteParOuImpar() {
        // Armazena a URL base e o endpoint que será testado:
        String url = "http://localhost:8080/exercicios/parOuImpar";
        // Armazena o Valor da chave do query param:
        String chaveQueryParam = "numero";
        // Armazena o Valor da chave do query param:
        int valorQueryParam = 3;
        // Armazena a mensagem do response do query param:
        String mensagemResponseQueryParam = "O numero 3 é impar";

        // Dado que: Inicia a preparação da requisição com a chamada explícita da classe RestAssured:
        RestAssured.given()
                // Passando o parâmetro e valor do query param:
                .queryParam(chaveQueryParam, valorQueryParam)
                    // Imprime no console todos os detalhes do que está SENDO ENVIADO (Request):
                    .log().all()
                    // Quando: Executa a ação principal do teste (disparo do verbo HTTP):
                .when()
                    // Envia uma requisição HTTP do tipo GET para o endereço da variável 'url':
                    .get(url)
                // Então: Inicia o bloco de validações e asserções da resposta (Response):
                .then()
                    // Imprime no console todos os detalhes do que foi RECEBIDO do servidor:
                    .log().all()
                    // Metodo de transição BDD que melhora a leitura do código (afirme que...).
                    // Indica que a partir daqui virão às asserções:
                    .assertThat()
                    // Valida se o código de status HTTP retornado pelo servidor é igual a 200 (OK):
                    .statusCode(200)
                    // Valida se o corpo (body) da resposta contém a frase/texto especificado:
                    .body(Matchers.containsString(mensagemResponseQueryParam));
    }

    // 2º Teste: verifica se o valor passada por Path Param é a mesma retornada no payload do response:
    @Test
    public void exercicio05_TesteParOuImpar() {
        // Armazena o Valor do path param:
        String salarioPathParam = "2600";
        // Armazena a URL base e o endpoint que será testado:
        String url = "http://localhost:8080/exercicios/calculaSalario/" + salarioPathParam;
        // Mensagem do response a ser validada:
        String mensagemResponsePathParam = "Salario bruto = 2600.0";

        // Dado que: Inicia a preparação da requisição com a chamada explícita da classe RestAssured:
        RestAssured.given()
                    // Imprime no console todos os detalhes do que está SENDO ENVIADO (Request):
                    .log().all()
                // Quando: Executa a ação principal do teste (disparo do verbo HTTP):
                .when()
                    // Envia uma requisição HTTP do tipo GET para o endereço da variável 'url':
                    .get(url)
                // Então: Inicia o bloco de validações e asserções da resposta (Response):
                .then()
                    // Imprime no console todos os detalhes do que foi RECEBIDO do servidor:
                    .log().all()
                    // Metodo de transição BDD que melhora a leitura do código (afirme que...).
                    // Indica que a partir daqui virão às asserções:
                    .assertThat()
                    // Valida se o código de status HTTP retornado pelo servidor é igual a 200 (OK):
                    .statusCode(200)
                    // Valida se o corpo (body) da resposta contém a frase/texto especificado:
                    .body(Matchers.containsString(mensagemResponsePathParam));
    }

    // 3º Teste: verifica se a variável passada por Query Param é a mesma retornada no payload do response:
    @Test
    public void exercicio06_TesteValidacaoCPF() {
        // Armazena a URL base e o endpoint que será testado:
        String url = "http://localhost:8080/exercicios/validarCpf";
        // Armazena o Valor da chave do query param:
        String chaveQueryParam = "cpf";
        // Armazena o Valor da chave do query param:
        String valorQueryParam = "13948436070";
        // Armazena a mensagem do response do query param:
        String mensagemResponseQueryParam = "CPF Valido";

        // Dado que: Inicia a preparação da requisição com a chamada explícita da classe RestAssured:
        RestAssured.given()
                // Passando o parâmetro e valor do query param:
                .queryParam(chaveQueryParam, valorQueryParam)
                // Imprime no console todos os detalhes do que está SENDO ENVIADO (Request):
                .log().all()
                // Quando: Executa a ação principal do teste (disparo do verbo HTTP):
                .when()
                // Envia uma requisição HTTP do tipo GET para o endereço da variável 'url':
                .get(url)
                // Então: Inicia o bloco de validações e asserções da resposta (Response):
                .then()
                // Imprime no console todos os detalhes do que foi RECEBIDO do servidor:
                .log().all()
                // Metodo de transição BDD que melhora a leitura do código (afirme que...).
                // Indica que a partir daqui virão às asserções:
                .assertThat()
                // Valida se o código de status HTTP retornado pelo servidor é igual a 200 (OK):
                .statusCode(200)
                // Valida se o corpo (body) da resposta contém a frase/texto especificado:
                .body(Matchers.containsString(mensagemResponseQueryParam));
    }
}
