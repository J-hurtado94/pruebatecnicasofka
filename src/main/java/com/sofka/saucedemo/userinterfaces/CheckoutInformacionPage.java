package com.sofka.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class CheckoutInformacionPage {

    public static final Target CAMPO_NOMBRE = Target.the("campo nombre")
            .locatedBy("[data-test='firstName']");
    public static final Target CAMPO_APELLIDO = Target.the("campo apellido")
            .locatedBy("[data-test='lastName']");
    public static final Target CAMPO_CODIGO_POSTAL = Target.the("campo código postal")
            .locatedBy("[data-test='postalCode']");
    public static final Target BOTON_CONTINUAR = Target.the("botón continuar")
            .locatedBy("[data-test='continue']");

    private CheckoutInformacionPage() {
    }
}
