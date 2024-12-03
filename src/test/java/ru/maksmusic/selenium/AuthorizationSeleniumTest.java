package ru.maksmusic.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthorizationSeleniumTest {
    @Test
    public void checkout() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement elementUsername = driver.findElement(By.name("username"));
        WebElement elementUserPassword=driver.findElement(By.name("password"));

        elementUsername.sendKeys("tomsmith");
        elementUserPassword.sendKeys("SuperSecretPassword!");


        driver.findElement(By.cssSelector("button[type=submit]")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));
        Assertions.assertTrue(successMessage.isDisplayed());
        driver.quit();

    }
}
