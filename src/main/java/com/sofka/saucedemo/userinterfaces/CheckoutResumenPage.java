package com.sofka.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class CheckoutResumenPage {

    public static final Target BOTON_FINALIZAR = Target.the("botón finalizar")
            .locatedBy("[data-test='finish']");

    private CheckoutResumenPage() {
    }
}
