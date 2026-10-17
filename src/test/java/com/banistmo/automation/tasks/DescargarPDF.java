package com.banistmo.automation.tasks;

import com.banistmo.automation.config.Propiedades;
import com.banistmo.automation.interactions.BajarHasta;
import com.banistmo.automation.interactions.CerrarAvisosDeInicio;
import com.banistmo.automation.uitargets.PaginaAprenderEsFacil;
import com.banistmo.automation.uitargets.PaginaAutocertificacionFiscal;
import com.banistmo.automation.uitargets.PaginaLegales;
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
                Click.on(PaginaPersonas.APRENDER_ES_FACIL),
                BajarHasta.el(PaginaAprenderEsFacil.LEGALES_DESCUBRE_MAS),
                Click.on(PaginaAprenderEsFacil.LEGALES_DESCUBRE_MAS),
                BajarHasta.el(PaginaLegales.AUTOCERTIFICACION_FISCAL_DESCUBRE_MAS),
                Click.on(PaginaLegales.AUTOCERTIFICACION_FISCAL_DESCUBRE_MAS),
                BajarHasta.el(PaginaAutocertificacionFiscal.AUTOCERTIFICACION_UNIFICADO),
                Click.on(PaginaAutocertificacionFiscal.AUTOCERTIFICACION_UNIFICADO)

        );
    }
}
