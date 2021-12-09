package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AddToCartTest extends AbstractTest{

    @Test
    @DisplayName("Добавление в корзину")
    public void basket() {
        driver.get("https://spb.espartos.ru/oboi/germaniya/marburg/bombay-exclusive/30110.html");
        new AddToCartPage(getDriver()).add();


//        driver.findElement(By.className("item_link")).click();
//        driver.findElement(By.className("to_basket_btn")).click();
//        driver.findElement(By.className("round_icon_wrp")).click();

        driver.get("https://spb.espartos.ru/cart/");

        String actualString = driver.findElement(By.xpath("//a[contains(.,'30110')]")).getText();
        Assertions.assertTrue(actualString.contains("30110"));

        //        driver.close();
    }
}
