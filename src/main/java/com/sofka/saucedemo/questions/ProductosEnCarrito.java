package com.sofka.saucedemo.questions;

import com.sofka.saucedemo.userinterfaces.CarritoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collection;

public final class ProductosEnCarrito {

    private ProductosEnCarrito() {
    }

    public static Question<Collection<String>> nombres() {
        return Text.ofEach(CarritoPage.NOMBRES_PRODUCTOS).describedAs("los productos del carrito");
    }
}
