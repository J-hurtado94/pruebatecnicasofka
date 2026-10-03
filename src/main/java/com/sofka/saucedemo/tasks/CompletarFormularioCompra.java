package com.sofka.saucedemo.tasks;

import com.sofka.saucedemo.models.Comprador;
import com.sofka.saucedemo.userinterfaces.CarritoPage;
import com.sofka.saucedemo.userinterfaces.CheckoutInformacionPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompletarFormularioCompra implements Task {

    private final Comprador comprador;

    public CompletarFormularioCompra(Comprador comprador) {
        this.comprador = comprador;
    }

    public static CompletarFormularioCompra con(Comprador comprador) {
        return instrumented(CompletarFormularioCompra.class, comprador);
    }

    @Override
    @Step("{0} diligencia el formulario de compra con sus datos de envío")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CarritoPage.BOTON_CHECKOUT),
                Enter.theValue(comprador.nombre()).into(CheckoutInformacionPage.CAMPO_NOMBRE),
                Enter.theValue(comprador.apellido()).into(CheckoutInformacionPage.CAMPO_APELLIDO),
                Enter.theValue(comprador.codigoPostal()).into(CheckoutInformacionPage.CAMPO_CODIGO_POSTAL),
                Click.on(CheckoutInformacionPage.BOTON_CONTINUAR)
        );
    }
}
