#language: es
@test
Característica: Agregar un producto al carrito de compras en Platanitos
  Yo, como usuario logeado
  Quiero, poder agregar un producto a mi carrito de compras
  Para poder comprarlo


  Antecedentes: Iniciar sesión
    Dado en la página de login de Platanitos
    Cuando ingreso mis credenciales de inicio sesión con usuario "noriegaverab@gmail.com" y contraseña "vortexBRANDOM98i"
    Y doy clic en el boton INICIAR SESIÓN
    Y valido que aparesca el nombre de usuario "Brandom Marcelo Noriega Vera"


  Escenario: Agregar un producto al carrito
    Cuando doy clic en el apartado de ofertas
    Entonces valido el titulo de "Ofertas" de la pagina
    Y doy clic en ofertas de sandalias
    Entonces valido el mensaje "Mujeres > zapatos > sandalias" y de que exista productos
    Cuando selecciono el primer producto dando clic
    Entonces valido que debe de aparecer el texto "Características" para el producto
    Y doy clic en el boton de AGREGAR AL CARRITO
    Cuando doy clic en el carrito para ver el producto
    Entonces valido el titulo "Carrito" de la pagina
    Y valido que exista el produto

