package com.nttdata.page;

import org.openqa.selenium.By;

public class CarritoPage {

    public static By textCarrito = By.xpath("//h1[contains(text(),'Carrito')]");

    public static By listaProductos = By.xpath("//body/div[@id='body-Carrito']/main[1]/div[1]/div[1]");

}
