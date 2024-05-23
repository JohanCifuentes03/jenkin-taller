package co.com.sofkau.stepDefinitions.service;

import co.com.sofkau.questions.ResponseCode;
import co.com.sofkau.stepDefinitions.SetupService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;

import static co.com.sofkau.tasks.service.DoSoap.doSoap;
import static co.com.sofkau.utils.ArchivosUtil.readFile;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CountryInfoSoapStepDefinitions extends SetupService {
    String codigoISO;
    @Given("que el es usuario quiere ingresar el codigo {string}")
    public void queElEsUsuarioQuiereIngresarElCodigo(String iso) {
        super.setupService("http://webservices.oorsprong.org");
        codigoISO = iso;
    }
    @When("hace la peticion de tipo soap")
    public void haceLaPeticionDeTipoSoap() {
        actor.attemptsTo(
                doSoap().withTheResource("/websamples.countryinfo/CountryInfoService.wso")
                        .andHeaders(super.headers())
                        .andTheBody(getBody(codigoISO))
        );
    }
    private static @NotNull String getBody(String codigo) {
        String cuerpo = String.format(readFile("src/test/resources/archivosxml/countryInfo.xml"), codigo);
        return cuerpo;
    }

    @Then("deberia obtener un statuscode {int}")
    public void deberiaObtenerUnStatuscode(Integer statuscode) {
        actor.should(
                seeThat("el codigo de respuesta",
                        ResponseCode.was(), equalTo(statuscode)
                )
        );
    }
    @Then("deberia obtener el nombre del pais")
    public void deberia_obtener_el_nombre_del_pais() {

    }
}
