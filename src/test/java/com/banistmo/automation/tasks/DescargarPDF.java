package com.banistmo.automation.tasks;

import com.banistmo.automation.config.Propiedades;
import com.banistmo.automation.interactions.BajarHasta;
import com.banistmo.automation.interactions.CerrarAvisosDeInicio;
import com.banistmo.automation.uitargets.PaginaPersonas;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DescargarPDF implements Task {


    public static DescargarPDF dePersonas() {
        return instrumented(DescargarPDF.class, Propiedades.urlPersonas());
    }

    @Override
    @Step("{0} abre la pagina #url")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CerrarAvisosDeInicio.siEstanVisibles(),
                BajarHasta.el(PaginaPersonas.APRENDER_ES_FACIL),
                Click.on(PaginaPersonas.APRENDER_ES_FACIL)
        );
    }
}
