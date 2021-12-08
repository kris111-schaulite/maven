package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends AbstractPage {
//
//    @FindBy(xpath="//a[contains(text(),'Войти')]")
//    private WebElement loginButton;

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
//        Actions loginIn = new Actions(getDriver());
        this.login.sendKeys();
        this.password.sendKeys();
        this.enter.click();
    }
}
