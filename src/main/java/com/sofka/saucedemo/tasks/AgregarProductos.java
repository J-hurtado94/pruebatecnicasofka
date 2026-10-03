package com.sofka.saucedemo.tasks;

import com.sofka.saucedemo.userinterfaces.InventarioPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarProductos implements Task {

    private final List<String> productos;

    public AgregarProductos(List<String> productos) {
        this.productos = List.copyOf(productos);
    }

    public static AgregarProductos alCarrito(List<String> productos) {
        return instrumented(AgregarProductos.class, productos);
    }

    @Override
    @Step("{0} agrega al carrito los productos #productos")
    public <T extends Actor> void performAs(T actor) {
        productos.forEach(producto ->
                actor.attemptsTo(Click.on(InventarioPage.BOTON_AGREGAR_PRODUCTO.of(producto)))
        );
    }
}
