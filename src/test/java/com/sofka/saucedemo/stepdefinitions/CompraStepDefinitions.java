package com.sofka.saucedemo.stepdefinitions;

import com.sofka.saucedemo.models.Comprador;
import com.sofka.saucedemo.questions.MensajeConfirmacion;
import com.sofka.saucedemo.questions.ProductosEnCarrito;
import com.sofka.saucedemo.questions.TituloInventario;
import com.sofka.saucedemo.tasks.AbrirTienda;
import com.sofka.saucedemo.tasks.AgregarProductos;
import com.sofka.saucedemo.tasks.CompletarFormularioCompra;
import com.sofka.saucedemo.tasks.FinalizarCompra;
import com.sofka.saucedemo.tasks.IniciarSesion;
import com.sofka.saucedemo.tasks.VerCarrito;
import com.sofka.saucedemo.utils.Credenciales;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;
import java.util.Map;

import static com.sofka.saucedemo.utils.MemoriaActor.PRODUCTOS_SELECCIONADOS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CompraStepDefinitions {

    @DataTableType
    public Comprador comprador(Map<String, String> fila) {
        return new Comprador(fila.get("nombre"), fila.get("apellido"), fila.get("codigoPostal"));
    }

    @Dado("que {string} inició sesión en SauceDemo con el usuario {string}")
    public void inicioSesion(String nombreActor, String usuario) {
        Actor actor = theActorCalled(nombreActor);
        actor.wasAbleTo(
                AbrirTienda.sauceDemo(),
                IniciarSesion.con(usuario, Credenciales.clave())
        );
        actor.attemptsTo(
                Ensure.that(TituloInventario.visible()).isEqualTo("Products")
        );
    }

    @Y("agregó al carrito los productos:")
    public void agregoProductos(List<String> productos) {
        Actor actor = theActorInTheSpotlight();
        actor.wasAbleTo(AgregarProductos.alCarrito(productos));
        actor.remember(PRODUCTOS_SELECCIONADOS, productos);
    }

    @Cuando("visualiza el carrito de compras")
    public void visualizaCarrito() {
        theActorInTheSpotlight().attemptsTo(VerCarrito.deCompras());
    }

    @Entonces("debería ver en el carrito los productos agregados")
    public void deberiaVerProductosAgregados() {
        Actor actor = theActorInTheSpotlight();
        List<String> productosSeleccionados = actor.recall(PRODUCTOS_SELECCIONADOS);
        actor.attemptsTo(
                Ensure.that(ProductosEnCarrito.nombres())
                        .containsExactlyInAnyOrderElementsFrom(productosSeleccionados)
        );
    }

    @Cuando("completa el formulario de compra con sus datos:")
    public void completaFormulario(List<Comprador> compradores) {
        theActorInTheSpotlight().attemptsTo(CompletarFormularioCompra.con(compradores.get(0)));
    }

    @Y("finaliza la compra")
    public void finalizaCompra() {
        theActorInTheSpotlight().attemptsTo(FinalizarCompra.desdeElResumen());
    }

    @Entonces("debería ver el mensaje de confirmación {string}")
    public void deberiaVerMensajeConfirmacion(String mensajeEsperado) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(MensajeConfirmacion.deLaOrden()).containsIgnoringCase(mensajeEsperado)
        );
    }
}
