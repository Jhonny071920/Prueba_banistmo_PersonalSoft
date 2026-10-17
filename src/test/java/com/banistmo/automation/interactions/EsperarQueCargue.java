package com.banistmo.automation.interactions;

import com.banistmo.automation.uitargets.PaginaPersonas;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EsperarQueCargue implements Interaction {

    public static EsperarQueCargue elContenido() {
        return instrumented(EsperarQueCargue.class);
    }

    @Override
    @Step("{0} espera a que cargue el contenido principal")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaPersonas.ENCABEZADO_SITIO, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(PaginaPersonas.TITULO_DESTACADO, isVisible()).forNoMoreThan(30).seconds()
        );
    }
}
