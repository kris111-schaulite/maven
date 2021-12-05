package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CheckoutTest {
    @BeforeAll
    public static void connection() { WebDriverManager.chromedriver().setup(); }

    private WebDriver driver;

    @BeforeEach
    public void DriverInstance() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Оформление заказа")
    public void checkout() {
        driver.get("https://spb.espartos.ru/search/?q=30110");

        driver.findElement(By.className("item_link")).click();
        driver.findElement(By.className("to_basket_btn")).click();
        driver.findElement(By.className("round_icon_wrp")).click();

        driver.get("https://spb.espartos.ru/cart/");

        driver.findElement(By.id("ORDER_PROP_2")).sendKeys("Петров Иван");
        driver.findElement(By.id("ORDER_PROP_4")).sendKeys("89213456767");
        driver.findElement(By.id("ORDER_PROP_3")).sendKeys("Kristjaschaulite@gmail.com");

        driver.findElement(By.className("jq-selectbox__select-text")).click();
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Санкт");
        driver.findElement(By.xpath("//li[896]")).click();

        driver.findElement(By.name("ORDER_PROP_5")).sendKeys("Савушкина 88 33");

        driver.findElement(By.xpath("//*[@id=\"ORDER_FORM\"]/div[2]/div[2]/input")).click();

        String actualString = driver.findElement(By.xpath("//div[@id='order_form_div']/div/div/h2")).getText();
        Assert.assertTrue(actualString.contains("УСПЕШНО ОФОРМЛЕН"));

//        driver.close();
    }
}
