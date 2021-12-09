package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends AbstractPage {

    @FindBy(name="USER_LOGIN")
    private WebElement login;

    @FindBy(name="USER_PASSWORD")
    private WebElement password;

    @FindBy(name="Login")
    private WebElement enter;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }
    public void loginIn(String login, String password) {
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        this.enter.click();
    }
}
