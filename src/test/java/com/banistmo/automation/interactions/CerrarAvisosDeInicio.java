package com.banistmo.automation.interactions;

import com.banistmo.automation.uitargets.PaginaPersonas;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CerrarAvisosDeInicio implements Interaction {

    private static final By MODAL = By.xpath(PaginaPersonas.SELECTOR_CERRAR_MODAL);
    private static final By ENTENDIDO = By.xpath(PaginaPersonas.SELECTOR_AVISO_ENTENDIDO);
    private static final By ENTENDIDO_POR_TEXTO = By.xpath(
            "//button[.//span[normalize-space()='Entendido'] or normalize-space()='Entendido']");

    public static CerrarAvisosDeInicio siEstanVisibles() {
        return instrumented(CerrarAvisosDeInicio.class);
    }

    @Override
    @Step("{0} cierra el modal promocional y el aviso Entendido")
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        pulsarSiAparece(driver, MODAL, 12);
        if (!pulsarSiAparece(driver, ENTENDIDO, 8)) {
            pulsarSiAparece(driver, ENTENDIDO_POR_TEXTO, 4);
        }
    }

    private boolean pulsarSiAparece(WebDriver driver, By selector, int segundos) {
        try {
            WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(segundos));
            espera.pollingEvery(Duration.ofMillis(400));
            WebElement boton = espera.until(ExpectedConditions.presenceOfElementLocated(selector));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", boton);
            espera.until(driverActual -> sinBotonVisible(driverActual, selector));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    private boolean sinBotonVisible(WebDriver driver, By selector) {
        List<WebElement> botones = driver.findElements(selector);
        return botones.stream().noneMatch(WebElement::isDisplayed);
    }
}
