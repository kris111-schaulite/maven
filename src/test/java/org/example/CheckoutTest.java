package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CheckoutTest extends AbstractTest{

    @Test
    @DisplayName("Оформление заказа")
    public void checkout() {
        driver.get("https://spb.espartos.ru/oboi/germaniya/marburg/bombay-exclusive/30110.html");

        new CheckoutPage(getDriver()).order("vahoji2805@ningame.com","987654321","vahoji2805@ningame.com","Санкт","Московский пр-т 10 кв 3");

        driver.get("https://spb.espartos.ru/cart/");

        String actualString = driver.findElement(By.xpath("//div[@id='order_form_div']/div/div/h2")).getText();
        Assertions.assertTrue(actualString.contains("УСПЕШНО ОФОРМЛЕН"));
    }
}
