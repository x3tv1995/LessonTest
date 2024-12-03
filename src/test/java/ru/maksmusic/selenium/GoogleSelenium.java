package ru.maksmusic.selenium;


    import org.junit.jupiter.api.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSelenium {


    @Test
    public void testGoogle() {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.com");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        By by = By.name("q");
        WebElement element = chromeDriver.findElement(by);
        element.sendKeys("погода тайланд");
        element.submit();

        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        chromeDriver.quit();

    }
}
