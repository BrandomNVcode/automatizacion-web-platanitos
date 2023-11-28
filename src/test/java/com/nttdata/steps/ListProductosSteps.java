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

public class ListProductosSteps {

    private WebDriver driver;

    //constructor
    public ListProductosSteps(WebDriver driver){
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
    }


    public void validarMensajeYCantidadDeProductos(String expect) {
        String titulo = this.driver.findElement(ListProductosPage.textPage).getText();
        Assertions.assertEquals(titulo, expect);

        List<WebElement> items = this.driver.findElements(ListProductosPage.listProductos);
        int cantidad = items.size();

        Assertions.assertTrue(cantidad > 0, "El tamaño es: " + cantidad);
    }

    public void selecionarProducto() {
        this.driver.findElement(ListProductosPage.producto).click();
    }


}
