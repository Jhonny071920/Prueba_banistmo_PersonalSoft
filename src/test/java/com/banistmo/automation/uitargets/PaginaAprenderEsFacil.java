package com.banistmo.automation.uitargets;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaAprenderEsFacil {

    public static final Target LEGALES_DESCUBRE_MAS = Target.the("boton Legales Descubre Más")
            .locatedBy("(//h3[contains(text(),'Legales')]//ancestor::div[@class='cbc-card__size-data bc-flex bc-direction-column bc-w-100 bc-h-100 bc-position-relative bc-p-4']//button)");


    private PaginaAprenderEsFacil() {
    }
}
