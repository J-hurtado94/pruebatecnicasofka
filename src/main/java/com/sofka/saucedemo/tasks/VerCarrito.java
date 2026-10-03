package com.sofka.saucedemo.tasks;

import com.sofka.saucedemo.userinterfaces.InventarioPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public final class VerCarrito {

    private VerCarrito() {
    }

    public static Performable deCompras() {
        return Task.where("{0} abre el carrito de compras",
                Click.on(InventarioPage.ENLACE_CARRITO));
    }
}
