package com.nttdata.steps;

import com.nttdata.page.CuentaPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CuentaSteps {

    private WebDriver driver;

    //constructor
    public CuentaSteps(WebDriver driver){
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
    }


    public void validarNombreUsuario(String expect) {
        System.out.println("EXPECT:" + expect);
        String nombre = this.driver.findElement(CuentaPage.nombreUsuario).getText();
        System.out.println("NOMBRE:" + nombre);
        Assertions.assertEquals(nombre, expect);
    }

    public void ir_a_ofertas() {
        this.driver.findElement(CuentaPage.ofertas).click();
    }

}
