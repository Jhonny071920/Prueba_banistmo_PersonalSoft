package com.banistmo.automation.uitargets;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaPersonas {

    public static final Target ENCABEZADO_SITIO = Target.the("encabezado del sitio")
            .locatedBy("css:header");

    public static final Target TITULO_DESTACADO = Target.the("titulo destacado")
            .locatedBy("css:.swiper-slide-active .cbc-banner__title");

    public static final String SELECTOR_AVISO_ENTENDIDO =
            "//button[contains(@class,'ml-bandstrip-flexible__container-button') and .//span[normalize-space()='Entendido']]";

    public static final String SELECTOR_CERRAR_MODAL =
            "//button[@data-testid='or-promotional-modal__close']";

    public static final Target AVISO_ENTENDIDO = Target.the("boton Entendido del aviso")
            .locatedBy(SELECTOR_AVISO_ENTENDIDO);

    public static final Target APRENDER_ES_FACIL = Target.the("boton Aprender es fácil")
            .locatedBy("//span[normalize-space()='Aprender es fácil']/ancestor::*[@data-testid='ml-card']//button[@aria-label='Descubre más']");

    public static final Target BOTON_ENTENDIDO = Target.the("boton Entendido")
            .locatedBy(SELECTOR_AVISO_ENTENDIDO);

    public static final Target BOTON_MODAL = Target.the("modal promocional")
            .locatedBy("//dialog[@data-testid='or-promotional-modal']");

    public static final Target BOTON_CERRAR_AVISO = Target.the("boton cerrar modal promocional")
            .locatedBy(SELECTOR_CERRAR_MODAL);

    private PaginaPersonas() {
    }
}
