package com.nttdata.steps;

import com.nttdata.page.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarritoSteps {

    private WebDriver driver;

    //constructor
    public CarritoSteps(WebDriver driver){
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
    }


    public void validarTextoCarrito(String expect) {
        String texto = this.driver.findElement(CarritoPage.textCarrito).getText();
        Assertions.assertEquals(texto, expect);
    }

    public void validarQueExistaElProducto() {
        List<WebElement> items = this.driver.findElements(CarritoPage.listaProductos);
        int cantidad = items.size();
        Assertions.assertTrue(cantidad > 0, "El tamaño es: " + cantidad);
    }


}
