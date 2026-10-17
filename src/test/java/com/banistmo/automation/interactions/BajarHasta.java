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
            function centrar(contenedor) {
              var rect = el.getBoundingClientRect();
              var marco = contenedor === window
                ? { top: 0, height: window.innerHeight }
                : contenedor.getBoundingClientRect();
              var delta = rect.top - (marco.top + marco.height / 2 - rect.height / 2);
              if (contenedor === window) {
                window.scrollBy(0, delta);
              } else {
                contenedor.scrollTop += delta;
              }
            }
            var nodo = el.parentElement;
            while (nodo) {
              var estilo = window.getComputedStyle(nodo);
              var seDesplaza = /(auto|scroll|overlay)/.test(estilo.overflowY)
                && nodo.scrollHeight > nodo.clientHeight + 1;
              if (seDesplaza) {
                centrar(nodo);
              }
              nodo = nodo.parentElement;
            }
            centrar(window);
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
