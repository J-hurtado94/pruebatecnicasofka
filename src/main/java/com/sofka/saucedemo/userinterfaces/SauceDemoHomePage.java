package com.sofka.saucedemo.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;

/**
 * Punto de entrada de la aplicación. La URL se puede sobreescribir con la propiedad webdriver.base.url.
 */
@DefaultUrl("https://www.saucedemo.com")
public class SauceDemoHomePage extends PageObject {
}
