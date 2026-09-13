package apifutebol;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class ApiFutebolTests {
    // 1º Teste: Valida a autenticação por Token Bearer e verifica a presença do campeonato no payload de resposta:
    @Test
    public void exercicio07_TesteApiFutebolAutenticacao() {
        // Armazena a URL base e o endpoint que será testado:
        String url = "https://api.api-futebol.com.br/v1/campeonatos";

        // Armazena o texto esperado para validação no corpo da resposta:
        String mensagemResponse = "Campeonato Baiano 2026";

        // Dado que: Inicia a preparação da requisição (usando o import estático 'given()'):
        given()
            // Imprime no console todos os detalhes do que está SENDO ENVIADO (Request):
            .log().all()
            // Adiciona o cabeçalho de autorização (Header Authorization) com o Token Bearer:
            .header("Authorization", "Bearer live_fede9295a60b13b55f2714314f5d7b")
        // Quando: Executa a ação principal do teste (disparo do verbo HTTP):
        .when()
            // Envia uma requisição HTTP do tipo GET para o endereço da variável 'url':
            .get(url)
        // Então: Inicia o bloco de validações e asserções da resposta (Response):
        .then()
            // Imprime no console todos os detalhes do que foi RECEBIDO do servidor:
            .log().all()
            // Metodo de transição BDD que indica o início das asserções (afirme que...):
            .assertThat()
            // Valida se o código de status HTTP retornado pelo servidor é igual a 200 (OK):
            .statusCode(200)
            // Valida se o corpo (body) da resposta contém a frase/texto especificado (usando o import estático 'containsString'):
            .body(containsString(mensagemResponse));
    }

    // 2º Teste: Valida a autenticação por Token Bearer e extrai a 1ª posição da tabela no payload do response:
    @Test
    public void exercicio08_TesteApiFutebolAutenticacaoExtracaoInfoJsonPath() {
        // Armazena a URL base e o endpoint que será testado:
        String url = "https://api.api-futebol.com.br/v1/campeonatos/14/tabela";

        // Dado que: Inicia a preparação da requisição (usando o import estático 'given()'):
        String primeiroColocado = given()
            // Imprime no console todos os detalhes do que está SENDO ENVIADO (Request):
            .log().all()
            // Adiciona o cabeçalho de autorização (Header Authorization) com o Token Bearer:
            .header("Authorization", "Bearer live_fede9295a60b13b55f2714314f5d7b")
        // Quando: Executa a ação principal do teste (disparo do verbo HTTP):
        .when()
            // Envia uma requisição HTTP do tipo GET para o endereço da variável 'url':
            .get(url)
        // Então: Inicia o bloco de validações e asserções da resposta (Response):
        .then()
            // Imprime no console todos os detalhes do que foi RECEBIDO do servidor:
            .log().all()
            // Metodo de transição BDD que indica o início das asserções (afirme que...):
            .assertThat()
            // Valida se o código de status HTTP retornado pelo servidor é igual a 200 (OK):
            .statusCode(200)
            .extract()
            .path("[0].time.nome_popular");
        System.out.println("O 1º colocado é o " + primeiroColocado);
    }
}
