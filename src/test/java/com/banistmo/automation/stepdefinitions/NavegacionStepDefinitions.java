package com.banistmo.automation.stepdefinitions;

import com.banistmo.automation.actors.Elenco;
import com.banistmo.automation.questions.ElTextoDelEncabezado;
import com.banistmo.automation.questions.ElTituloDeLaPagina;
import com.banistmo.automation.questions.LaUrlActual;
import com.banistmo.automation.tasks.AbrirLaPagina;
import com.banistmo.automation.tasks.DescargarPDF;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.not;

public class NavegacionStepDefinitions {

    private Actor user;
    @Given("que {actor} abre la banca de personas")
    public void abreLaBancaDePersonas(Actor actor) {
        user=actor;
        actor.attemptsTo(AbrirLaPagina.dePersonas());
    }

    @When("la pagina carga se sigue la ruta hasta autocertificacion fiscal")
    public void laPaginaCargaSeSigueLaRutaHastaAutocertificacionFiscal() {
        user.attemptsTo(
                DescargarPDF.dePersonas()
        );
    }

    @Then("debería ver el sitio de Banistmo")
    public void deberiaVerElSitioDeBanistmo() {
        Elenco.enEscena().should(
                seeThat("el titulo del navegador", ElTituloDeLaPagina.delNavegador(), allOf(
                        containsStringIgnoringCase("Banistmo"),
                        containsStringIgnoringCase("Personas")
                )),
                seeThat("la url actual", LaUrlActual.valor(), allOf(
                        containsStringIgnoringCase("banistmo.com"),
                        containsStringIgnoringCase("personas")
                )),
                seeThat("el titulo destacado", ElTextoDelEncabezado.visible(), not(blankOrNullString()))
        );
    }
}
