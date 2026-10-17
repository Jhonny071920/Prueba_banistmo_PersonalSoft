package com.banistmo.automation.tasks;

import com.banistmo.automation.config.Propiedades;
import com.banistmo.automation.interactions.CerrarAviso;
import com.banistmo.automation.interactions.EsperarQueCargue;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirLaPagina implements Task {

    private final String url;

    public AbrirLaPagina(String url) {
        this.url = url;
    }

    public static AbrirLaPagina dePersonas() {
        return instrumented(AbrirLaPagina.class, Propiedades.urlPersonas());
    }

    @Override
    @Step("{0} abre la pagina #url")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url),
                EsperarQueCargue.elContenido(),
                CerrarAviso.dePrivacidadSiEstaVisible()
        );
    }
}
