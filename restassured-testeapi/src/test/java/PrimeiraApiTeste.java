// Import estático do Rest Assured (permite iniciar direto com given()):
import static io.restassured.RestAssured.*;
// Para chamar o metodo 'RestAssured' de forma explícita:
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
// Import do JUnit 4:
import org.junit.Test;

public class PrimeiraApiTeste {

    // Indica ao JUnit que este metodo é um teste automatizado a ser executado
    @Test
    public void exercicio01_TesteComSucessoApi() {
        // Armazena a URL base e o endpoint que será testado:
        String url = "http://localhost:8080/api/primeiraApi";

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
            .body(Matchers.containsString("Retorno ERRO da api com sucesso!!!"));
    }
    @Test
    public void exercicio02_TesteQueryParamPrimeiraApi() {
        // Armazena a URL base e o endpoint que será testado:
        String url = "http://localhost:8080/api/primeiraApiV1";
        // Armazena o Valor da chave do query param:
        String textoQueryParam = "TESTE";

        // Dado que: Inicia a preparação da requisição com a chamada explícita da classe RestAssured:
        RestAssured.given()
            // Passando o parâmetro e valor do query param:
            .queryParam("palavra", textoQueryParam)
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
            .body(Matchers.containsString(textoQueryParam));
    }
}





























