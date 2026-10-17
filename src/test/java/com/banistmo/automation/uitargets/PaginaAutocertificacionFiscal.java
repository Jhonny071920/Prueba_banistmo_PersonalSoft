package com.banistmo.automation.uitargets;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaAutocertificacionFiscal {

    public static final Target AUTOCERTIFICACION_UNIFICADO = Target.the("boton Autocertificacion Unificado")
            .locatedBy("//span[contains(text(),'PJ-Autocertificación unificado - Fatca y CRS.pdf')] //ancestor::a[@data-testid='at-link']");


    private PaginaAutocertificacionFiscal() {
    }
}
