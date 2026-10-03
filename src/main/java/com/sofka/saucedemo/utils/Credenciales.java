package com.sofka.saucedemo.utils;

import java.util.Optional;

/**
 * Obtiene datos sensibles desde el entorno para no versionarlos en el código ni en los features.
 * Prioridad: variable de entorno SAUCEDEMO_PASSWORD y, en su defecto, la propiedad -Dsaucedemo.password.
 */
public final class Credenciales {

    private static final String VARIABLE_ENTORNO_CLAVE = "SAUCEDEMO_PASSWORD";
    private static final String PROPIEDAD_CLAVE = "saucedemo.password";

    private Credenciales() {
    }

    public static String clave() {
        return Optional.ofNullable(System.getenv(VARIABLE_ENTORNO_CLAVE))
                .or(() -> Optional.ofNullable(System.getProperty(PROPIEDAD_CLAVE)))
                .filter(valor -> !valor.isBlank())
                .orElseThrow(() -> new IllegalStateException(
                        "No se encontró la clave de acceso. Defina la variable de entorno "
                                + VARIABLE_ENTORNO_CLAVE + " o la propiedad -D" + PROPIEDAD_CLAVE));
    }
}
