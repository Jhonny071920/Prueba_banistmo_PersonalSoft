package com.banistmo.automation.interactions;

import com.banistmo.automation.uitargets.PaginaPersonas;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CerrarAviso implements Interaction {

    public static CerrarAviso dePrivacidadSiEstaVisible() {
        return instrumented(CerrarAviso.class);
    }

    @Override
    @Step("{0} cierra el aviso de privacidad si esta visible")
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> avisos = BrowseTheWeb.as(actor)
                .findAll(By.xpath(PaginaPersonas.SELECTOR_AVISO_ENTENDIDO));

        avisos.stream()
                .filter(WebElementFacade::isCurrentlyVisible)
                .findFirst()
                .ifPresent(WebElementFacade::click);
    }
}
