package com.sofka.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class ConfirmacionPage {

    public static final Target MENSAJE_CONFIRMACION = Target.the("mensaje de confirmación de la orden")
            .locatedBy("[data-test='complete-header']");

    private ConfirmacionPage() {
    }
}
