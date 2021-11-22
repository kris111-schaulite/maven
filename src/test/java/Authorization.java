import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Authorization {
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

        driver.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
        driver.findElement(By.name("USER_LOGIN")).sendKeys("kristjaschaulite@gmail.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("123456789");
        driver.findElement(By.name("Login")).click();
    }
}
