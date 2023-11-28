package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
    }


    public void ir_a_platanitos_url() {
        this.driver.get("https://platanitos.com/iniciar-sesion");
    }

    public void ingresarCredenciales(String email, String password) {
        this.driver.findElement(LoginPage.inputEmail).sendKeys(email);
        this.driver.findElement(LoginPage.inputPassword).sendKeys(password);
    }

    public void clicBtnIngresar() {
        this.driver.findElement(LoginPage.btnIngresar).click();
    }

}
