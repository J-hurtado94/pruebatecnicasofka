package com.sofka.saucedemo.tasks;

import com.sofka.saucedemo.userinterfaces.CheckoutResumenPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public final class FinalizarCompra {

    private FinalizarCompra() {
    }

    public static Performable desdeElResumen() {
        return Task.where("{0} finaliza la compra",
                Click.on(CheckoutResumenPage.BOTON_FINALIZAR));
    }
}
