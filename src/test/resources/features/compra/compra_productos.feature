# language: es
@compra
Característica: Compra de productos en SauceDemo
  Como cliente de la tienda Swag Labs
  Quiero comprar productos en línea
  Para recibirlos en mi domicilio

  @e2e
  Escenario: Compra exitosa de dos productos con el usuario estándar
    Dado que "Juan" inició sesión en SauceDemo con el usuario "standard_user"
    Y agregó al carrito los productos:
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    Cuando visualiza el carrito de compras
    Entonces debería ver en el carrito los productos agregados
    Cuando completa el formulario de compra con sus datos:
      | nombre | apellido | codigoPostal |
      | Juan   | Hurtado  | 050001       |
    Y finaliza la compra
    Entonces debería ver el mensaje de confirmación "THANK YOU FOR YOUR ORDER"
