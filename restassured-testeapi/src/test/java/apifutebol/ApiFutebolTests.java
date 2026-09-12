package apifutebol;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class ApiFutebolTests {
    // 3º Teste: verifica se a variável passada por Query Param é a mesma retornada no payload do response:
    @Test
    public void exercicio07_TesteApiFutebolAutenticacao() {
        // Armazena a URL base e o endpoint que será testado:
        String url = "https://api.api-futebol.com.br/v1/campeonatos";

        // Armazena a mensagem do response do query param:
        String mensagemResponse = "Campeonato Baiano 2026";

        // Dado que: Inicia a preparação da requisição com a chamada explícita da classe RestAssured:
        given()
            // Imprime no console todos os detalhes do que está SENDO ENVIADO (Request):
            .log().all()
            .header("Authorization", "Bearer live_fede9295a60b13b55f2714314f5d7b")
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
            .body(containsString(mensagemResponse));
    }
}
