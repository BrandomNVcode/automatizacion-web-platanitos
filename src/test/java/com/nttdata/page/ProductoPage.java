package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductoPage {

    public static By textCaracteristicas = By.xpath("//div[contains(text(),'Características')]");
    public static By btnAgregarACarrito = By.xpath("//button[@id='btn_add_cart_full']");

    public static By carrito = By.xpath("//a[@id='IconCar']");

}
