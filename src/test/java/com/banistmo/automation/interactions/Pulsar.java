package com.banistmo.automation.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pulsar implements Interaction {

    private final Target objetivo;

    public Pulsar(Target objetivo) {
        this.objetivo = objetivo;
    }

    public static Pulsar en(Target objetivo) {
        return new Pulsar(objetivo);
    }

    @Override
    @Step("{0} pulsa el elemento")
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement elemento = objetivo.resolveFor(actor).getElement();
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'nearest'}); arguments[0].click();",
                elemento
        );
    }
}
