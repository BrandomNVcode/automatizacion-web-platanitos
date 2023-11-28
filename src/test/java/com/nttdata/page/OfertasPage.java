package com.nttdata.page;

import org.openqa.selenium.By;

public class OfertasPage {

    public static By textOfertas = By.xpath("//h1[contains(text(),'Ofertas')]");

    public static By ofertasRopa = By.xpath("//body/div[@id='body-Ofertas']/div[3]/div[1]/div[1]/div[1]/a[1]");

    // Selecciono el primer producto que muestra
    public static By producto = By.xpath("//body[1]/div[6]/div[6]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

}
