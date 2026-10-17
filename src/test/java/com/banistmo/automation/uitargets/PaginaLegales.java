package com.banistmo.automation.uitargets;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaLegales {

    public static final Target AUTOCERTIFICACION_FISCAL_DESCUBRE_MAS = Target.the("boton Autocertificacion FISCAL Descubre Más")
            .locatedBy("(//h3[contains(text(),'Autocertificación fiscal FATCA & CRS  ')]//ancestor::div[@class='cbc-card__size-data bc-flex bc-direction-column bc-w-100 bc-h-100 bc-position-relative bc-p-4']//button)");


    private PaginaLegales() {
    }
}
