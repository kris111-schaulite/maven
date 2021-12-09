package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest extends AbstractTest {

    @Test
    @DisplayName("Поиск на странице")
    public void searchOnPage() {
        driver.get("https://spb.espartos.ru");

        new SearchPage(getDriver()).search("30110");

//        driver.get("https://spb.espartos.ru/auth/");

        Assertions.assertTrue(driver.getCurrentUrl().equals("https://spb.espartos.ru/oboi/germaniya/marburg/bombay-exclusive/30110.html"));
    }
}


