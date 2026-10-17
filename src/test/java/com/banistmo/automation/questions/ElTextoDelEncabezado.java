package com.banistmo.automation.questions;

import com.banistmo.automation.uitargets.PaginaPersonas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ElTextoDelEncabezado implements Question<String> {

    public static ElTextoDelEncabezado visible() {
        return new ElTextoDelEncabezado();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(PaginaPersonas.TITULO_DESTACADO).answeredBy(actor);
    }
}
