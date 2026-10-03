package com.sofka.saucedemo.questions;

import com.sofka.saucedemo.userinterfaces.ConfirmacionPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public final class MensajeConfirmacion {

    private MensajeConfirmacion() {
    }

    public static Question<String> deLaOrden() {
        return Text.of(ConfirmacionPage.MENSAJE_CONFIRMACION).describedAs("el mensaje de confirmación de la orden");
    }
}
