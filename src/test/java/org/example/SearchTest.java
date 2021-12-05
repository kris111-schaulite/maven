package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SearchTest {

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
    @DisplayName("Поиск на странице")
    public void searchOnPage() {
        driver.get("https://spb.espartos.ru");

        driver.findElement(By.name("q")).sendKeys("30110");
        driver.findElement(By.className("btn_search")).click();
        driver.findElement(By.className("flag_wrp")).click();

        Assertions.assertTrue(driver.getCurrentUrl().equals("https://spb.espartos.ru/oboi/germaniya/marburg/bombay-exclusive/30110.html"));

//        driver.close();
    }
}






