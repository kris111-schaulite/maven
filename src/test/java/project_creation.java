import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class project_creation {

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

            driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
            driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
            driver.findElement(By.id("_submit")).click();

            driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span")).click();
            driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span")).click();
            driver.findElement(By.linkText("Мои проекты")).click();
            driver.findElement(By.linkText("Создать проект")).click();

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

        }
    }
