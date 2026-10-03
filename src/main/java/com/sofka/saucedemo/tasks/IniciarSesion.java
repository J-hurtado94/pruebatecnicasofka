package com.sofka.saucedemo.tasks;

import com.sofka.saucedemo.interactions.IngresarTextoSensible;
import com.sofka.saucedemo.userinterfaces.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesion implements Task {

    private final String usuario;
    private final String clave;

    public IniciarSesion(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public static IniciarSesion con(String usuario, String clave) {
        return instrumented(IniciarSesion.class, usuario, clave);
    }

    @Override
    @Step("{0} inicia sesión con el usuario #usuario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginPage.CAMPO_USUARIO),
                IngresarTextoSensible.en(LoginPage.CAMPO_CLAVE, clave),
                Click.on(LoginPage.BOTON_INGRESAR)
        );
    }
}
