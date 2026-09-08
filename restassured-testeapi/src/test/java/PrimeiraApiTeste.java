// Import estático do Rest Assured (permite iniciar direto com given()):
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

// Para chamar o metodo 'RestAssured' de forma explícita:
import io.restassured.RestAssured;
// Import do JUnit 4:
import org.junit.Test;

public class PrimeiraApiTeste {

    @Test
    public void testeComSucessoApi() {
        String url = "http://localhost:8080/api/primeiraApi";
        // Chamando o metodo 'RestAssured' de forma explícita:
        RestAssured.given()
                        .log().all()
                    .when()
                        .get(url)
                    .then()
                        .log().all()
                        .assertThat()
                        .statusCode(200);
    }
}





























