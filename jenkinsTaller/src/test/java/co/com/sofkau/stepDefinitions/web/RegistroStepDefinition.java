package co.com.sofkau.stepDefinitions.web;

import co.com.sofkau.models.UsuarioModel;
import co.com.sofkau.stepDefinitions.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.CoreMatchers;

import static co.com.sofkau.questions.ObtenerLogoPaginaPrincipal.obtenerLogoPaginaPrincipal;
import static co.com.sofkau.questions.ObtenerMensajeInicioDeSesion.obtenerMensajeInicioDeSesion;
import static co.com.sofkau.tasks.AbrirPaginaPrincipal.abrirPaginaPrincipal;
import static co.com.sofkau.tasks.LlenarAutenticacion.llenarAutenticacion;
import static co.com.sofkau.tasks.LlenarRegistro.llenarRegistro;
import static co.com.sofkau.tasks.NavegarAAutenticacion.navegarAAutenticacion;
import static co.com.sofkau.utils.Constante.Mensaje_esperado_de_login;
import static co.com.sofkau.utils.Constante.url_pagina_principal;
import static co.com.sofkau.utils.Util.crearUsuario;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class RegistroStepDefinition extends SetUp {
    @Given("que el usuario selecciona el navegador {string} e ingresa al sitio web")
    public void que_el_usuario_selecciona_el_navegador_e_ingresa_al_sitio_web(String navegador) {
        actorSetUpTheBrowser(navegador);
        theActorInTheSpotlight().wasAbleTo(
                abrirPaginaPrincipal().conLaUrl(url_pagina_principal)
        );
    }
    @When("ingresa su informacion correctamente para crear su cuenta")
    public void ingresa_su_informacion_correctamente_para_crear_su_cuenta() {
        UsuarioModel usuario = crearUsuario();

        theActorInTheSpotlight().attemptsTo(
                navegarAAutenticacion(),
                llenarAutenticacion().conElCorreo(usuario),
                llenarRegistro().conElUsuario(usuario)
        );
    }
    @Then("deberia ser redirigido a la pagina principal con la sesion iniciada")
    public void deberia_ser_redirigido_a_la_pagina_principal_con_la_sesion_iniciada() {
        theActorInTheSpotlight().should(
                seeThat(obtenerMensajeInicioDeSesion(), containsString(Mensaje_esperado_de_login)),
                seeThat(obtenerLogoPaginaPrincipal(), CoreMatchers.notNullValue())
        );
    }
}