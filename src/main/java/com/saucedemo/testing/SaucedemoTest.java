package com.saucedemo.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class SaucedemoTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ivan\\Documents\\Projects\\chromedriver.exe"); // Update with your ChromeDriver path
        
        //Disable Change your Password alert
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        
        
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Create instances of the page classes
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CheckOutPage cartPage = new CheckOutPage(driver);

        // Perform login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        // Order items
        homePage.orderItems();
        // Click on the cart button
        homePage.clickCartButton();
        //Check Cart items
        cartPage.checkOrders();
        cartPage.checkOutButton();
        cartPage.checkOutInfo("Will", "Smith", "1029");
    }
}
