package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorizationTest extends AbstractTest{

    @Test
    @DisplayName("Авторизация")
    public void authorization() {
        driver.get("https://spb.espartos.ru/auth/");
        new AuthorizationPage(getDriver()).loginIn("vahoji2805@ningame.com","987654321");
        Assertions.assertTrue(driver.getCurrentUrl().equals("https://spb.espartos.ru/"));
    }


}
