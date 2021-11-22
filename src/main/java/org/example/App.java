package org.example;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
//        System.setProperty(
//                "webdriver.chrome.driver", "src/main/resources/chromedriver"
//        );
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("Incognito");
//        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://crm.geekbrains.space/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("user");
        driver.findElement(By.id("prependedInput2")).sendKeys("1234");
        driver.findElement(By.id("_submit")).click();

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/ul/li[5]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div/div/div[2]/div/div/a")).click();

        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Панова");
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Кристина");
        driver.findElement(By.className("select2-chosen")).click();
        driver.findElement(By.className("select2-input")).sendKeys("Alya");
        driver.findElement(By.className("select2-match")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("тестировщик");
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
    }
}


//        driver.quit();


//    public static ExpectedCondition<WebElement> presenceOfElementLocated (final By locator) {
//        return new ExpectedCondition<WebElement>() {
//            @Override
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(locator);
//            }
//
//            @Override
//            public String toString() {
//                return "presence of element located by: " + locator;
//            }
//        };