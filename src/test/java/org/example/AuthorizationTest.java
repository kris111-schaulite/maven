package org.example;

import com.sun.deploy.cache.BaseLocalApplicationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AuthorizationTest extends AbstractTest{

    @Test
    @DisplayName("Авторизация")
    public void authorization() {
        driver.get("https://spb.espartos.ru/auth/");
        new AuthorizationPage(getWebDriver()).loginIn("kristjaschaulite@gmail.com","123456789");

//
////        driver.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
//        driver.findElement(By.name("USER_LOGIN")).sendKeys("kristjaschaulite@gmail.com");
//        driver.findElement(By.name("USER_PASSWORD")).sendKeys("123456789");
//        driver.findElement(By.name("Login")).click();

        Assertions.assertTrue(driver.getCurrentUrl().equals("https://spb.espartos.ru/"));

//        driver.close();
    }

}
