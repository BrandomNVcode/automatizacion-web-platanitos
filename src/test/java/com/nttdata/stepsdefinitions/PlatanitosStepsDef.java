package com.nttdata.stepsdefinitions;

import com.nttdata.steps.*;
import com.nttdata.steps.ProductoSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlatanitosStepsDef {

    private WebDriver driver;
    private Scenario scenario;
    LoginSteps loginSteps;
    CuentaSteps cuentaSteps;
    OfertasSteps ofertasSteps;
    ProductoSteps productoSteps;
    ListProductosSteps listProductosSteps;
    CarritoSteps carritoSteps;


    @Before(order = 0)
    public void setUp(){
        // setUp
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        // crear el driver
        this.driver = new ChromeDriver();
        // maximizar la pantalla
        this.driver.manage().window().maximize();

        this.loginSteps = new LoginSteps(this.driver);
        this.cuentaSteps = new CuentaSteps(this.driver);
        this.ofertasSteps = new OfertasSteps(this.driver);
        this.productoSteps = new ProductoSteps(this.driver);
        this.listProductosSteps = new ListProductosSteps(this.driver);
        this.carritoSteps = new CarritoSteps(this.driver);

    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }



    /*
    BACKGROUND: Iniciar Sesion
    * */

    @Dado("en la página de login de Platanitos")
    public void en_la_pagina_de_login_de_Linio() {
        this.loginSteps.ir_a_platanitos_url();
        this.screenShot();
    }

    @Cuando("ingreso mis credenciales de inicio sesión con usuario {string} y contraseña {string}")
    public void ingresoMisCredencialesConUsuarioYContrasenia(String usuario, String password) {
        this.loginSteps.ingresarCredenciales(usuario, password);
        this.screenShot();
    }

    @Y("doy clic en el boton INICIAR SESIÓN")
    public void doyClicEnElBotonIngresar() {
        this.loginSteps.clicBtnIngresar();
        try { // espero un tiempo para q carge la nueva pagina
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Y("valido que aparesca el nombre de usuario {string}")
    public void validoQueAlMenosExistaUnItem(String nombre) {
        this.cuentaSteps.validarNombreUsuario(nombre);
        screenShot();
    }

    @Cuando("doy clic en el apartado de ofertas")
    public void doyClicEnElApartadoDeOfertas() {
        this.cuentaSteps.ir_a_ofertas();
        try { // espero un tiempo para q carge la nueva pagina
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Entonces("valido el titulo de {string} de la pagina")
    public void validoElTituloDeDeLaPagina(String titulo) {
        this.ofertasSteps.validarTituloOfertas(titulo);
        screenShot();
    }

    @Y("doy clic en ofertas de sandalias")
    public void doyClicEnOfertasDeSandalias() {
        this.ofertasSteps.ir_a_ofertas_sandalias();
        try { // espero un tiempo para q carge la nueva pagina
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Entonces("valido el mensaje {string} y de que exista productos")
    public void validoElMensajeYDeQueExistaProductos(String mensaje) {
        this.listProductosSteps.validarMensajeYCantidadDeProductos(mensaje);
        this.screenShot();
    }

    @Cuando("selecciono el primer producto dando clic")
    public void seleccionoUnProductoDandoClic() {
        this.listProductosSteps.selecionarProducto();
        try { // espero un tiempo para q carge la nueva pagina
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Entonces("valido que debe de aparecer el texto {string} para el producto")
    public void validoQueDebeDeAparecerElTextoParaElProducto(String texto) {
        this.productoSteps.validarTextoCaracteristicas(texto);
        this.screenShot();
    }

    @Y("doy clic en el boton de AGREGAR AL CARRITO")
    public void doyClicEnElBotonDeAGREGARALCARRITO() {
        this.productoSteps.agregarACarrito();
        this.screenShot();
    }

    @Cuando("doy clic en el carrito para ver el producto")
    public void doyClicEnElCarritoParaVerElProducto() {
        this.productoSteps.ir_a_carrito_de_compras();
        try { // espero un tiempo para q carge la nueva pagina
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Entonces("valido el titulo {string} de la pagina")
    public void validoElTituloDeLaPagina(String texto) {
        this.carritoSteps.validarTextoCarrito(texto);
        this.screenShot();
    }

    @Y("valido que exista el produto")
    public void validoQueExistaElProduto() {
        this.carritoSteps.validarQueExistaElProducto();
    }

}
