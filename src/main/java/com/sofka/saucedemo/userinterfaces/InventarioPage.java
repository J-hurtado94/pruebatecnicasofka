package com.sofka.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class InventarioPage {

    public static final Target TITULO = Target.the("título de la página de productos")
            .locatedBy("[data-test='title']");
    public static final Target BOTON_AGREGAR_PRODUCTO = Target.the("botón agregar al carrito de '{0}'")
            .locatedBy("//div[@data-test='inventory-item-name' and normalize-space()='{0}']"
                    + "/ancestor::div[@data-test='inventory-item']//button[starts-with(@data-test,'add-to-cart')]");
    public static final Target ENLACE_CARRITO = Target.the("enlace del carrito de compras")
            .locatedBy("[data-test='shopping-cart-link']");

    private InventarioPage() {
    }
}
