package com.sofka.saucedemo.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Escribe un valor sensible (p. ej. una clave) sin publicarlo en el reporte de Serenity,
 * a diferencia de Enter.theValue(...), que registra el texto ingresado.
 */
public class IngresarTextoSensible implements Interaction {

    private final String valor;
    private final Target campo;

    public IngresarTextoSensible(String valor, Target campo) {
        this.valor = valor;
        this.campo = campo;
    }

    public static IngresarTextoSensible en(Target campo, String valor) {
        return instrumented(IngresarTextoSensible.class, valor, campo);
    }

    @Override
    @Step("{0} ingresa un valor protegido en #campo")
    public <T extends Actor> void performAs(T actor) {
        campo.resolveFor(actor).type(valor);
    }
}
