import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Search {
    public static void main(String[] args) {
//        System.setProperty(
//                "webdriver.chrome.driver", "src/main/resources/chromedriver"
//        );
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("Incognito");
//        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://spb.espartos.ru");

        driver.findElement(By.name("q")).sendKeys("3011");
        driver.findElement(By.className("btn_search")).click();
        driver.findElement(By.cssSelector("css=li:nth-child(1) > .item_link"));
    }
}
