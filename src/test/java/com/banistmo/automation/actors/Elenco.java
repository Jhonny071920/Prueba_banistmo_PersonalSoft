package com.banistmo.automation.actors;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public final class Elenco {

    private Elenco() {
    }

    public static void preparar() {
        OnStage.setTheStage(new OnlineCast());
    }

    public static Actor llamado(String nombre) {
        return OnStage.theActorCalled(nombre);
    }

    public static Actor enEscena() {
        return OnStage.theActorInTheSpotlight();
    }
}
