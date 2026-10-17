package com.banistmo.automation.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BajarHasta implements Interaction {

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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions acciones = new Actions(driver);

        for (int intento = 0; intento < 20; intento++) {
            double arriba = numero(js, "return arguments[0].getBoundingClientRect().top;", elemento);
            double altoVentana = numero(js, "return window.innerHeight;");
            double altoElemento = numero(js, "return arguments[0].getBoundingClientRect().height;", elemento);
            if (arriba >= 0 && arriba + altoElemento <= altoVentana) {
                return;
            }
            int desplazamiento = (int) Math.round(arriba - (altoVentana / 2) + (altoElemento / 2));
            desplazamiento = Math.max(-700, Math.min(700, desplazamiento));
            if (desplazamiento == 0) {
                break;
            }
            acciones.scrollByAmount(0, desplazamiento).perform();
        }

        throw new IllegalStateException(String.valueOf(js.executeScript(
                "var r = arguments[0].getBoundingClientRect();"
                        + "return JSON.stringify({top: Math.round(r.top), scrollY: Math.round(window.scrollY),"
                        + " innerHeight: window.innerHeight});",
                elemento
        )));
    }

    private double numero(JavascriptExecutor js, String script, Object... args) {
        Object valor = js.executeScript(script, args);
        return valor instanceof Number ? ((Number) valor).doubleValue() : 0;
    }
}
