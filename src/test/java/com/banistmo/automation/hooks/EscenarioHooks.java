package com.banistmo.automation.hooks;

import com.banistmo.automation.actors.Elenco;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;

public class EscenarioHooks {

    @Before
    public void prepararElenco() {
        Elenco.preparar();
    }

    @ParameterType(".*")
    public Actor actor(String nombre) {
        return Elenco.llamado(nombre);
    }
}
