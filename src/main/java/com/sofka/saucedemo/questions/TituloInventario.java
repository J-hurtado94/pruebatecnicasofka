package com.sofka.saucedemo.questions;

import com.sofka.saucedemo.userinterfaces.InventarioPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public final class TituloInventario {

    private TituloInventario() {
    }

    public static Question<String> visible() {
        return Text.of(InventarioPage.TITULO).describedAs("el título de la página de productos");
    }
}
