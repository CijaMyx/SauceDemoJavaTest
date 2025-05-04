package com.saucedemo.testing;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckOutPage {
    WebDriver driver;

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By checkOutBtn = By.id("checkout"); 

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkOrders () {

        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));

        for (WebElement item : cartItems) {
        String itemName = item.findElement(By.className("inventory_item_name")).getText();
        String itemPrice = item.findElement(By.className("inventory_item_price")).getText();
    
        System.out.println("Item: " + itemName + " | Price: " + itemPrice); 
        }
    }
        /* public void checkOrders () {

        List<String> expectedItems = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt");
        List<WebElement> actualElements = driver.findElements(By.className("cart_item"));
        List<String> actualItems = actualElements.stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());

            for (String expectedItem : expectedItems) {
                System.out.println("Actual Item found " + actualItems);
                Assertions.assertTrue(actualItems.contains(expectedItem), "Missing Item:" + expectedItems);
            }       
        } */

    public void checkOutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn));
        driver.findElement(checkOutBtn).click();
        }

    public void checkOutInfo (String firstname, String lastname, String postalcode) {
        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(lastName).sendKeys(lastname);
        driver.findElement(postalCode).sendKeys(postalcode);

    }
}