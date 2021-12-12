package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

@Disabled
public class ProjectCreation_CRM_Test {

    @BeforeAll
    public static void connection() {
        WebDriverManager.chromedriver().setup();
    }

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

        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

    @Test
    @DisplayName("Переход в мои проеты")
    public void transitionToMyProjects() {
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span")).click();
        driver.findElement(By.linkText("Мои проекты")).click();

    }

    @Test
    @DisplayName("Создание проекта")
    public void projectCreation() {
        driver.findElement(By.linkText("Создать проект")).click();
    }


    @Test
    @DisplayName("Заполнение полей")
    public void fillInTheFields() {
        driver.findElement(By.name("crm_project[name]")).sendKeys("Test_Panova");
        driver.findElement(By.linkText("Укажите организацию")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("Alya");
        driver.findElement(By.className("select2-result-label")).click();

        Select business = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        business.selectByVisibleText("Research & Development");

        Select curator = new Select(driver.findElement(By.name("crm_project[curator]")));
        curator.selectByVisibleText("Зайдуллин Рустам");

        Select project = new Select(driver.findElement(By.name("crm_project[rp]")));
        project.selectByVisibleText("Закутина Татьяна");

        Select manager = new Select(driver.findElement(By.name("crm_project[manager]")));
        manager.selectByVisibleText("Митрофанов Никита");

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

//
//        Assertions.assertTrue(driver.getCurrentUrl().equals("ссылка на созданный нами проект"));

    }
}
