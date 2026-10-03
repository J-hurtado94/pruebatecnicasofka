package com.sofka.saucedemo.models;

/**
 * Datos de envío que el comprador diligencia en el checkout.
 */
public record Comprador(String nombre, String apellido, String codigoPostal) {
}
