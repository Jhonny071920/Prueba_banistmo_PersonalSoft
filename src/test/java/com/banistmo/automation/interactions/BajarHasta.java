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
            var html = document.documentElement;
            var body = document.body;
            return JSON.stringify({
              top: Math.round(visible.top),
              bottom: Math.round(visible.bottom),
              height: Math.round(visible.height),
              innerHeight: window.innerHeight,
              scrollY: Math.round(window.scrollY),
              rootScroll: Math.round((document.scrollingElement || html).scrollTop),
              htmlOverflow: getComputedStyle(html).overflow,
              bodyOverflow: getComputedStyle(body).overflow,
              bodyPosition: getComputedStyle(body).position,
              dialogs: document.querySelectorAll('dialog[open]').length
            });
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
        Object resultado = ((JavascriptExecutor) driver).executeScript(SCRIPT, elemento);
        throw new IllegalStateException(String.valueOf(resultado));
    }
}
