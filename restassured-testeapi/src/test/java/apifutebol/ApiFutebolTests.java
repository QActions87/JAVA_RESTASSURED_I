package apifutebol;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import java.net.ResponseCache;
import static io.restassured.RestAssured.given;
import static java.lang.Integer.parseInt;
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

    // 2º Teste: Valida a autenticação via Token Bearer e extrai diretamente o nome do 1º colocado do payload
    @Test
    public void exercicio08_TesteApiFutebolAutenticacaoExtracaoInfoJsonPath() {
        // Endpoint que retorna a tabela de classificação do campeonato ID 14:
        String url = "https://api.api-futebol.com.br/v1/campeonatos/14/tabela";

        // Dado que: Inicia a montagem da requisição e armazena o valor extraído diretamente na variável String 'primeiroColocado'
        String primeiroColocado = given()
            // Imprime no console os detalhes da requisição enviada (Headers, URL, Method):
            .log().all()
            // Adiciona o cabeçalho "Authorization" exigido pela API contendo o Bearer Token:
            .header("Authorization", "Bearer live_fede9295a60b13b55f2714314f5d7b")
        // Quando: Executa o disparo do verbo HTTP GET para o endereço especificado:
        .when()
            .get(url)
        // Então: Inicia o bloco de validações antes da extração final do dado:
        .then()
            // Imprime no console os detalhes da resposta recebida (Status Code, Headers, Body):
            .log().all()
            // Metodo sintático BDD para indicar o início das asserções (afirme que...):
            .assertThat()
            // Valida se o status HTTP retornado é 200 (OK):
            .statusCode(200)
            // Solicita a extração de dados do fluxo de execução do Rest Assured:
            .extract()
            // Navega no array JSON (posição [0]), acessa o objeto 'time' e extrai a String do campo 'nome_popular':
            .path("[0].time.nome_popular");

        // Imprime o resultado extraído no console:
        System.out.println("O 1º colocado é o " + primeiroColocado);
    }

    // 3º Teste: Valida a autenticação via Token Bearer e extrai os 3 primeiros colocados da tabela navegando no payload retornado
    @Test
    public void exercicio09_TesteApiFutebolAutenticacaoExtracaoInfoUtilizandoResponseJsonPath() {
        // Variáveis que armazenarão os nomes extraídos do JSON após a requisição:
        String primeiroColocado, segundoColocado, terceiroColocado;
        // Endpoint que retorna a tabela do campeonato ID 14:
        String url = "https://api.api-futebol.com.br/v1/campeonatos/14/tabela";
        // Objeto do Rest Assured que armazenara o conteúdo integral da resposta HTTP (Status Code, Headers, Body):
        Response response;

        // Dado que: Prepara a requisição HTTP e captura a resposta tratada no objeto 'response'
        response = given()
            // Imprime no console os detalhes da requisição enviada (Headers, URL, Method):
            .log().all()
            // Adiciona o cabeçalho "Authorization" exigido pela API contendo o Bearer Token:
            .header("Authorization", "Bearer live_fede9295a60b13b55f2714314f5d7b")
        // Quando: Executa o disparo do verbo HTTP GET para a URL especificada:
        .when()
            .get(url)
        // Então: Executa as validações da resposta (Response) antes de realizar a extração dos dados:
        .then()
            // Imprime no console os detalhes da resposta recebida (Status Code, Headers, Body):
            .log().all()
            // Metodo sintático BDD para marcar o início do bloco de asserções:
            .assertThat()
            // Valida se a API respondeu com código de sucesso 200 (OK):
            .statusCode(200)
            // Solicita a extração de dados do fluxo do Rest Assured:
            .extract()
            // Extrai o objeto Response completo para permitir múltiplas navegações no payload sem refazer a chamada HTTP:
            .response();

        // NAVEGAÇÃO E EXTRAÇÃO VIA JSONPATH:
        // Acessa o 1º objeto da lista (índice [0]), entra no objeto 'time' e captura o campo 'nome_popular':
        primeiroColocado = response.path("[0].time.nome_popular");
        System.out.println("O 1º colocado é o " + primeiroColocado);

        // Acessa o 2º objeto da lista (índice [1]), entra no objeto 'time' e captura o campo 'nome_popular':
        segundoColocado = response.path("[1].time.nome_popular");
        System.out.println("O 2º colocado é o " + segundoColocado);

        // Acessa o 3º objeto da lista (índice [2]), entra no objeto 'time' e captura o campo 'nome_popular':
        terceiroColocado = response.path("[2].time.nome_popular");
        System.out.println("O 3º colocado é o " + terceiroColocado);
    }

    // 4º Teste: Valida a autenticação via Token Bearer e extrai os 3 primeiros colocados da tabela navegando no payload retornado
    @Test
    public void exercicio10_TesteApiFutebolTabelaCampeonato01E02() {
        // Variáveis que armazenarão os nomes extraídos do JSON após a requisição:
        String primeiroColocado, segundoColocado, terceiroColocado;
        // Endpoint que retorna a tabela do campeonato ID 14:
        String url = "https://api.api-futebol.com.br/v1/campeonatos/14/tabela";
        // Objeto do Rest Assured que armazenara o conteúdo integral da resposta HTTP (Status Code, Headers, Body):
        Response response;

        // Dado que: Prepara a requisição HTTP e captura a resposta tratada no objeto 'response'
        response = given()
                // Imprime no console os detalhes da requisição enviada (Headers, URL, Method):
                .log().all()
                // Adiciona o cabeçalho "Authorization" exigido pela API contendo o Bearer Token:
                .header("Authorization", "Bearer live_fede9295a60b13b55f2714314f5d7b")
                // Quando: Executa o disparo do verbo HTTP GET para a URL especificada:
                .when()
                .get(url)
                // Então: Executa as validações da resposta (Response) antes de realizar a extração dos dados:
                .then()
                // Imprime no console os detalhes da resposta recebida (Status Code, Headers, Body):
                .log().all()
                // Metodo sintático BDD para marcar o início do bloco de asserções:
                .assertThat()
                // Valida se a API respondeu com código de sucesso 200 (OK):
                .statusCode(200)
                // Solicita a extração de dados do fluxo do Rest Assured:
                .extract()
                // Extrai o objeto Response completo para permitir múltiplas navegações no payload sem refazer a chamada HTTP:
                .response();

        // Loop for para mostrar os times em ordem de colocação:
        for (int i = 0; i < 20; i++) {
            System.out.println((i+1) + "º - " + response.path("["+i+"].time.nome_popular"));
        }

        // Variáveis que recebe os pontos do 1ª e último colocados:
        int primeiro = response.path("[0].pontos");
        int ultimo = response.path("[19].pontos");
        // Assert que verifica se o 1º colocado tem mais pontos que o 19º(último):
        Assert.assertTrue(primeiro > ultimo);


    }



}
