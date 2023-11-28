package com.nttdata.steps;

import com.nttdata.page.OfertasPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class OfertasSteps {

    private WebDriver driver;

    //constructor
    public OfertasSteps(WebDriver driver){
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
    }


    public void validarTituloOfertas(String expect) {
        String titulo = this.driver.findElement(OfertasPage.textOfertas).getText();
        Assertions.assertEquals(titulo, expect);
    }

    public void ir_a_ofertas_sandalias() {
        this.driver.findElement(OfertasPage.ofertasRopa).click();
    }


}
