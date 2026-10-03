package com.sofka.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class LoginPage {

    public static final Target CAMPO_USUARIO = Target.the("campo usuario")
            .locatedBy("[data-test='username']");
    public static final Target CAMPO_CLAVE = Target.the("campo clave")
            .locatedBy("[data-test='password']");
    public static final Target BOTON_INGRESAR = Target.the("botón ingresar")
            .locatedBy("[data-test='login-button']");

    private LoginPage() {
    }
}
