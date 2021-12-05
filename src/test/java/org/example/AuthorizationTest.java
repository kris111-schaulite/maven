package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AuthorizationTest {

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
    @DisplayName("Авторизация")
    public void authorization() {
        driver.get("https://spb.espartos.ru");

        driver.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
        driver.findElement(By.name("USER_LOGIN")).sendKeys("kristjaschaulite@gmail.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("123456789");
        driver.findElement(By.name("Login")).click();

        Assertions.assertTrue(driver.getCurrentUrl().equals("https://spb.espartos.ru/"));

//        driver.close();
    }
}
