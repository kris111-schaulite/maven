package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {

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

        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user");
        driver.findElement(By.id("prependedInput2")).sendKeys("1234");
        driver.findElement(By.id("_submit")).click();
    }

    @Test
    @DisplayName("Переход в контакное лицо")
    public void contactPersons() {

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/ul/li[5]/a/span")).click();
    }

    @Test
    @DisplayName("Нажатие на кнопку Контактное лицо")
    public void buttonCreateContactPerson() {

        driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div/div/div[2]/div/div/a")).click();
    }

    @Test
    @DisplayName("Заполнить обязательные поля")
    public void FillingInTheFields () {

        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Панова");
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Кристина");
        driver.findElement(By.className("select2-chosen")).click();
        driver.findElement(By.className("select2-input")).sendKeys("Alya");
        driver.findElement(By.className("select2-match")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("тестировщик");
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

//        Assertions.assertTrue(driver.getCurrentUrl().equals("https://crm.geekbrains.......")); ссылка на созданное контактное лицо

//        driver.quit();
    }
}



