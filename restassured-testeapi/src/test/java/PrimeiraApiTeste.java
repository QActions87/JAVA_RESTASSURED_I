// Import estático do Rest Assured (permite iniciar direto com given()):
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

// Para chamar o metodo 'RestAssured' de forma explícita:
import io.restassured.RestAssured;
// Import do JUnit 4:
import org.junit.Test;

public class PrimeiraApiTeste {

    // Indica ao JUnit que este método é um teste automatizado a ser executado
    @Test
    public void testeComSucessoApi() {
        // Armazena a URL base e o endpoint que será testado
        String url = "http://localhost:8080/api/primeiraApi";

        // Dado que: Inicia a preparação da requisição com a chamada explícita da classe RestAssured
        RestAssured.given()
                        // Imprime no console todos os detalhes do que está SENDO ENVIADO (Request)
                        .log().all()
                    // Quando: Executa a ação principal do teste (disparo do verbo HTTP)
                    .when()
                        // Envia uma requisição HTTP do tipo GET para o endereço da variável 'url'
                         .get(url)
                     // Então: Inicia o bloco de validações e asserções da resposta (Response)
                    .then()
                        // Imprime no console todos os detalhes do que foi RECEBIDO do servidor
                        .log().all()
                         // Metodo de transição BDD que melhora a leitura do código (afirme que...)
                        .assertThat()
                        // Valida se o código de status HTTP retornado pelo servidor é igual a 200 (OK)
                         .statusCode(200);
    }
}





























