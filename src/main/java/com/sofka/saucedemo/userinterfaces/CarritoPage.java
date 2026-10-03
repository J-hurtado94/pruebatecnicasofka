package com.sofka.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class CarritoPage {

    public static final Target NOMBRES_PRODUCTOS = Target.the("nombres de los productos en el carrito")
            .locatedBy("[data-test='inventory-item-name']");
    public static final Target BOTON_CHECKOUT = Target.the("botón checkout")
            .locatedBy("[data-test='checkout']");

    private CarritoPage() {
    }
}
