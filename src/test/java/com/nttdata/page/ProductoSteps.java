package com.nttdata.steps;

import com.nttdata.page.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProductoSteps {

    private WebDriver driver;

    //constructor
    public ProductoSteps(WebDriver driver){
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
    }


    public void validarTextoCaracteristicas(String expect) {
        String texto = this.driver.findElement(ProductoPage.textCaracteristicas).getText();
        Assertions.assertEquals(texto, expect);
    }

    public void agregarACarrito() {
        this.driver.findElement(ProductoPage.btnAgregarACarrito).click();
    }

    public void ir_a_carrito_de_compras() {
        this.driver.findElement(ProductoPage.carrito).click();
    }

}
