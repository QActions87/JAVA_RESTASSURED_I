package apipetshop;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class ApiPetShopTests {
    // 1º Teste: Valida a criação de um novo usuário via requisição POST enviando um Array com 1 objeto em formato JSON no corpo (Body)
    @Test
    public void exercicio12_TesteAdicionarNovoUsuario() {
        // Endpoint da API Swagger PetStore para criação de usuários em lote (Array JSON):
        String url = "https://petstore.swagger.io/v2/user/createWithList";

        // Payload (corpo da requisição) contendo os dados do novo usuário dentro da lista JSON:
        String bodyUser = "[{\n" +
                "    \"id\": 9,\n" +
                "    \"username\": \"Hórus Atom\",\n" +
                "    \"firstName\": \"Hórus\",\n" +
                "    \"lastName\": \"Atom\",\n" +
                "    \"email\": \"atomota@gmail.com\",\n" +
                "    \"password\": \"123testando\",\n" +
                "    \"phone\": \"51999999999\",\n" +
                "    \"userStatus\": 1\n" +
                "  }]";

        // Dado que: Prepara a requisição HTTP configurando cabeçalhos e payload
        given()
            // Imprime no console os detalhes da requisição enviada (Headers, URL, Body):
            .log().all()
            // Define o tipo de conteúdo enviado no corpo da requisição como JSON:
            .header("Content-Type", "application/json")
            // Anexa a String JSON contendo o payload do usuário no corpo da requisição:
            .body(bodyUser)
        // Quando: Executa a ação principal do teste disparando o verbo HTTP POST:
        .when()
            .post(url)
        // Então: Valida as asserções de retorno da resposta (Response):
        .then()
            // Imprime no console os detalhes da resposta recebida do servidor (Status Code, Headers, Body):
            .log().all()
            // Metodo sintático BDD para marcar o início do bloco de asserções:
            .assertThat()
            // Valida se a API processou o cadastro com sucesso retornando o status HTTP 200 (OK):
            .statusCode(200);
    }
}
