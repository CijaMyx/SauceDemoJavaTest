package com.saucedemo.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void orderItems () {
    driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
    driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
    driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
    }

    public void clickCartButton () {
    driver.findElement(By.xpath("//div[@class='shopping_cart_container']")).click();

}
}