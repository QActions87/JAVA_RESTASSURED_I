import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class EndPointExerciciosTests {
    // 1º Teste: verifica se a variável passada por Query Param é a mesma retornada no payload do response:
    @Test
    public void exercicio01_TesteParOuImpar() {
        // Armazena a URL base e o endpoint que será testado:
        String url = "http://localhost:8080/exercicios/parOuImpar";
        // Armazena o Valor da chave do query param:
        String chaveQueryParam = "numero";
        // Armazena o Valor da chave do query param:
        int valorQueryParam = 2;
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
}
