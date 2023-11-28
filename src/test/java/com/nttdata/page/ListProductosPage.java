package com.nttdata.page;

import org.openqa.selenium.By;

public class ListProductosPage {

    public static By textPage = By.xpath("//h1[contains(text(),'Mujeres > zapatos > sandalias')]");
    public static By listProductos = By.xpath("//body/div[@id='body-productos']/div[4]/div[2]/div[2]/div[1]/div[1]");

    // selecciono un producto que aparesca
    public static By producto = By.xpath("//body/div[@id='body-productos']/div[4]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]");


}
