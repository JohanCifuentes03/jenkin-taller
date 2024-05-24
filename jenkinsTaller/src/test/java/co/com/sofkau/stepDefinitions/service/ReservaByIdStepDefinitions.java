package co.com.sofkau.stepDefinitions.service;

import co.com.sofkau.questions.service.ResponseBody;
import co.com.sofkau.questions.service.ResponseCode;
import co.com.sofkau.stepDefinitions.SetupService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofkau.tasks.service.EnviarPeticionGet.enviarPeticionGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ReservaByIdStepDefinitions extends SetupService {
    @Given("que el usario esta en la pagina {string}")
    public void queElUsarioEstaEnLaPagina(String urlBase) {
        setupService(urlBase);
    }

    @When("realiza una peticion de tipo get al recurso {string}")
    public void realizaUnaPeticionDeTipoGetAlRecurso(String resource) {
        actor.attemptsTo(
                enviarPeticionGet().conRecurso(resource)
        );
    }

    @Then("deberia obtener un codigo de respuesta {int}")
    public void deberiaObtenerUnCodigoDeRespuesta(Integer statuscode) {
        actor.should(
                seeThat("el codigo de respuesta",
                        ResponseCode.was(), equalTo(statuscode)
                )
        );
    }
    @Then("deberia ver los datos del usuario")
    public void deberiaVerLosDatosDelUsuario() {
        actor.should(
                seeThat("la respuesta no esta vacia", ResponseBody.isNotEmpty())
        );
    }
}
