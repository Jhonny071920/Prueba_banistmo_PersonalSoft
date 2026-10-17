package com.banistmo.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

public class LaUrlActual implements Question<String> {

    public static LaUrlActual valor() {
        return new LaUrlActual();
    }

    @Override
    public String answeredBy(Actor actor) {
        return TheWebPage.currentUrl().answeredBy(actor);
    }
}
