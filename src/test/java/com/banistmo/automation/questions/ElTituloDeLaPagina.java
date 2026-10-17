package com.banistmo.automation.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

public class ElTituloDeLaPagina implements Question<String> {

    public static ElTituloDeLaPagina delNavegador() {
        return new ElTituloDeLaPagina();
    }

    @Override
    public String answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return TheWebPage.title().answeredBy(actor);
    }
}
