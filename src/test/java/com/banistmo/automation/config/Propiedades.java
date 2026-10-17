package com.banistmo.automation.config;

import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public final class Propiedades {

    public static final String URL_PERSONAS_POR_DEFECTO = "https://www.banistmo.com/personas";

    private Propiedades() {
    }

    public static String urlPersonas() {
        EnvironmentVariables variables = SystemEnvironmentVariables.currentEnvironmentVariables();
        return variables.getProperty("banistmo.personas.url", URL_PERSONAS_POR_DEFECTO);
    }
}
