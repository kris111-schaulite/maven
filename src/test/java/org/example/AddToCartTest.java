package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddToCartTest {

    @BeforeAll
    public static void connection() { WebDriverManager.chromedriver().setup(); }

    private WebDriver driver;

    @BeforeEach
    public void DriverInstance() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }


    @Test
    @DisplayName("Добавление в корзину")
    public void AddToCart() {
        driver.get("https://spb.espartos.ru/search/?q=30110");

        driver.findElement(By.className("item_link")).click();
        driver.findElement(By.className("to_basket_btn")).click();
        driver.findElement(By.className("round_icon_wrp")).click();

        driver.get("https://spb.espartos.ru/cart/");

        String actualString = driver.findElement(By.xpath("//a[contains(.,'30110')]")).getText();
        Assert.assertTrue(actualString.contains("30110"));

        //        driver.close();
    }
}
