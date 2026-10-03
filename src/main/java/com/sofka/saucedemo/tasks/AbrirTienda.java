package com.sofka.saucedemo.tasks;

import com.sofka.saucedemo.userinterfaces.SauceDemoHomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public final class AbrirTienda {

    private AbrirTienda() {
    }

    public static Performable sauceDemo() {
        return Task.where("{0} abre la tienda SauceDemo",
                Open.browserOn().the(SauceDemoHomePage.class));
    }
}
