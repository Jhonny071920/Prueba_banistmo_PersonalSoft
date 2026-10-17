package com.banistmo.automation.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

public class ElPDFFueDescargado implements Question<String> {

    public static ElPDFFueDescargado delNavegador() {
        return new ElPDFFueDescargado();
    }

    @Override
    public String answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return TheWebPage.title().answeredBy(actor);
    }
}
