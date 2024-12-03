package ru.maksmusic.selenium;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SelenTest {


    @Test
    public void checkout() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        WebElement elementUsername = driver.findElement(By.name("user-name"));
        WebElement elementUserPassword= driver.findElement(By.name("password"));

        elementUsername.sendKeys("standard_user");
        elementUserPassword.sendKeys("secret_sauce");


        driver.findElement(By.cssSelector("[type=submit]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement successMessage = driver.findElement(By.cssSelector("span.title"));
        Assertions.assertTrue(successMessage.isDisplayed());
        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
