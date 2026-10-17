package com.banistmo.automation.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BajarHasta implements Interaction {

    private static final String SCRIPT = """
            var el = arguments[0];
            document.querySelectorAll('dialog[open]').forEach(function (dialogo) {
              dialogo.close();
            });
            [document.documentElement, document.body].forEach(function (nodo) {
              nodo.style.setProperty('overflow', 'visible', 'important');
              nodo.style.setProperty('height', 'auto', 'important');
              if (window.getComputedStyle(nodo).position === 'fixed') {
                nodo.style.setProperty('position', 'static', 'important');
                nodo.style.setProperty('top', 'auto', 'important');
              }
            });
            var destino = window.scrollY + el.getBoundingClientRect().top
              - (window.innerHeight / 2) + (el.getBoundingClientRect().height / 2);
            window.scrollTo(0, destino);
            var raiz = document.scrollingElement || document.documentElement;
            raiz.scrollTop = destino;
            var visible = el.getBoundingClientRect();
            return visible.top >= 0 && visible.bottom <= window.innerHeight && visible.height > 0;
            """;

    private final Target objetivo;

    public BajarHasta(Target objetivo) {
        this.objetivo = objetivo;
    }

    public static BajarHasta el(Target objetivo) {
        return new BajarHasta(objetivo);
    }

    @Override
    @Step("{0} baja hasta el elemento")
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement elemento = objetivo.resolveFor(actor).getElement();
        Object quedoVisible = ((JavascriptExecutor) driver).executeScript(SCRIPT, elemento);
        if (!Boolean.TRUE.equals(quedoVisible)) {
            throw new IllegalStateException("El scroll no dejo el elemento dentro de la pantalla");
        }
    }
}
